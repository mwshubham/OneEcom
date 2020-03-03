package app.oneecom.category.ui.activities

import android.os.Bundle
import app.oneecom.category.R
import app.oneecom.category.databinding.ActivityProductListingBinding
import app.oneecom.category.ui.viewmodels.ProductListingViewModel
import app.oneecom.core.extentions.TAG
import app.oneecom.core.extentions.observe
import app.oneecom.core.network.responses.Product
import app.oneecom.core.ui.CoreActivity
import app.oneecom.core.ui.GenericViewState
import app.oneecom.core.ui.views.ProgressBarDialog

class ProductListingActivity :
    CoreActivity<ActivityProductListingBinding, ProductListingViewModel>(R.layout.activity_product_listing) {

    override val logTAG: String
        get() = TAG

    @Suppress("MemberVisibilityCanBePrivate")
    lateinit var progressDialog: ProgressBarDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.viewModel = viewModel

        progressDialog = ProgressBarDialog(this)
        viewBinding.viewModel = viewModel
        observe(viewModel.state, ::onViewStateChange)
        observe(viewModel.data, ::onDataChange)
        viewModel.getCategory()
    }

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
            else -> {
                finish()
            }
        }
    }

    private fun onDataChange(@Suppress("UNUSED_PARAMETER") productList: List<Product>) {

//        viewBinding.rvCategoriesMain.adapter =
//            CategoriesMainAdapter(
//                context!!,
//                viewModel,
//                categoryList
//            ) { category: Category ->
//                context ?: return@CategoriesMainAdapter
//                category.child ?: return@CategoriesMainAdapter
//                viewBinding.rvCategoriesSubSubCategory.adapter =
//                    SubSubCategoriesAdapter(context!!, category.child!!)
//            }
    }
}
