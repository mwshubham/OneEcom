package app.oneecom.categories.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import app.oneecom.categories.R
import app.oneecom.categories.databinding.FragmentCategoriesBinding
import app.oneecom.core.extentions.TAG
import app.oneecom.core.ui.CoreFragment

class CategoriesFragment : CoreFragment<FragmentCategoriesBinding, CategoriesViewModel>(
    R.layout.fragment_categories
) {

    override val logTAG: String = TAG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_fragment_categories, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onInitDependencyInjection() {
    }

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
    }
}