package com.exmple.investkraft.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.exmple.investkraft.models.PartnerStory
import com.exmple.investkraft.ui.theme.TextPrimary
import com.exmple.investkraft.ui.theme.TextSecondary

@Composable
fun PartnerStoriesSection(partnerStories: List<PartnerStory>) {
    Column {
        Text(
            text = "Our Partner's Stories",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "2 Lakh+ partners trust us",
            fontSize = 14.sp,
            color = TextSecondary
        )
        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(partnerStories) { story ->
                PartnerStoryCard(story)
            }
        }
    }
}

@Composable
fun PartnerStoryCard(story: PartnerStory) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(260.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2196F3)),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(
                model = story.imageUrl,
                contentDescription = "Partner",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.7f)
                            ),
                            startY = 0f,
                            endY = Float.POSITIVE_INFINITY
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.TrendingUp,
                        contentDescription = null,
                        tint = Color(0xFFFFD54F),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "IK\nPartner",
                        fontSize = 11.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 13.sp
                    )
                }

                Text(
                    text = "Earn 3X Income\nwith InvestKraft",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    lineHeight = 19.sp
                )

                Column {
                    Text(
                        text = "Meet IK Partner:",
                        fontSize = 12.sp,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                    Text(
                        text = story.name,
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = story.achievement,
                        fontSize = 11.sp,
                        color = Color(0xFFFFD54F),
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Play",
                        tint = Color.White,
                        modifier = Modifier
                            .size(44.dp)
                            .background(Color.White.copy(alpha = 0.3f), CircleShape)
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}