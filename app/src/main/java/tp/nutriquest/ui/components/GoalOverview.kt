package tp.nutriquest.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import tp.nutriquest.R
import tp.nutriquest.ui.data.GoalOverview
import tp.nutriquest.ui.theme.GoalGreen

@Composable
fun GoalOverviewCard(goalOverview: GoalOverview) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = GoalGreen
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .padding(bottom = 10.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            GoalCard(goalOverview.goal)
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Key Focus Areas:",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(6.dp))

            goalOverview.keyFocusAreas.indices.forEach { i ->
                Row(
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.dot_icon),
                        contentDescription = "dot icon",
                        modifier = Modifier
                            .size(12.dp)
                            .padding(end = 6.dp, top = 8.dp),
                        colorFilter = ColorFilter.tint(Color.Black)
                    )
                    Column {
                        Text(
                            text = goalOverview.keyFocusAreas[i],
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Black,
                        )
                        Text(
                            text = goalOverview.focusAreas[i],
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Black,
                        )
                    }
                }
            }
        }
    }
}