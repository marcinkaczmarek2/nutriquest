package tp.nutriquest.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import tp.nutriquest.R
import tp.nutriquest.ui.components.LoginPanel
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.BackgroundGrey
import tp.nutriquest.ui.theme.LoginYellow


@Composable
fun LoginScreenInitialize(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenHeightDp = configuration.screenHeightDp.dp
    val screenWidthDp = configuration.screenWidthDp.dp

    val density = LocalDensity.current

    val screenHeightPx = with(density) { screenHeightDp.toPx() }
    val screenWidthPx = with(density) { screenWidthDp.toPx() }

    val loginPanelOffsetY = with(density) {
        (screenHeightPx * 0.7f).toDp() - 600.dp // połowa wysokości LoginPanelu
    }

    // Responsywne rozmiary logo i fontów
    val logoWidth = with(density) { (screenWidthPx * 0.55f).toDp() }
    val logoHeight = logoWidth * 0.75f

    val titleFontSize = (screenWidthPx * 0.055f).sp
    val subtitleFontSize = (screenWidthPx * 0.025f).sp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundGreen)
    ) {
        // Background
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(with(density) { (screenHeightPx * 0.7f).toDp() })
                .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                .background(BackgroundGrey)
        )

        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(50.dp))

                Box(
                    modifier = Modifier
                        .background(
                            color = LoginYellow,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(12.dp)
                ) {

                    Image(
                        painter = painterResource(R.drawable.nutriquest_logo),
                        contentDescription = "App logo",
                        modifier = Modifier
                            .height(logoHeight)
                            .width(logoWidth)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "NUTRIQUEST",
                    color = BackgroundGreen,
                    fontSize = titleFontSize,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                Text(
                    text = "YOUR PERSONAL",
                    color = BackgroundGreen,
                    fontSize = subtitleFontSize,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                Text(
                    text = "NUTRITION CONTROLLER",
                    color = BackgroundGreen,
                    fontSize = subtitleFontSize,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }

            Spacer(modifier = Modifier.height(loginPanelOffsetY))

            LoginPanel(navController = navController)
        }
    }
}








