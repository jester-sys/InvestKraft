package com.exmple.investkraft.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.exmple.investkraft.components.BannerSection
import com.exmple.investkraft.components.ContentAppBar
import com.exmple.investkraft.components.MarketingContentSection
import com.exmple.investkraft.components.OffersSection
import com.exmple.investkraft.components.SharableContentSection
import com.exmple.investkraft.components.VideoContentSection
import com.exmple.investkraft.viewmodel.ContentViewModel


@Composable
fun ContentScreen(
    viewModel: ContentViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        // Top App Bar
        ContentAppBar()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Banner Section
            item {
                BannerSection()
            }

            // Sharable Content Section
            item {
                SharableContentSection(
                    sharableContent = viewModel.sharableContent,
                    onShareClick = { index ->
                        // Handle share click
                        println("Sharing content at index: $index")
                    }
                )
            }

            // Marketing Content Section
            item {
                MarketingContentSection(
                    categories = viewModel.categories,
                    selectedCategory = viewModel.selectedCategory,
                    marketingContent = viewModel.marketingContent,
                    onCategorySelect = { category ->
                        viewModel.selectCategory(category)
                    },
                    onShareClick = { index ->
                        // Handle share click
                        println("Sharing marketing content at index: $index")
                    }
                )
            }

            // Video Content Section
            item {
                VideoContentSection(
                    videos = viewModel.videoContent,
                    onVideoClick = { index ->
                        // Handle video click
                        println("Playing video at index: $index")
                    }
                )
            }

            // Offers Section
            item {
                OffersSection()
            }

            // Bottom spacer
            item {
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}