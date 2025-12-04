package com.exmple.investkraft.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.exmple.investkraft.ui.theme.TextPrimary
import com.exmple.investkraft.ui.theme.TextSecondary

@Composable
fun MadeInIndiaSection() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = "https://img.icons8.com/color/144/india.png",
                    contentDescription = "India Flag",
                    modifier = Modifier.size(32.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Made in India ",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
                Text(
                    text = "❤️",
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "3X Your Income With Us",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFF5722)
            )
            Spacer(modifier = Modifier.height(16.dp))

            AsyncImage(
                model = "https://images.unsplash.com/photo-1556761175-b413da4baf72?w=600&h=300&fit=crop",
                contentDescription = "Indian Business Growth",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Join 2 Lakh+ successful partners",
                fontSize = 14.sp,
                color = TextSecondary
            )
        }
    }
}

