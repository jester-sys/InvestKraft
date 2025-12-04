package com.exmple.investkraft.screen


import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exmple.investkraft.R
import kotlinx.coroutines.delay

/**
 * Splash Screen - Shows logo with animation
 * Auto-navigates to Login screen after 2.5 seconds
 */
@Composable
fun SplashScreen(
    onNavigateToLogin: () -> Unit
) {
    // Animation for logo scale and fade
    val infiniteTransition = rememberInfiniteTransition(label = "splash")

    val scale by infiniteTransition.animateFloat(
        initialValue = 0.8f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )

    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.5f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha"
    )

    // Auto-navigate after 2.5 seconds
    LaunchedEffect(Unit) {
        delay(2500)
        onNavigateToLogin()
    }

    // Splash Screen UI
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Animated Logo
            Image(
                painter = painterResource(id = R.drawable.ik_partner_logo),
                contentDescription = "IK Partner Logo",
                modifier = Modifier
                    .size(180.dp)
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                        this.alpha = alpha
                    }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // App tagline
            Text(
                text = "Grow Your Income 3X",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFE91E63),
                modifier = Modifier.graphicsLayer {
                    this.alpha = alpha
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Partner with us today!",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF757575),
                modifier = Modifier.graphicsLayer {
                    this.alpha = alpha
                }
            )
        }

        // Made in India at bottom
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Made in India ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF1A1A1A)
                )
                Text(
                    text = "❤️",
                    fontSize = 16.sp
                )
            }
        }
    }
}