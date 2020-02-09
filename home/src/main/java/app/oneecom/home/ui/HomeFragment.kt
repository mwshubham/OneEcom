package app.oneecom.home.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.navigation.fragment.findNavController
import app.oneecom.core.extentions.TAG
import app.oneecom.core.extentions.observe
import app.oneecom.core.network.responses.CharacterDetail
import app.oneecom.core.ui.CharacterDetailViewState
import app.oneecom.core.ui.CoreFragment
import app.oneecom.core.ui.views.ProgressBarDialog
import app.oneecom.home.R
import app.oneecom.home.databinding.FragmentHomeBinding

class HomeFragment : CoreFragment<FragmentHomeBinding, HomeFragmentViewModel>(
    layoutId = R.layout.fragment_home
) {
    override val logTAG: String = TAG

    @Suppress("MemberVisibilityCanBePrivate")
    lateinit var progressDialog: ProgressBarDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onInitDependencyInjection() {

    }

    override fun onInitDataBinding() {
        context ?: return
//        viewBinding.rvHome.adapter = HomeRvAdapter(context!!)

        progressDialog = ProgressBarDialog(context!!)
        observe(viewModel.state, ::onViewStateChange)
        observe(viewModel.data, ::onDataChange)
        viewModel.loadCharacterDetail(1011334L)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_fragment_home, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    // ============================================================================================
    //  Private observers methods
    // ============================================================================================

    /**
     * Observer view state change on [CharacterDetailViewState].
     *
     * @param viewState State of character detail.
     */
    private fun onViewStateChange(viewState: CharacterDetailViewState) {
        when (viewState) {
            is CharacterDetailViewState.Loading ->
                progressDialog.show(R.string.loading_details)
            is CharacterDetailViewState.Error ->
                progressDialog.dismissWithMessage(R.string.error_on_obtain_detail_please_try_later)
            is CharacterDetailViewState.Dismiss ->
                findNavController().navigateUp()
            else -> progressDialog.dismiss()
        }
    }

    private fun onDataChange(@Suppress("UNUSED_PARAMETER") characterDetail: CharacterDetail) {
        progressDialog.dismissWithMessage(R.string.success)
    }

}
