package tp.nutriquest.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import tp.nutriquest.R
import tp.nutriquest.ui.theme.LoginYellow


@Composable
fun LowerNavigationMenu(
    navController: NavController,
    offset: Dp
)
{
    val actions = createIconClickActions(navController)
    val onHomeClick = actions.onHomeClick
    val onStatsClick = actions.onStatsClick
    val onEducationClick = actions.onEducationClick
    val onOptionsClick = actions.onOptionsClick
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = offset)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButtonWithImage(
            drawableId = R.drawable.home_icon,
            contentDescription = "Home icon",
            onClick = onHomeClick
        )
        IconButtonWithImage(
            drawableId = R.drawable.stats_icon,
            contentDescription = "Stats icon",
            onClick = onStatsClick
        )
        IconButtonWithImage(
            drawableId = R.drawable.education_icon,
            contentDescription = "Education icon",
            onClick = onEducationClick
        )
        IconButtonWithImage(
            drawableId = R.drawable.options_icon,
            contentDescription = "Options icon",
            onClick = onOptionsClick
        )
    }
}

@Composable
fun IconButtonWithImage(
    drawableId: Int,
    contentDescription: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = drawableId),
            contentDescription = contentDescription,
            colorFilter = ColorFilter.tint(LoginYellow),
            modifier = Modifier.size(60.dp)
        )
    }
}