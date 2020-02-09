package app.oneecom.categories.ui

import app.oneecom.categories.R
import app.oneecom.categories.databinding.FragmentCategoriesBinding
import app.oneecom.core.extentions.TAG
import app.oneecom.core.ui.CoreFragment

class CategoriesFragment : CoreFragment<FragmentCategoriesBinding, CategoriesViewModel>(
    R.layout.fragment_categories
) {

    override val logTAG: String = TAG

    override fun onInitDependencyInjection() {
    }

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
    }
}