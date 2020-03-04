package app.oneecom.category.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import app.oneecom.category.R
import app.oneecom.category.databinding.ActivityProductListingBinding
import app.oneecom.category.ui.adapters.ProductAdapter
import app.oneecom.category.ui.viewmodels.ProductListingViewModel
import app.oneecom.core.constants.CoreBundleConstants
import app.oneecom.core.extentions.TAG
import app.oneecom.core.extentions.observe
import app.oneecom.core.network.responses.Category
import app.oneecom.core.network.responses.Product
import app.oneecom.core.ui.CoreActivity
import app.oneecom.core.ui.GenericViewState
import app.oneecom.core.ui.views.ProgressBarDialog

class ProductListingActivity :
    CoreActivity<ActivityProductListingBinding, ProductListingViewModel>(R.layout.activity_product_listing) {

    override val logTAG: String
        get() = TAG

    @Suppress("unused")
    private val category: Category
        get() = intent!!.getParcelableExtra(CoreBundleConstants.KEY_CATEGORY)!!

    @Suppress("MemberVisibilityCanBePrivate")
    lateinit var progressDialog: ProgressBarDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.viewModel = viewModel

        progressDialog = ProgressBarDialog(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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

        viewBinding.rvProducts.adapter =
            ProductAdapter(
                this,
                productList
            ) {

            }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_product_listing, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
