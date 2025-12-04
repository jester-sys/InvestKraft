package com.exmple.investkraft.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun QRCodeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        // Title
        Text(
            text = "My QR Code",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(48.dp))

        // Name
        Text(
            text = "Kanhaiya",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        // ID
        Text(
            text = "IKP06342",
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(40.dp))

        // QR Code Container with corner brackets
        Box(
            modifier = Modifier
                .size(280.dp)
                .border(
                    width = 1.dp,
                    color = Color.Gray.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            // QR Code with dummy image
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                // Corner brackets (L shapes)
                // Top Left
                Canvas(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .size(32.dp)
                ) {
                    drawPath(
                        path = androidx.compose.ui.graphics.Path().apply {
                            moveTo(0f, 32f)
                            lineTo(0f, 0f)
                            lineTo(32f, 0f)
                        },
                        color = androidx.compose.ui.graphics.Color.Gray,
                        style = androidx.compose.ui.graphics.drawscope.Stroke(width = 6f)
                    )
                }

                // Top Right
                Canvas(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(32.dp)
                ) {
                    drawPath(
                        path = androidx.compose.ui.graphics.Path().apply {
                            moveTo(0f, 0f)
                            lineTo(32f, 0f)
                            lineTo(32f, 32f)
                        },
                        color = androidx.compose.ui.graphics.Color.Gray,
                        style = androidx.compose.ui.graphics.drawscope.Stroke(width = 6f)
                    )
                }

                // Bottom Left
                Canvas(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .size(32.dp)
                ) {
                    drawPath(
                        path = androidx.compose.ui.graphics.Path().apply {
                            moveTo(32f, 0f)
                            lineTo(0f, 0f)
                            lineTo(0f, 32f)
                        },
                        color = androidx.compose.ui.graphics.Color.Gray,
                        style = androidx.compose.ui.graphics.drawscope.Stroke(width = 6f)
                    )
                }

                // Bottom Right
                Canvas(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(32.dp)
                ) {
                    drawPath(
                        path = androidx.compose.ui.graphics.Path().apply {
                            moveTo(32f, 0f)
                            lineTo(32f, 32f)
                            lineTo(0f, 32f)
                        },
                        color = androidx.compose.ui.graphics.Color.Gray,
                        style = androidx.compose.ui.graphics.drawscope.Stroke(width = 6f)
                    )
                }

                // Dummy QR Code Pattern
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(24.dp)
                ) {
                    // Simulated QR code pattern using boxes
                    Column(
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        repeat(12) { row ->
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(2.dp)
                            ) {
                                repeat(12) { col ->
                                    val isBlack = (row + col) % 3 != 0 || (row * col) % 5 == 0
                                    Box(
                                        modifier = Modifier
                                            .size(14.dp)
                                            .background(
                                                if (isBlack) Color.Black else Color.White
                                            )
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // InvestKraft logo text
                    Text(
                        text = "InvestKraft",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFE91E63)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(48.dp))

        // Download Button
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Download,
                contentDescription = "Download",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Download QR Code",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Share Button
        OutlinedButton(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Gray
            ),
            border = ButtonDefaults.outlinedButtonBorder.copy(
                width = 1.dp
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = "Share",
                tint = Color.Gray,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Share QR Code",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
private fun Canvas(
    modifier: Modifier,
    onDraw: androidx.compose.ui.graphics.drawscope.DrawScope.() -> Unit
) {
    androidx.compose.foundation.Canvas(modifier = modifier, onDraw = onDraw)
}