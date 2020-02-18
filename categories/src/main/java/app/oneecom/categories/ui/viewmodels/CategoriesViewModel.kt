package app.oneecom.categories.ui.viewmodels

import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.oneecom.core.constants.CoreLoggingConstants
import app.oneecom.core.network.repositiories.GithubRepository
import app.oneecom.core.network.responses.Category
import app.oneecom.core.ui.GenericViewState
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class CategoriesViewModel
@Inject constructor(
    @VisibleForTesting(otherwise = PRIVATE)
    val githubRepository: GithubRepository
) : ViewModel() {

    private val _state = MutableLiveData<GenericViewState>()
    val state: LiveData<GenericViewState>
        get() = _state

    private val _data = MutableLiveData<List<Category>>()
    val data: LiveData<List<Category>>
        get() = _data

    private val _selectedCategoryName = MutableLiveData<String>()
    val selectedCategoryName: LiveData<String>
        get() = _selectedCategoryName

    private val _selectedSubCategoryName = MutableLiveData<String>()
    val selectedSubCategoryName: LiveData<String>
        get() = _selectedSubCategoryName

    init {
        Timber.i(CoreLoggingConstants.LOGGING_PLACEHOLDER)
    }

    /**
     * Fetch Categories.
     */
    fun getCategories() {
        _state.postValue(GenericViewState.Loading)
        viewModelScope.launch {
            try {
                val result = githubRepository.getCategories()
                _data.postValue(result.data.results)
                _state.postValue(GenericViewState.Dismiss)
            } catch (e: Exception) {
                e.printStackTrace()
                _state.postValue(GenericViewState.Error)
            }
        }
    }

    fun onSubCategorySelected(parentCategory: Category, category: Category) {
        _selectedCategoryName.value = parentCategory.name
        _selectedSubCategoryName.value = category.name
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i(CoreLoggingConstants.LOGGING_PLACEHOLDER)
    }

}