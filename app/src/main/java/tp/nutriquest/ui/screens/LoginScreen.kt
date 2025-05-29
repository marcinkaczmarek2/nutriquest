package tp.nutriquest.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tp.nutriquest.R
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.BackgroundGrey

@Composable
fun LoginScreen() {

}

@Composable
fun SetBackground() {
    val configuration = LocalConfiguration.current
    val screenHeightDp: Dp = configuration.screenHeightDp.dp
    val boxHeight = screenHeightDp * 0.75f

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            //green box (lower one)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BackgroundGreen)
            )

            //grey box (upper one)
            Box(

                modifier = Modifier
                    .fillMaxWidth()
                    .height(boxHeight)
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 10.dp,
                            bottomEnd = 10.dp
                        )
                    )
                    .background(BackgroundGrey),
                contentAlignment = Alignment.Center,
            ) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .background(
                                    color = Color(0xFFFFD700),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .padding(16.dp)

                        ) {
                            Image(
                                painter = painterResource(R.drawable.nutriquest_logo),
                                contentDescription = "App logo",
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(275.dp)
                            )
                        }

                        Text(
                            text = "NUTRIQUEST",
                            modifier = Modifier.padding(top = 20.dp),
                            color = BackgroundGreen,
                            fontSize = 36.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = "YOUR PERSONAL",
                            modifier = Modifier.padding(top = 2.dp),
                            color = BackgroundGreen,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = "NUTRITION CONTROLLER",
                            color = BackgroundGreen,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

            }
        }
    }
}