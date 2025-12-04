package com.exmple.investkraft.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun LeadsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA))
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        // Title
        Text(
            text = "View Leads",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Total Leads
        Text(
            text = "0 Total Leads",
            fontSize = 15.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Loans and Investments in Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Loans Card
            LeadCategoryCard(
                title = "Loans",
                count = "0",
                backgroundColor = Color(0xFFFFCCB3),
                modifier = Modifier.weight(1f)
            )

            // Investments Card
            LeadCategoryCard(
                title = "Investments",
                count = "0",
                backgroundColor = Color(0xFFE8C4D8),
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Insurance Card
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            LeadCategoryCard(
                title = "Insurance",
                count = "0",
                backgroundColor = Color(0xFFB3D9FF),
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Video Tutorial Card - UPDATED WITH IMAGES
        VideoTutorialCard()
    }
}

@Composable
fun VideoTutorialCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Top section with gradient and image
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color(0xFFFF6B4A))
            ) {
                // Background pattern/image
                AsyncImage(
                    model = "https://images.unsplash.com/photo-1553877522-43269d4ea984?w=400&h=200&fit=crop",
                    contentDescription = "Background pattern",
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.2f)),
                    contentScale = ContentScale.Crop
                )

                // Content overlay
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    // IK Partner logo top left
                    Box(
                        modifier = Modifier.align(Alignment.TopStart)
                    ) {
                        AsyncImage(
                            model = "https://img.icons8.com/fluency/96/partnership.png",
                            contentDescription = "IK Partner",
                            modifier = Modifier.size(40.dp),
                            contentScale = ContentScale.Fit
                        )
                    }

                    // Play button with image background
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .size(56.dp)
                            .clip(CircleShape)
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(
                            model = "https://img.icons8.com/color/96/circled-play.png",
                            contentDescription = "Play button",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Fit
                        )
                    }

                    // Tutorial text with icon
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(end = 16.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        AsyncImage(
                            model = "https://img.icons8.com/fluency/96/tutorial.png",
                            contentDescription = "Tutorial",
                            modifier = Modifier.size(48.dp),
                            contentScale = ContentScale.Fit
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "HOW TO ADD\nLEADS IN IK\nPARTNER APP",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            lineHeight = 26.sp,
                            textAlign = TextAlign.End
                        )
                    }
                }
            }

            // Bottom white section with thumbnail and title
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Video thumbnail
                AsyncImage(
                    model = "https://images.unsplash.com/photo-1553877522-43269d4ea984?w=100&h=100&fit=crop",
                    contentDescription = "Video thumbnail",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(12.dp))

                // Video title
                Text(
                    text = "Lead Submission on IK Partner App | Step-by-Step Guide",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    lineHeight = 18.sp,
                    modifier = Modifier.weight(1f)
                )

                // Watch now arrow
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Watch now",
                    tint = Color(0xFFFF6B4A),
                    modifier = Modifier.size(20.dp)
                )
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
        modifier = modifier.height(140.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.align(Alignment.TopStart)
            ) {
                Text(
                    text = title,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = count,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Total Leads",
                    fontSize = 13.sp,
                    color = Color.Black.copy(alpha = 0.7f)
                )
            }

            // Arrow button
            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.9f))
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "View $title",
                    tint = Color.Black,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}