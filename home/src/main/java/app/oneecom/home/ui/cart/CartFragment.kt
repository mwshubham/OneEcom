package app.oneecom.home.ui.cart

import app.oneecom.core.extentions.TAG
import app.oneecom.core.ui.CoreFragment
import app.oneecom.home.R
import app.oneecom.home.databinding.FragmentCartBinding

class CartFragment : CoreFragment<FragmentCartBinding, CartViewModel>(
    layoutId = R.layout.fragment_cart
) {

    override val logTAG: String = TAG

    override fun onInitDependencyInjection() {

    }

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
    }
}