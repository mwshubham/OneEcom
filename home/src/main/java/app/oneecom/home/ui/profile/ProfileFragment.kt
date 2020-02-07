package app.oneecom.home.ui.profile

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.oneecom.core.extentions.TAG
import app.oneecom.core.ui.CoreFragment
import app.oneecom.home.R
import app.oneecom.home.databinding.FragmentProfileBinding

class ProfileFragment : CoreFragment<FragmentProfileBinding, ProfileViewModel>(
    R.layout.fragment_profile
) {

    override val logTAG: String = TAG

    override fun onInitDependencyInjection() {
    }

    override fun onInitDataBinding() {
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        viewModel.text.observe(this, Observer {
            viewBinding.textProfile.text = it
        })
    }
}