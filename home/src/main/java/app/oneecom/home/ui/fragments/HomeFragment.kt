package app.oneecom.home.ui.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import app.oneecom.core.extentions.TAG
import app.oneecom.core.ui.CoreFragment
import app.oneecom.home.R
import app.oneecom.home.databinding.FragmentHomeBinding
import app.oneecom.home.ui.viewmodels.HomeFragmentViewModel

class HomeFragment : CoreFragment<FragmentHomeBinding, HomeFragmentViewModel>(
    layoutId = R.layout.fragment_home
) {
    override val logTAG: String = TAG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onInitDependencyInjection() {

    }

    override fun onInitDataBinding() {
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_fragment_home, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}
