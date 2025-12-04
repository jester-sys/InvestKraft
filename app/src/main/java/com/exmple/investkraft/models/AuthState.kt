package com.exmple.investkraft.models


sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    object OTPSent : AuthState()
    object Success : AuthState()
    data class Error(val message: String) : AuthState()
}