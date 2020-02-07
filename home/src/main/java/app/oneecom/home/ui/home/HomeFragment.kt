package app.oneecom.home.ui.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import app.oneecom.core.extentions.TAG
import app.oneecom.core.extentions.observe
import app.oneecom.core.ui.CharacterDetailViewState
import app.oneecom.core.ui.CoreFragment
import app.oneecom.core.ui.views.ProgressBarDialog
import app.oneecom.home.R
import app.oneecom.home.databinding.FragmentHomeBinding
import app.oneecom.home.ui.home.adapter.HomeRvAdapter
import timber.log.Timber
import javax.inject.Inject

class HomeFragment : CoreFragment<FragmentHomeBinding, HomeFragmentViewModel>(
    layoutId = R.layout.fragment_home
) {
    override val logTAG: String = TAG

    @Inject
    lateinit var str: String

    @Inject
    lateinit var appContext: Context

    // todo make it injectable...
    private val progressDialog: ProgressBarDialog by lazy {
        ProgressBarDialog(context!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.i("str: $str@${str.hashCode()}")
        Timber.i("appContext: $appContext")
    }

    override fun onInitDependencyInjection() {

    }

    override fun onInitDataBinding() {
        context ?: return
        viewBinding.rvHome.adapter = HomeRvAdapter(context!!)
        observe(viewModel.state, ::onViewStateChange)
        viewModel.loadCharacterDetail(1011334L)
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
                progressDialog.show(R.string.character_detail_dialog_loading_text)
            is CharacterDetailViewState.Error ->
                progressDialog.dismissWithErrorMessage(R.string.character_detail_dialog_error_text)
//            is CharacterDetailViewState.AddedToFavorite ->
//                Snackbar.make(
//                    requireView(),
//                    R.string.character_detail_added_to_favorite_message,
//                    Snackbar.LENGTH_LONG
//                ).show()
            is CharacterDetailViewState.Dismiss ->
                findNavController().navigateUp()
            else -> progressDialog.dismiss()
        }
    }

}
