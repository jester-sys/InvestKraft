package com.exmple.investkraft.screen

import com.exmple.investkraft.R
import com.exmple.investkraft.viewmodel.AuthViewModel

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exmple.investkraft.models.AuthState


@Composable
fun LoginScreen(
    viewModel: AuthViewModel,
    onNavigateToOTP: (String) -> Unit
) {
    val mobile by viewModel.mobile.collectAsState()
    val authState by viewModel.authState.collectAsState()
    val context = LocalContext.current

    // Handle navigation on OTP sent
    LaunchedEffect(authState) {
        when (authState) {
            is AuthState.OTPSent -> {
                onNavigateToOTP(mobile)
                viewModel.resetAuthState()
            }
            is AuthState.Error -> {
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

    // Main Layout
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
            Spacer(modifier = Modifier.height(40.dp))

            Image(
                painter = painterResource(id = R.drawable.ik_partner_logo),
                contentDescription = "IK Partner Logo",
                modifier = Modifier.size(150.dp)
            )

            Spacer(modifier = Modifier.height(60.dp))

            // Title
            Text(
                text = "Login or Create a New Account",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1A1A1A),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Email or mobile number label
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Email or mobile number ",
                        fontSize = 15.sp,
                        color = Color(0xFF1A1A1A),
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = "*",
                        fontSize = 15.sp,
                        color = Color(0xFFE91E63),
                        fontWeight = FontWeight.Normal
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Input Field
                OutlinedTextField(
                    value = mobile,
                    onValueChange = { viewModel.updateMobile(it) },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(
                            text = "",
                            color = Color(0xFF999999)
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone
                    ),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFFE0E0E0),
                        unfocusedBorderColor = Color(0xFFE0E0E0),
                        cursorColor = Color(0xFF1A1A1A),
                        focusedTextColor = Color(0xFF1A1A1A),
                        unfocusedTextColor = Color(0xFF1A1A1A)
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Login Button
            Button(
                onClick = { viewModel.sendOTP() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF000000),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
                enabled = authState != AuthState.Loading
            ) {
                if (authState == AuthState.Loading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = Color.White,
                        strokeWidth = 2.dp
                    )
                } else {
                    Text(
                        text = "Login",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Sign Up Text
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Don't have an Account? ",
                    fontSize = 14.sp,
                    color = Color(0xFF757575),
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = "Sign Up",
                    fontSize = 14.sp,
                    color = Color(0xFFE91E63),
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Info",
                        tint = Color(0xFFE91E63),
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Jaane IK Partner banke kaise badha sakte",
                        fontSize = 16.sp,
                        color = Color(0xFFE91E63),
                        fontWeight = FontWeight.Normal
                    )
                }
                Text(
                    text = "hain income 3x!",
                    fontSize = 16.sp,
                    color = Color(0xFFE91E63),
                    fontWeight = FontWeight.Normal
                )
            }

            Spacer(modifier = Modifier.height(40.dp))
        }

    }
}