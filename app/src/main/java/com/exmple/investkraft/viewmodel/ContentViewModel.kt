package com.exmple.investkraft.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ContentViewModel : ViewModel() {

    // Selected category state
    var selectedCategory by mutableStateOf("Business Loan")
        private set

    fun selectCategory(category: String) {
        selectedCategory = category
    }

    // Sharable content data
    val sharableContent = listOf(
        SharableContent(
            title = "New Bike A Day",
            subtitle = "Inspire clients to protect their families with strong life and insurance this day",
            backgroundColor = 0xFFF5F5F5,
            hasPartnerBadge = true,
            imageUrl = "https://images.pexels.com/photos/267961/pexels-photo-267961.jpeg?auto=compress&cs=tinysrgb&w=400"
        ),
        SharableContent(
            title = "Children's Day",
            subtitle = "Reach out to families today! Offer education loans and child plans to ensure every dream gets wings.",
            backgroundColor = 0xFFE3F2FD,
            hasPartnerBadge = false,
            imageUrl = "https://images.unsplash.com/photo-1560421683-6856ea585c78?w=400"
        )
    )

    // Marketing categories
    val categories = listOf("Business Loan", "Home Loan", "Personal Loan")

    // Marketing content data
    val marketingContent = listOf(
        MarketingContent(
            title = "Festival Season Offer - Fast Loans!",
            description = "Fast Business Loan Approvals",
            backgroundColor = 0xFFFFE0B2,
            isBlue = false,
            imageUrl = "https://images.unsplash.com/photo-1556740758-90de374c12ad?w=400"
        ),
        MarketingContent(
            title = "APKA BUSINESS, HAMARI FUNDING!",
            description = "Low Interest | Flexible EMI",
            backgroundColor = 0xFF1976D2,
            isBlue = true,
            imageUrl = "https://images.unsplash.com/photo-1573496359142-b8d87734a5a2?w=400"
        ),
        MarketingContent(
            title = "Small Business? Big Finance!",
            description = "Easy Loans for MSMEs",
            backgroundColor = 0xFF1976D2,
            isBlue = true,
            imageUrl = "https://images.unsplash.com/photo-1580489944761-15a19d654956?w=400"
        ),
        MarketingContent(
            title = "Stock Lo, Sales Badhao!",
            description = "Business Loan for Expansion",
            backgroundColor = 0xFFE3F2FD,
            isBlue = false,
            imageUrl = "https://images.unsplash.com/photo-1573497019940-1c28c88b4f3e?w=400"
        )
    )

    // Video content data
    val videoContent = listOf(
        VideoContent(
            title = "Become a POSP Agent & Start Selling...",
            hasPartnerBadge = true,
            thumbnailUrl = "https://images.unsplash.com/photo-1573496359142-b8d87734a5a2?w=400"
        ),
        VideoContent(
            title = "Start Here! Your Roadmap to Selling ...",
            hasPartnerBadge = true,
            thumbnailUrl = "https://images.unsplash.com/photo-1580489944761-15a19d654956?w=400"
        )
    )
}

// Data classes
data class SharableContent(
    val title: String,
    val subtitle: String,
    val backgroundColor: Long,
    val hasPartnerBadge: Boolean,
    val imageUrl: String
)

data class MarketingContent(
    val title: String,
    val description: String,
    val backgroundColor: Long,
    val isBlue: Boolean,
    val imageUrl: String
)

data class VideoContent(
    val title: String,
    val hasPartnerBadge: Boolean,
    val thumbnailUrl: String
)