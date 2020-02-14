package app.oneecom.profile.ui.fragments

import app.oneecom.core.extentions.TAG
import app.oneecom.core.ui.CoreFragment
import app.oneecom.profile.R
import app.oneecom.profile.databinding.FragmentProfileBinding
import app.oneecom.profile.ui.viewmodels.ProfileViewModel

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