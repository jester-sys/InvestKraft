package com.exmple.investkraft.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.exmple.investkraft.viewmodel.VideoContent


@Composable
fun VideoContentSection(
    title: String = "Earn with IK Partner",
    videos: List<VideoContent>,
    onViewAllClick: () -> Unit = {},
    onVideoClick: (Int) -> Unit = {}
) {
    Column {
        Spacer(modifier = Modifier.height(24.dp))
        SectionHeader(
            title = title,
            onViewAllClick = onViewAllClick
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(videos) { video ->
                VideoCard(
                    video = video,
                    onClick = { onVideoClick(videos.indexOf(video)) }
                )
            }
        }
    }
}

@Composable
fun VideoCard(
    video: VideoContent,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(280.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                AsyncImage(
                    model = video.thumbnailUrl,
                    contentDescription = "Video thumbnail",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.3f))
                )

                if (video.hasPartnerBadge) {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .background(Color.White, RoundedCornerShape(4.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "Partner",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFE91E63)
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp)
                        .size(48.dp)
                        .background(Color.White, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Play",
                        tint = Color(0xFF1976D2),
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            Text(
                text = video.title,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
        }
    }
}