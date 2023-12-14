package ir.divar.city

import android.util.Log
import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.divar.androidtask.data.repository.PlaceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@androidx.compose.runtime.Immutable
data class CityScreenUiState(
    val isLoading: Boolean = false,
    val data: List<CityItem> = emptyList(),
    val message: String? = null
)

@Immutable
data class CityItem(
    val id: Int?, val title: String?, val onItemClicked: (() -> Unit)?
)

@HiltViewModel
class CityViewModel @Inject constructor(
    private val placeRepository: PlaceRepository
) : ViewModel() {

    private var _cityScreenUiState = MutableStateFlow(CityScreenUiState())
    val cityScreenUiState = _cityScreenUiState.asStateFlow()

    init {
        launchCity()

        syncData()
    }

    private fun syncData() {
        viewModelScope.launch {
            placeRepository.syncPlaceList()
        }
    }

    private fun launchCity() {
        viewModelScope.launch {
            placeRepository.getPlaceList().collectLatest { result ->
                when (result) {
                    is Result.InProgress -> {
                        _cityScreenUiState.update { currentState ->
                            currentState.copy(isLoading = true)
                        }
                    }

                    is Result.OnSuccess -> {
                        val items = result.data.cities?.map {
                            CityItem(it.id, it.name, null)
                        }

                        items?.run {
                            _cityScreenUiState.update { currentState ->
                                currentState.copy(isLoading = false, data = this)
                            }
                        }
                    }

                    is Result.OnError -> {
                        Log.d("Result", "OnError")
                        _cityScreenUiState.update { currentState ->
                            currentState.copy(isLoading = true)
                        }
                    }
                }
            }


        }
    }
}