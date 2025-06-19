package tp.nutriquest.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.LoginYellow

@Composable
fun DietSelector(
    options: List<String> = listOf("Regular", "Vegetarian", "Vegan"), //TODO tu sa diety
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    width: Float
) {
    val offset = 0.dp
    Column(
        modifier = Modifier
            .fillMaxWidth(width)
            .offset(y = offset),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        options.forEach { option ->
            val isSelected = option == selectedOption
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isSelected) LoginYellow else BackgroundGreen
                ),
                border = if (isSelected) BorderStroke(2.dp, Color(0xFF388E3C)) else null,
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .clickable { onOptionSelected(option) },

            ) {
                Box(
                    modifier = Modifier
                        .padding(vertical = 13.dp, horizontal = 20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = option,
                        color = if (isSelected) Color.Black else Color.White,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
        }
    }
}