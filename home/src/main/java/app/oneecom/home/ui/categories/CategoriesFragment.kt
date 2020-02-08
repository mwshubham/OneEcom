package app.oneecom.home.ui.categories

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
        viewBinding.viewModel = viewModel
    }
}