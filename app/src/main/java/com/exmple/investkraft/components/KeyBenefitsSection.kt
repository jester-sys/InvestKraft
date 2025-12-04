package com.exmple.investkraft.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.exmple.investkraft.ui.theme.TextPrimary
import com.exmple.investkraft.ui.theme.TextSecondary

@Composable
fun KeyBenefitsSection(benefits: List<String>) {
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
                        text = "Key Benefits",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1565C0)
                    )
                    Text(
                        text = "to Our Partners",
                        fontSize = 14.sp,
                        color = TextSecondary
                    )
                }

                AsyncImage(
                    model = "https://img.icons8.com/fluency/240/statistics.png",
                    contentDescription = "Benefits",
                    modifier = Modifier.size(48.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            benefits.forEachIndexed { index, benefit ->
                BenefitItem(text = benefit, index = index)
                if (index < benefits.size - 1) {
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

@Composable
fun BenefitItem(text: String, index: Int) {
    Row(
        verticalAlignment = Alignment.Top
    ) {
        AsyncImage(
            model = when (index % 4) {
                0 -> "https://img.icons8.com/fluency/96/checkmark.png"
                1 -> "https://img.icons8.com/fluency/96/money-bag.png"
                2 -> "https://img.icons8.com/fluency/96/apps.png"
                else -> "https://img.icons8.com/fluency/96/clock.png"
            },
            contentDescription = "Benefit Icon",
            modifier = Modifier
                .size(22.dp)
                .padding(top = 2.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            color = TextPrimary,
            lineHeight = 20.sp,
            modifier = Modifier.weight(1f)
        )
    }
}