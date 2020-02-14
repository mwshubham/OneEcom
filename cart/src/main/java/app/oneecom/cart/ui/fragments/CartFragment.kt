package app.oneecom.cart.ui.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import app.oneecom.cart.R
import app.oneecom.cart.databinding.FragmentCartBinding
import app.oneecom.cart.ui.viewmodels.CartViewModel
import app.oneecom.core.extentions.TAG
import app.oneecom.core.ui.CoreFragment

class CartFragment : CoreFragment<FragmentCartBinding, CartViewModel>(
    layoutId = R.layout.fragment_cart
) {

    override val logTAG: String = TAG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_fragment_cart, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onInitDependencyInjection() {

    }

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
    }
}