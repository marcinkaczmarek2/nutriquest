package tp.nutriquest.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import tp.nutriquest.ui.data.Goal
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.LoginYellow

@Composable
fun GoalCard(goal: Goal)
{
    Card(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = BackgroundGreen
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = goal.name,
                color = Color.White,
                fontWeight = FontWeight.Normal
            )


            Image(
                painter = painterResource(id = goal.iconRes),
                contentDescription = goal.name,
                colorFilter = ColorFilter.tint(LoginYellow),
                modifier = Modifier.size(45.dp)
            )
        }
    }
}