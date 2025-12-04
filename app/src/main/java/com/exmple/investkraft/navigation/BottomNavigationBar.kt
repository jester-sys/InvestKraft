package com.exmple.investkraft.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exmple.investkraft.ui.theme.PrimaryBlue
import com.exmple.investkraft.ui.theme.TextSecondary

@Composable
fun BottomNavigationBar(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit
) {
    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            selected = selectedTab == 0,
            onClick = { onTabSelected(0) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            label = { Text("Home") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = PrimaryBlue,
                selectedTextColor = PrimaryBlue,
                unselectedIconColor = TextSecondary,
                unselectedTextColor = TextSecondary,
                indicatorColor = PrimaryBlue.copy(alpha = 0.1f)
            )
        )

        NavigationBarItem(
            selected = selectedTab == 1,
            onClick = { onTabSelected(1) },
            icon = {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = "Leads"
                )
            },
            label = { Text("Leads") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = PrimaryBlue,
                selectedTextColor = PrimaryBlue,
                unselectedIconColor = TextSecondary,
                unselectedTextColor = TextSecondary,
                indicatorColor = PrimaryBlue.copy(alpha = 0.1f)
            )
        )

        NavigationBarItem(
            selected = selectedTab == 2,
            onClick = { onTabSelected(2) },
            icon = {
                Icon(
                    imageVector = Icons.Default.QrCodeScanner,
                    contentDescription = "QR Code"
                )
            },
            label = { Text("QR Code") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = PrimaryBlue,
                selectedTextColor = PrimaryBlue,
                unselectedIconColor = TextSecondary,
                unselectedTextColor = TextSecondary,
                indicatorColor = PrimaryBlue.copy(alpha = 0.1f)
            )
        )

        NavigationBarItem(
            selected = selectedTab == 3,
            onClick = { onTabSelected(3) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Book,
                    contentDescription = "Content"
                )
            },
            label = { Text("Content") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = PrimaryBlue,
                selectedTextColor = PrimaryBlue,
                unselectedIconColor = TextSecondary,
                unselectedTextColor = TextSecondary,
                indicatorColor = PrimaryBlue.copy(alpha = 0.1f)
            )
        )
    }
}

// ==================== LEADS SCREEN ====================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeadsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopAppBar(
            title = {
                Text(
                    "View Leads",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White
            )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "0 Total Leads",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Loans Card
            LeadCategoryCard(
                title = "Loans",
                count = "0",
                backgroundColor = Color(0xFFFFCCB3),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Investments Card
            LeadCategoryCard(
                title = "Investments",
                count = "0",
                backgroundColor = Color(0xFFE8C4D8),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Insurance Card
            LeadCategoryCard(
                title = "Insurance",
                count = "0",
                backgroundColor = Color(0xFFB3D9FF),
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Video Tutorial Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFF6B4A)),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    // Play button
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(16.dp)
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF1E3A5F).copy(alpha = 0.8f))
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Play",
                            tint = Color.White,
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    // HOW TO ADD LEADS text
                    Text(
                        text = "HOW TO ADD\nLEADS IN IK\nPARTNER APP",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(end = 24.dp),
                        lineHeight = 24.sp
                    )

                    // Title at bottom
                    Text(
                        text = "Lead Submission on IK Partner App | Step-by-Step Guide",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun LeadCategoryCard(
    title: String,
    count: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Column(
                modifier = Modifier.align(Alignment.TopStart)
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = count,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "Total Leads",
                    fontSize = 14.sp,
                    color = Color.Black.copy(alpha = 0.7f)
                )
            }

            // Arrow button
            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "View",
                    tint = Color.Black
                )
            }
        }
    }
}

// ==================== QR CODE SCREEN ====================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QRCodeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopAppBar(
            title = {
                Text(
                    "My QR Code",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White
            )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            // Name
            Text(
                text = "Kanhaiya",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            // ID
            Text(
                text = "IKP06342",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(40.dp))

            // QR Code Container
            Box(
                modifier = Modifier
                    .size(300.dp)
                    .border(
                        width = 2.dp,
                        color = Color.Gray.copy(alpha = 0.3f),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    // Corner brackets
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .size(40.dp)
                            .border(
                                width = 3.dp,
                                color = Color.Gray,
                                shape = RoundedCornerShape(topStart = 8.dp)
                            )
                    )
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .size(40.dp)
                            .border(
                                width = 3.dp,
                                color = Color.Gray,
                                shape = RoundedCornerShape(topEnd = 8.dp)
                            )
                    )
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .size(40.dp)
                            .border(
                                width = 3.dp,
                                color = Color.Gray,
                                shape = RoundedCornerShape(bottomStart = 8.dp)
                            )
                    )
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(40.dp)
                            .border(
                                width = 3.dp,
                                color = Color.Gray,
                                shape = RoundedCornerShape(bottomEnd = 8.dp)
                            )
                    )

                    // QR Code placeholder
                    Column(
                        modifier = Modifier.align(Alignment.Center),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(200.dp)
                                .background(Color.Black.copy(alpha = 0.1f))
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "InvestKraft",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFE91E63)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Download Button
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
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
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Download QR Code",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Share Button
            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Black
                ),
                border = ButtonDefaults.outlinedButtonBorder.copy(
                    width = 1.dp
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Share",
                    tint = Color.Black,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Share QR Code",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

