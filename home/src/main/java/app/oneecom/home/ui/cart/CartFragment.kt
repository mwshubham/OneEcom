package app.oneecom.home.ui.cart

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.oneecom.core.extentions.TAG
import app.oneecom.core.ui.CoreFragment
import app.oneecom.home.R
import app.oneecom.home.databinding.FragmentCartBinding

class CartFragment : CoreFragment<FragmentCartBinding, CartViewModel>(
    layoutId = R.layout.fragment_cart
) {

    override val logTAG: String = TAG

    private lateinit var cartViewModel: CartViewModel

    override fun onInitDependencyInjection() {

    }

    override fun onInitDataBinding() {
        viewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        viewModel.text.observe(this, Observer {
            viewBinding.textCart.text = it
        })
    }
}