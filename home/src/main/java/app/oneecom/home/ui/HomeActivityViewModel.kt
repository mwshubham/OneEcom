package app.oneecom.home.ui

import androidx.lifecycle.ViewModel
import app.oneecom.core.constants.CoreLoggingConstants
import timber.log.Timber
import javax.inject.Inject

class HomeActivityViewModel
@Inject constructor() : ViewModel() {

    init {
        Timber.i(CoreLoggingConstants.LOGGING_PLACEHOLDER)
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i(CoreLoggingConstants.LOGGING_PLACEHOLDER)
    }

}