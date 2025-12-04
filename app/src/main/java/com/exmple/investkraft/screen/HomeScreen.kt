package com.exmple.investkraft.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.exmple.investkraft.components.CommissionCard
import com.exmple.investkraft.components.FinancialProductsSection
import com.exmple.investkraft.components.HomeFloatingActionButton
import com.exmple.investkraft.components.KeyBenefitsSection
import com.exmple.investkraft.components.LearnEarnCard
import com.exmple.investkraft.components.LendingPartnersSection
import com.exmple.investkraft.components.MadeInIndiaSection
import com.exmple.investkraft.components.PartnerStoriesSection
import com.exmple.investkraft.components.ShareBannerSection
import com.exmple.investkraft.components.UserHeaderSection
import com.exmple.investkraft.viewmodel.HomeViewModel


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    val listState = rememberLazyListState()

    // Update FAB state based on scroll
    LaunchedEffect(listState) {
        snapshotFlow {
            listState.firstVisibleItemIndex > 0 ||
                    listState.firstVisibleItemScrollOffset > 0
        }.collect { isScrolled ->
            viewModel.updateFabState(isScrolled)
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF8F9FA)),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // User Header
            item {
                UserHeaderSection()
            }

            // Share Banner
            item {
                ShareBannerSection()
            }

            // Financial Products Section
            item {
                FinancialProductsSection()
            }

            // Commission Card
            item {
           CommissionCard()
            }

            // Key Benefits Section
            item {
                KeyBenefitsSection(viewModel.benefits)
            }

            // Lending Partners Section (WITH INFINITE AUTO-SCROLL)
            item {
                LendingPartnersSection(
                    partners = viewModel.partners,
                    viewModel = viewModel
                )
            }

            // Learn & Earn Card
            item {
                LearnEarnCard()
            }

            // Partner Stories
            item {
                PartnerStoriesSection(viewModel.partnerStories)
            }

            // Made in India Section
            item {
                MadeInIndiaSection()
            }

            // Extra space for FAB
            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }

        // Floating Action Button
        HomeFloatingActionButton(
            isFabExtended = viewModel.isFabExtended,
            onAddLeadClick = { /* Handle add lead */ }
        )
    }
}