package com.exmple.investkraft.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.exmple.investkraft.ui.theme.TextPrimary
import com.exmple.investkraft.ui.theme.TextSecondary

@Composable
fun FinancialProductsSection() {
    Column {
        Text(
            text = "Sell and Earn",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Our Financial Products",
            fontSize = 14.sp,
            color = TextSecondary
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            FinancialProductCard(
                title = "Loans",
                imageUrl = "https://cdn-icons-png.flaticon.com/512/3135/3135692.png",
                backgroundColor = Color(0xFFFFF3E0),
                modifier = Modifier.weight(1f)
            )

            FinancialProductCard(
                title = "Insurance",
                imageUrl = "https://cdn-icons-png.flaticon.com/512/921/921347.png",
                backgroundColor = Color(0xFFE3F2FD),
                modifier = Modifier.weight(1f)
            )

            FinancialProductCard(
                title = "Investment",
                imageUrl = "https://cdn-icons-png.flaticon.com/512/3135/3135679.png",
                backgroundColor = Color(0xFFE8F5E9),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun FinancialProductCard(
    title: String,
    imageUrl: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.height(130.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = title,
                    modifier = Modifier.size(32.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = title,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary,
                textAlign = TextAlign.Center
            )
        }
    }
}