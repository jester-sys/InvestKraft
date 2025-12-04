package com.exmple.investkraft.viewmodel



import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.exmple.investkraft.models.Partner
import com.exmple.investkraft.models.PartnerStory

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {

    private val _isAutoScrollEnabled = MutableStateFlow(true)
    val isAutoScrollEnabled = _isAutoScrollEnabled.asStateFlow()

    var isFabExtended by mutableStateOf(false)
        private set

    fun toggleAutoScroll() {
        _isAutoScrollEnabled.value = !_isAutoScrollEnabled.value
    }

    fun updateFabState(isScrolled: Boolean) {
        isFabExtended = isScrolled
    }

    // Partner data
    val partners = listOf(
        Partner("HDFC Bank", "https://cdn-icons-png.flaticon.com/512/5968/5968525.png", "Bank"),
        Partner("ICICI Bank", "https://cdn-icons-png.flaticon.com/512/5968/5968528.png", "Bank"),
        Partner("SBI Cards", "https://cdn-icons-png.flaticon.com/512/5968/5968526.png", "Credit Card"),
        Partner("Axis Bank", "https://cdn-icons-png.flaticon.com/512/5968/5968527.png", "Bank"),
        Partner("PolicyBazaar", "https://cdn-icons-png.flaticon.com/512/2165/2165004.png", "Insurance"),
        Partner("Bank Bazaar", "https://cdn-icons-png.flaticon.com/512/2784/2784459.png", "Finance"),
        Partner("Bandhan Bank", "https://cdn-icons-png.flaticon.com/512/5968/5968523.png", "Bank"),
        Partner("Yes Bank", "https://cdn-icons-png.flaticon.com/512/5968/5968524.png", "Bank"),
        Partner("Kotak Mahindra", "https://cdn-icons-png.flaticon.com/512/5968/5968529.png", "Bank"),
        Partner("Bajaj Finserv", "https://cdn-icons-png.flaticon.com/512/5968/5968530.png", "Finance"),
        Partner("Tata Capital", "https://cdn-icons-png.flaticon.com/512/5968/5968531.png", "Finance"),
        Partner("Aditya Birla", "https://cdn-icons-png.flaticon.com/512/5968/5968532.png", "Finance"),
        Partner("LIC", "https://cdn-icons-png.flaticon.com/512/5968/5968533.png", "Insurance"),
        Partner("PNB", "https://cdn-icons-png.flaticon.com/512/5968/5968534.png", "Bank"),
        Partner("Canara Bank", "https://cdn-icons-png.flaticon.com/512/5968/5968535.png", "Bank"),
        Partner("Union Bank", "https://cdn-icons-png.flaticon.com/512/5968/5968536.png", "Bank")
    )

    // Partner stories
    val partnerStories = listOf(
        PartnerStory(
            "Sharad Mishra",
            "https://images.unsplash.com/photo-1560250097-0b93528c311a?w=400&h=400&fit=crop&crop=face",
            "Earned ₹3.5L in 6 months"
        ),
        PartnerStory(
            "Shakti Singh",
            "https://images.unsplash.com/photo-1573496359142-b8d87734a5a2?w=400&h=400&fit=crop&crop=face",
            "Increased income by 400%"
        ),
        PartnerStory(
            "Priya Sharma",
            "https://images.unsplash.com/photo-1580489944761-15a19d654956?w=400&h=400&fit=crop&crop=face",
            "Top performer for 3 months"
        ),
        PartnerStory(
            "Rajesh Kumar",
            "https://images.unsplash.com/photo-1556740738-6a8c276a3ee6?w=400&h=400&fit=crop&crop=face",
            "Helped 50+ clients"
        )
    )

    // Benefits data
    val benefits = listOf(
        "Zero investment",
        "Unlimited Earnings",
        "30+ financial products under single roof",
        "Easy-to-use App with simple tracking",
        "Quick processing & On time Pay-out",
        "Performance recognition & 24*7 support"
    )
}