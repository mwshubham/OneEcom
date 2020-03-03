package app.oneecom.category.ui.viewmodels

import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.oneecom.core.constants.CoreLoggingConstants
import app.oneecom.core.network.repositiories.GithubRepository
import app.oneecom.core.network.responses.Product
import app.oneecom.core.ui.GenericViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class ProductListingViewModel
@Inject constructor(
    @VisibleForTesting(otherwise = PRIVATE)
    val githubRepository: GithubRepository
) : ViewModel() {

    val categoryId = 10011L

    private val _state = MutableLiveData<GenericViewState>()
    val state: LiveData<GenericViewState>
        get() = _state

    private val _data = MutableLiveData<List<Product>>()
    val data: LiveData<List<Product>>
        get() = _data

    init {
        Timber.i(CoreLoggingConstants.LOGGING_PLACEHOLDER)
    }

    /**
     * Fetch Categories.
     */
    fun getCategory() {
        Timber.i(CoreLoggingConstants.LOGGING_PLACEHOLDER)
        _state.postValue(GenericViewState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            Timber.i(CoreLoggingConstants.LOGGING_PLACEHOLDER)
            try {
                val result = githubRepository.getCategory(categoryId)
                _data.postValue(result.data.results)
                _state.postValue(GenericViewState.Dismiss)
            } catch (e: Exception) {
                e.printStackTrace()
                _state.postValue(GenericViewState.Error)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i(CoreLoggingConstants.LOGGING_PLACEHOLDER)
    }

}