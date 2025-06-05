package tp.nutriquest.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import tp.nutriquest.R
import tp.nutriquest.ui.theme.BackgroundGreen

@Composable
fun RegisterTopMenu(headerText: String, navController: NavController, navigation: String) {
    val configuration = LocalConfiguration.current
    val screenHeightDp: Dp = configuration.screenHeightDp.dp
    val boxHeight = screenHeightDp * 0.25f

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(boxHeight)
            .clip(
                RoundedCornerShape(
                    bottomStart = 10.dp, bottomEnd = 10.dp
                )
            )
            .background(BackgroundGreen)
    ) {
        RegisterHeaderText(headerText)

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, top = 40.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_test_icon),
                contentDescription = "go back",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .size(40.dp)
                    .clickable { navController.navigate(navigation) }
            )
        }
    }
}
