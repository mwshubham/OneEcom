package app.oneecom.home.ui.profile

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
        viewBinding.viewModel = viewModel
    }
}