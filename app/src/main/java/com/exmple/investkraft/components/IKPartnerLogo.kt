package com.exmple.investkraft.components


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * IK Partner Logo - Exact match from provided image
 * Simplified arrow with gradient (Purple->Blue->Orange)
 * Clean text: IK (Red), Part (Orange), ner (Purple)
 */
@Composable
fun IKPartnerLogo(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        // Arrow Logo with Gradient
        Canvas(modifier = Modifier.size(80.dp)) {
            val width = size.width
            val height = size.height

            // Gradient: Purple -> Blue -> Orange (matching image)
            val gradientBrush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFF8B3A9F),  // Purple
                    Color(0xFF3949AB),  // Blue
                    Color(0xFFFF6B35)   // Orange
                ),
                start = Offset(width * 0.2f, height * 0.8f),
                end = Offset(width * 0.8f, height * 0.2f)
            )

            val arrowPath = Path().apply {
                // Main diagonal line (bottom-left to top-right corner area)
                moveTo(width * 0.30f, height * 0.70f)
                lineTo(width * 0.75f, height * 0.25f)

                // Top horizontal line of arrow head (left part)
                moveTo(width * 0.75f, height * 0.25f)
                lineTo(width * 0.55f, height * 0.25f)

                // Right vertical line of arrow head (down part)
                moveTo(width * 0.75f, height * 0.25f)
                lineTo(width * 0.75f, height * 0.45f)
            }

            // Draw arrow
            drawPath(
                path = arrowPath,
                brush = gradientBrush,
                style = Stroke(
                    width = 16f,
                    cap = StrokeCap.Round
                )
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // "IK Partner" text
        val logoText = buildAnnotatedString {
            // "IK" - Red
            withStyle(
                style = SpanStyle(
                    color = Color(0xFFC93042),  // Red
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("IK")
            }

            append("\n")

            // "Part" - Orange
            withStyle(
                style = SpanStyle(
                    color = Color(0xFFFF6B35),  // Orange
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Part")
            }

            // "ner" - Purple
            withStyle(
                style = SpanStyle(
                    color = Color(0xFF6B3A8B),  // Purple
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("ner")
            }
        }

        Text(
            text = logoText,
            lineHeight = 44.sp
        )
    }
}