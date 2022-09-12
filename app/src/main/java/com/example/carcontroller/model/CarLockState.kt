package com.example.carcontroller.model

sealed class CarLockState(val lockState: LockState?) {
    object NoLockState: CarLockState(null)
    class LockStateChanging(lockState: LockState): CarLockState(lockState)
    class LockStateChanged(lockState: LockState): CarLockState(lockState)
}

enum class LockState {
    LOCK,
    UNLOCK
}