package com.exmple.investkraft.utils

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object OTP : Screen("otp/{mobile}") {
        fun createRoute(mobile: String) = "otp/$mobile"
    }
    object Home : Screen("home")
    object Leads : Screen("leads")
    object QRCode : Screen("qr_code")
    object Content : Screen("content")
}