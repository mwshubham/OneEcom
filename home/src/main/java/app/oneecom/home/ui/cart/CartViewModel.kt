package app.oneecom.home.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.oneecom.core.constants.CoreLoggingConstants
import timber.log.Timber
import javax.inject.Inject

class CartViewModel
@Inject constructor() : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is cart Fragment"
    }
    val text: LiveData<String> = _text

    init {
        Timber.i(CoreLoggingConstants.LOGGING_PLACEHOLDER)
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i(CoreLoggingConstants.LOGGING_PLACEHOLDER)
    }
}