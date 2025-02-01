package com.manishjajoriya.waterxcel.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manishjajoriya.waterxcel.ui.theme.GreenPrimary


@Composable
fun CreditPage(modifier: Modifier = Modifier) {
    // Sample data for the credit transaction history
    val creditTransactions = listOf(
        "01 Jan 2025 - Credit Added: 10",
        "02 Jan 2025 - Credit Added: 10",
        "03 Jan 2025 - Credit Added: 10",
        "04 Jan 2025 - Credit Added: 10"
    )

    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {

        // "My Credit" heading
        Text(
            text = "My Credit",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Current credit
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Box(
                modifier = Modifier.padding(16.dp)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Your Credit",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = "100", // Replace with dynamic credit value
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = GreenPrimary
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // "Credit Transaction History" heading
        Text(
            text = "Credit Transaction History",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Credit transaction history
        Column {
            creditTransactions.forEach { transaction ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Box(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = transaction,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}
