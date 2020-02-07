package app.oneecom.core.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class CoreActivity<B : ViewDataBinding, M : ViewModel>(
    @LayoutRes
    private val layoutId: Int
) : DaggerAppCompatActivity() {

    abstract val logTAG: String

    @Inject
    lateinit var viewModel: M
    lateinit var viewBinding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, layoutId)
    }

}