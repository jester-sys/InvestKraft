package com.exmple.investkraft.viewmodel

import com.exmple.investkraft.models.AuthState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    private val _mobile = MutableStateFlow("")
    val mobile: StateFlow<String> = _mobile.asStateFlow()

    private val _otp = MutableStateFlow("")
    val otp: StateFlow<String> = _otp.asStateFlow()

    private val _otpTimer = MutableStateFlow(36)
    val otpTimer: StateFlow<Int> = _otpTimer.asStateFlow()

    fun updateMobile(mobile: String) {
        if (mobile.all { it.isDigit() } && mobile.length <= 10) {
            _mobile.value = mobile
        }
    }

    fun updateOtp(otp: String) {
        if (otp.all { it.isDigit() } && otp.length <= 6) {
            _otp.value = otp
        }
    }

    fun sendOTP() {
        viewModelScope.launch {
            // Validate mobile number
            if (_mobile.value.length != 10) {
                _authState.value = AuthState.Error("Please enter a valid 10-digit mobile number")
                return@launch
            }

            _authState.value = AuthState.Loading

            delay(1000)

            _authState.value = AuthState.OTPSent


            startOTPTimer()
        }
    }


    fun verifyOTP(): Boolean {

        val expectedOTP = "123456"

        return if (_otp.value == expectedOTP) {
            _authState.value = AuthState.Success
            true
        } else {
            _authState.value = AuthState.Error("Invalid OTP. Please use: 123456")
            false
        }
    }

    fun resendOTP() {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            delay(500)
            _authState.value = AuthState.OTPSent
            _otpTimer.value = 36
            _otp.value = "123456"
            startOTPTimer()
        }
    }


    private fun startOTPTimer() {
        viewModelScope.launch {
            _otpTimer.value = 36
            while (_otpTimer.value > 0) {
                delay(1000)
                _otpTimer.value -= 1
            }
        }
    }


    fun resetAuthState() {
        _authState.value = AuthState.Idle
    }


    fun clearOtp() {
        _otp.value = ""
    }
}

