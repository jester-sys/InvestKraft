package com.exmple.investkraft.components


import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.exmple.investkraft.models.Partner
import com.exmple.investkraft.ui.theme.TextPrimary
import com.exmple.investkraft.ui.theme.TextSecondary
import com.exmple.investkraft.viewmodel.HomeViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LendingPartnersSection(
    partners: List<Partner>,
    viewModel: HomeViewModel? = null
) {
    val coroutineScope = rememberCoroutineScope()
    val lazyRowState = rememberLazyListState()
    val isAutoScrollEnabled = viewModel?.isAutoScrollEnabled?.collectAsState()?.value ?: true

    // INFINITE AUTO-SCROLL with smooth animation
    LaunchedEffect(lazyRowState, isAutoScrollEnabled) {
        if (isAutoScrollEnabled) {
            while (true) {
                delay(30) // Very smooth continuous scroll

                // Calculate if we need to reset to start
                val canScrollForward = lazyRowState.canScrollForward

                if (canScrollForward) {
                    // Smooth continuous scroll
                    lazyRowState.animateScrollBy(
                        value = 1.5f, // Adjust speed here
                        animationSpec = tween(durationMillis = 30)
                    )
                } else {
                    // Jump back to start without animation for seamless loop
                    lazyRowState.scrollToItem(0)
                }
            }
        }
    }

    // Create infinite partners list for seamless scrolling
    val infinitePartners = remember(partners) {
        buildList {
            repeat(3) { // Repeat 3 times for infinite effect
                addAll(partners)
            }
        }
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Our Lending & Insurance Partners",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    Text(
                        text = "We have partnered with various financial institutions.",
                        fontSize = 14.sp,
                        color = TextSecondary,
                        lineHeight = 19.sp
                    )
                }

                // Auto-scroll toggle button
                if (viewModel != null) {
                    IconButton(
                        onClick = { viewModel.toggleAutoScroll() },
                        modifier = Modifier.size(40.dp)
                    ) {
                        Icon(
                            imageVector = if (isAutoScrollEnabled)
                                androidx.compose.material.icons.Icons.Default.Pause
                            else
                                androidx.compose.material.icons.Icons.Default.PlayArrow,
                            contentDescription = if (isAutoScrollEnabled) "Pause auto-scroll" else "Play auto-scroll",
                            tint = Color(0xFF2196F3)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 2-Column Grid with INFINITE horizontal scroll
            LazyRow(
                state = lazyRowState,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.height(220.dp),
                userScrollEnabled = true // Allow manual scroll too
            ) {
                items(infinitePartners.chunked(2)) { rowPartners ->
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.width(140.dp)
                    ) {
                        rowPartners.forEach { partner ->
                            PartnerItem(partner = partner)
                        }
                    }
                }
            }

            // Auto-scroll status indicator
            AutoScrollStatusIndicator(isAutoScrollEnabled)
        }
    }
}

@Composable
fun PartnerItem(partner: Partner) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF8F9FA)
        ),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = partner.logoUrl,
                contentDescription = "${partner.name} logo",
                modifier = Modifier.size(36.dp),
                contentScale = ContentScale.Fit,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = partner.name,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = TextPrimary,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = partner.type,
                fontSize = 10.sp,
                color = TextSecondary,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun AutoScrollStatusIndicator(isEnabled: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .background(
                    color = if (isEnabled) Color(0xFF4CAF50) else Color(0xFFF44336),
                    shape = CircleShape
                )
        )
        Spacer(modifier = Modifier.width(8.dp))
//        Text(
//            text = if (isEnabled) "Auto-scroll: ON" else "Auto-scroll: OFF",
//            fontSize = 12.sp,
//            color = if (isEnabled) Color(0xFF4CAF50) else Color(0xFFF44336)
//        )
    }
}

// Extension to check if can scroll forward
val LazyListState.canScrollForward: Boolean
    get() = firstVisibleItemIndex < layoutInfo.totalItemsCount - 1