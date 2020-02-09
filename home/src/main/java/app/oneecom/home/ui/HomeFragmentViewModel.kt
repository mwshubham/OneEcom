package app.oneecom.home.ui

import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.oneecom.core.constants.CoreLoggingConstants
import app.oneecom.core.network.repositiories.MarvelRepository
import app.oneecom.core.network.responses.CharacterDetail
import app.oneecom.core.network.responses.CharacterDetailMapper
import app.oneecom.core.ui.CharacterDetailViewState
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class HomeFragmentViewModel
@Inject constructor(
    @VisibleForTesting(otherwise = PRIVATE)
    val marvelRepository: MarvelRepository,
    @VisibleForTesting(otherwise = PRIVATE)
    val characterDetailMapper: CharacterDetailMapper
) : ViewModel() {

    private val _state = MutableLiveData<CharacterDetailViewState>()
    val state: LiveData<CharacterDetailViewState>
        get() = _state

    private val _data = MutableLiveData<CharacterDetail>()
    val data: LiveData<CharacterDetail>
        get() = _data

    /**
     * Fetch selected character detail info.
     *
     * @param characterId Character identifier.
     */
    fun loadCharacterDetail(characterId: Long) {
        _state.postValue(CharacterDetailViewState.Loading)
        viewModelScope.launch {
            try {
                val result = marvelRepository.getCharacter(characterId)
                _data.postValue(characterDetailMapper.map(result))
            } catch (e: Exception) {
                e.printStackTrace()
                _state.postValue(CharacterDetailViewState.Error)
            }
        }
    }

    init {
        Timber.i(CoreLoggingConstants.LOGGING_PLACEHOLDER)
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i(CoreLoggingConstants.LOGGING_PLACEHOLDER)
    }

}