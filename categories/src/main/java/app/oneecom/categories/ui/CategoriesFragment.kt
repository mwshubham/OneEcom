package app.oneecom.categories.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.navigation.fragment.findNavController
import app.oneecom.categories.R
import app.oneecom.categories.databinding.FragmentCategoriesBinding
import app.oneecom.categories.ui.adapter.CategoriesMainAdapter
import app.oneecom.categories.ui.viewmodels.CategoriesViewModel
import app.oneecom.core.extentions.TAG
import app.oneecom.core.extentions.observe
import app.oneecom.core.network.responses.Category
import app.oneecom.core.ui.CoreFragment
import app.oneecom.core.ui.GenericViewState
import app.oneecom.core.ui.views.ProgressBarDialog

class CategoriesFragment : CoreFragment<FragmentCategoriesBinding, CategoriesViewModel>(
    R.layout.fragment_categories
) {

    override val logTAG: String = TAG

    @Suppress("MemberVisibilityCanBePrivate")
    lateinit var progressDialog: ProgressBarDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_fragment_categories, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onInitDependencyInjection() {
    }

    override fun onInitDataBinding() {
        context ?: return
//        viewBinding.rvHome.adapter = HomeRvAdapter(context!!)

        progressDialog = ProgressBarDialog(context!!)
        observe(viewModel.state, ::onViewStateChange)
        observe(viewModel.data, ::onDataChange)
        viewModel.getCategories()
    }

    // ============================================================================================
    //  Private observers methods
    // ============================================================================================

    /**
     * Observer view state change on [GenericViewState].
     *
     * @param viewState State of character detail.
     */
    private fun onViewStateChange(viewState: GenericViewState) {
        when (viewState) {
            is GenericViewState.Loading ->
                progressDialog.show(R.string.loading_details)
            is GenericViewState.Error ->
                progressDialog.dismissWithMessage(R.string.error_on_obtain_detail_please_try_later)
            is GenericViewState.Dismiss ->
                progressDialog.dismiss()
            else -> findNavController().navigateUp()
        }
    }

    private fun onDataChange(@Suppress("UNUSED_PARAMETER") categoryList: List<Category>) {
        viewBinding.rvCategoriesMain.adapter =
            CategoriesMainAdapter(context!!, categoryList)
    }

}