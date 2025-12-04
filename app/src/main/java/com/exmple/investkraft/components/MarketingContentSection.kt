package com.exmple.investkraft.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

import com.exmple.investkraft.viewmodel.MarketingContent


@Composable
fun MarketingContentSection(
    title: String = "Marketing Content",
    categories: List<String>,
    selectedCategory: String,
    marketingContent: List<MarketingContent>,
    onCategorySelect: (String) -> Unit = {},
    onViewAllClick: () -> Unit = {},
    onShareClick: (Int) -> Unit = {}
) {
    Column {
        Spacer(modifier = Modifier.height(24.dp))
        SectionHeader(
            title = title,
            onViewAllClick = onViewAllClick
        )

        // Category Chips
        CategoryChipsRow(
            categories = categories,
            selectedCategory = selectedCategory,
            onCategorySelect = onCategorySelect
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Marketing Cards Grid
        MarketingCardsGrid(
            marketingContent = marketingContent,
            onShareClick = onShareClick
        )
    }
}

@Composable
fun CategoryChipsRow(
    categories: List<String>,
    selectedCategory: String,
    onCategorySelect: (String) -> Unit
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(vertical = 12.dp)
    ) {
        items(categories) { category ->
            CategoryChip(
                text = category,
                isSelected = category == selectedCategory,
                onClick = { onCategorySelect(category) }
            )
        }
    }
}

@Composable
fun CategoryChip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit = {}
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        color = if (isSelected) Color(0xFF00C853) else Color.White,
        border = if (!isSelected) BorderStroke(1.dp, Color(0xFFE0E0E0)) else null
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                color = if (isSelected) Color.White else Color.Black,
                fontSize = 14.sp,
                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
            )
            if (isSelected) {
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Composable
fun MarketingCardsGrid(
    marketingContent: List<MarketingContent>,
    onShareClick: (Int) -> Unit = {}
) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // First row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            marketingContent.take(2).forEachIndexed { index, content ->
                MarketingCard(
                    content = content,
                    modifier = Modifier.weight(1f),
                    onShareClick = { onShareClick(index) }
                )
            }
        }

        // Second row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            marketingContent.drop(2).take(2).forEachIndexed { index, content ->
                MarketingCard(
                    content = content,
                    modifier = Modifier.weight(1f),
                    onShareClick = { onShareClick(index + 2) }
                )
            }
        }
    }
}

@Composable
fun MarketingCard(
    content: MarketingContent,
    modifier: Modifier = Modifier,
    onShareClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.height(240.dp),
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
                    .height(140.dp)
                    .background(Color(content.backgroundColor))
            ) {
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

                AsyncImage(
                    model = content.imageUrl,
                    contentDescription = content.title,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(110.dp)
                        .clip(RoundedCornerShape(topStart = 16.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = if (content.isBlue) "DM FAST" else "**T&C apply",
                    fontSize = 10.sp,
                    color = if (content.isBlue) Color.White else Color.Gray,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(8.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .weight(1f)
            ) {
                Text(
                    text = content.title,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    lineHeight = 14.sp,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = content.description,
                    fontSize = 10.sp,
                    color = Color.Gray,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Button(
                onClick = onShareClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00C853)
                ),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                Text(
                    text = "Share Offer",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(14.dp)
                )
            }
        }
    }
}