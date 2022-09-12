package com.example.carcontroller.ui.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carcontroller.data.repository.HomeRepository
import com.example.carcontroller.model.Car
import com.example.carcontroller.model.CarLockState
import com.example.carcontroller.model.LockState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository,
) : ViewModel() {

    private val _carLockStateFlow: MutableStateFlow<CarLockState> = MutableStateFlow(
        CarLockState.NoLockState
    )
    val carLockStateFlow: StateFlow<CarLockState> = _carLockStateFlow.asStateFlow()

    val snackBarState = mutableStateOf(false)


    fun getCarDetails(): Car {
        return homeRepository.getCarDetails()
    }

    fun changeCarLockState(isLocked: Boolean) {
        val lockState = if (isLocked)
            LockState.LOCK
        else LockState.UNLOCK

        viewModelScope.launch {
            _carLockStateFlow.emit(
                CarLockState.LockStateChanging(lockState)
            )

            delay(LOCK_CHANGE_DELAY)
            _carLockStateFlow.emit(
                CarLockState.LockStateChanged(lockState)
            )
            snackBarState.value = true
        }
    }

    private companion object {
        const val LOCK_CHANGE_DELAY = 5000L
    }
}