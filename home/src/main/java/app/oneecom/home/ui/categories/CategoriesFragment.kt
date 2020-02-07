package app.oneecom.home.ui.categories

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.oneecom.core.extentions.TAG
import app.oneecom.core.ui.CoreFragment
import app.oneecom.home.R
import app.oneecom.home.databinding.FragmentCategoriesBinding

class CategoriesFragment : CoreFragment<FragmentCategoriesBinding, CategoriesViewModel>(
    R.layout.fragment_categories
) {

    override val logTAG: String = TAG

    override fun onInitDependencyInjection() {
    }

    override fun onInitDataBinding() {
        viewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)
        viewModel.text.observe(this, Observer {
            viewBinding.textCategories.text = it
        })
    }
}