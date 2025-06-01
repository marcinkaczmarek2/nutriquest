package tp.nutriquest.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tp.nutriquest.ui.data.Progress
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.LoginYellow

@Composable
fun CheckpointProgressBar(
    progress: Progress
) {
    val progressFraction = progress.currentValue.toFloat() / progress.maxValue.toFloat()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = progress.iconId),
            contentDescription = "checkpoint icon",
            colorFilter = ColorFilter.tint(BackgroundGreen),
            modifier = Modifier
                .size(32.dp)
                .padding(end = 8.dp)
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .height(24.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(BackgroundGreen),
            contentAlignment = Alignment.CenterStart
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(progressFraction)
                    .background(LoginYellow)
            )

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(progressFraction),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    text = progress.currentValue.toString(),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(end = 6.dp)
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = progress.maxValue.toString(),
            color = BackgroundGreen,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}