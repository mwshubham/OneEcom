package app.oneecom.cart.ui

import app.oneecom.cart.R
import app.oneecom.cart.databinding.FragmentCartBinding
import app.oneecom.core.extentions.TAG
import app.oneecom.core.ui.CoreFragment

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