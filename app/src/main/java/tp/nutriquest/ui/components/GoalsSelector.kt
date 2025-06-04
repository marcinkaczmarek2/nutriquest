package tp.nutriquest.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import tp.nutriquest.ui.data.Goal
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.LoginYellow
import kotlin.collections.forEach


@Composable
fun GoalSelector(
    options: List<Goal>,
    selectedOptions: Set<String>,
    onOptionSelected: (String) -> Unit,
    width: Float
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(width),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        options.forEach { option ->
            val isSelected = selectedOptions.contains(option.name)

            Spacer(modifier = Modifier.height(2.dp))

            Card(
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()
                    .clickable { onOptionSelected(option.name) },
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isSelected) LoginYellow else BackgroundGreen
                ),
                border = if (isSelected) BorderStroke(2.dp, Color(0xFF388E3C)) else null
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = option.name,
                        color = if (isSelected) Color.Black else Color.White,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )

                    Image(
                        painter = painterResource(id = option.iconRes),
                        contentDescription = option.name,
                        colorFilter = ColorFilter.tint(if (isSelected) Color.Black else LoginYellow),
                        modifier = Modifier.size(45.dp)
                    )
                }
            }
        }
    }
}