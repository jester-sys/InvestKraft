package com.exmple.investkraft.screen


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exmple.investkraft.R
import com.exmple.investkraft.components.IKPartnerLogo
import com.exmple.investkraft.models.AuthState
import com.exmple.investkraft.ui.theme.AccentPink
import com.exmple.investkraft.ui.theme.BorderLight
import com.exmple.investkraft.ui.theme.ButtonBlack
import com.exmple.investkraft.ui.theme.ButtonText
import com.exmple.investkraft.ui.theme.TextPrimary
import com.exmple.investkraft.ui.theme.TextSecondary
import com.exmple.investkraft.viewmodel.AuthViewModel

@Composable
fun OTPScreen(
    viewModel: AuthViewModel,
    mobile: String,
    onNavigateToHome: () -> Unit,
    onNavigateBack: () -> Unit
) {
    // Collect states from ViewModel
    val otp by viewModel.otp.collectAsState()
    val authState by viewModel.authState.collectAsState()
    val otpTimer by viewModel.otpTimer.collectAsState()
    val context = LocalContext.current

    // Set default OTP to 123456 when screen loads
    LaunchedEffect(Unit) {
        viewModel.updateOtp("123456")
    }

    // Handle authentication state changes
    LaunchedEffect(authState) {
        when (authState) {
            is AuthState.Success -> {
                // Navigate to home when OTP is verified
                onNavigateToHome()
                viewModel.resetAuthState()
            }
            is AuthState.Error -> {
                // Show error message as Toast
                Toast.makeText(
                    context,
                    (authState as AuthState.Error).message,
                    Toast.LENGTH_SHORT
                ).show()
                viewModel.resetAuthState()
            }
            else -> {}
        }
    }

    // Main UI Layout
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            // IK Partner Logo - Direct WebP Image
            Image(
                painter = painterResource(id = R.drawable.ik_partner_logo),
                contentDescription = "IK Partner Logo",
                modifier = Modifier.size(150.dp)
            )


            Spacer(modifier = Modifier.height(60.dp))

            // Title
            Text(
                text = "OTP Verification",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Mobile Number Display (masked)
            Text(
                text = "OTP has been sent to xxx${mobile.takeLast(4)}",
                fontSize = 14.sp,
                color = TextPrimary,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // 6-digit OTP Input Boxes (Default: 123456)
            OTPInputFields(
                otp = otp,
                onOtpChange = { viewModel.updateOtp(it) }
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Verify OTP Button
            Button(
                onClick = {
                    if (viewModel.verifyOTP()) {
                        // Navigation handled in LaunchedEffect
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ButtonBlack,
                    contentColor = ButtonText
                ),
                shape = RoundedCornerShape(8.dp),
                enabled = otp.length == 6 && authState != AuthState.Loading
            ) {
                if (authState == AuthState.Loading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = ButtonText,
                        strokeWidth = 2.dp
                    )
                } else {
                    Text(
                        text = "Verify OTP",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Resend OTP Section
            if (otpTimer > 0) {
                // Show timer countdown
                Text(
                    text = "Resend OTP in $otpTimer seconds",
                    fontSize = 14.sp,
                    color = TextSecondary
                )
            } else {
                // Show resend button when timer is 0
                TextButton(
                    onClick = { viewModel.resendOTP() }
                ) {
                    Text(
                        text = "Resend OTP",
                        fontSize = 14.sp,
                        color = AccentPink,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Change Mobile Number/Email Link
            TextButton(
                onClick = { onNavigateBack() }
            ) {
                Text(
                    text = "Want to change Mobile Number/Email Id?",
                    fontSize = 14.sp,
                    color = AccentPink
                )
            }

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
fun OTPInputFields(
    otp: String,
    onOtpChange: (String) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
    ) {
        // Create 6 OTP boxes
        repeat(6) { index ->
            OTPBox(
                digit = otp.getOrNull(index)?.toString() ?: "",
                isFocused = otp.length == index
            )
        }
    }

    // Invisible TextField for capturing input
    BasicTextField(
        value = otp,
        onValueChange = { if (it.length <= 6) onOtpChange(it) },
        modifier = Modifier.size(0.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

/**
 * Single OTP Box Component
 * Shows one digit of OTP
 */
@Composable
fun OTPBox(
    digit: String,
    isFocused: Boolean
) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .border(
                width = if (isFocused) 2.dp else 1.dp,
                color = if (isFocused) TextPrimary else BorderLight,
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = digit,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = TextPrimary,
            textAlign = TextAlign.Center
        )
    }
}