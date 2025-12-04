package com.exmple.investkraft.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.exmple.investkraft.viewmodel.SharableContent


@Composable
fun SharableContentSection(
    title: String = "Sharable Content",
    sharableContent: List<SharableContent>,
    onViewAllClick: () -> Unit = {},
    onShareClick: (Int) -> Unit = {}
) {
    Column {
        SectionHeader(
            title = title,
            onViewAllClick = onViewAllClick
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(sharableContent) { content ->
                SharableCard(
                    content = content,
                    onShareClick = { onShareClick(sharableContent.indexOf(content)) }
                )
            }
        }
    }
}

@Composable
fun SharableCard(
    content: SharableContent,
    onShareClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .width(280.dp)
            .height(320.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color(content.backgroundColor))
            ) {
                if (content.hasPartnerBadge) {
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

                AsyncImage(
                    model = content.imageUrl,
                    contentDescription = content.title,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(150.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = content.title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = content.subtitle,
                    fontSize = 11.sp,
                    color = Color.Gray,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Button(
                onClick = onShareClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00C853)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Share to Customer",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Share",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}