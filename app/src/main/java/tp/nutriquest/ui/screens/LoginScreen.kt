package tp.nutriquest.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(BackgroundGreen)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(BackgroundGrey)
                .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                .padding(vertical = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
                            .height(120.dp)
                            .width(160.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "NUTRIQUEST",
                    color = BackgroundGreen,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Text(
                    text = "YOUR PERSONAL",
                    color = BackgroundGreen,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = "NUTRITION CONTROLLER",
                    color = BackgroundGreen,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LoginPanel(navController = navController)
    }
}




