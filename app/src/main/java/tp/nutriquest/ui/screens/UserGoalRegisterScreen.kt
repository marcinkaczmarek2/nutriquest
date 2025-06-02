package tp.nutriquest.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import tp.nutriquest.R
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import tp.nutriquest.ui.components.GoalSelector
import tp.nutriquest.ui.data.Goal
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.BackgroundGrey
import tp.nutriquest.ui.theme.LoginYellow

@Composable
fun UserGoalRegisterScreenInitialize(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenHeightDp: Dp = configuration.screenHeightDp.dp
    val boxHeight = screenHeightDp * 0.25f
    val componentOffset = boxHeight + 20.dp
    val componentWidth = 0.8f
    val goalOptions = listOf(
        Goal("Improve overall wellbeing", R.drawable.wellbeing_icon),
        Goal("Improve appearance", R.drawable.appearance_icon),
        Goal("Strengthen immunity", R.drawable.immunity_icon),
        Goal("Support physical activity", R.drawable.activity_icon),
        Goal("Improve concentration", R.drawable.concentration_icon)
    )
    var selectedGoals by remember { mutableStateOf(setOf<String>()) }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            //grey box (lower one)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BackgroundGrey),

                ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        //TODO USTAWIC JAKAS FAJNA CZCIONKE
                        text = "What do you want to achieve?",
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        color = BackgroundGreen,
                        modifier = Modifier
                            .offset(y = componentOffset)
                            .fillMaxWidth(componentWidth)
                    )



                    GoalSelector(
                        //TODO przekazywac jakos wybrane goale
                        options = goalOptions,
                        selectedOptions = selectedGoals,
                        onOptionSelected = { goalName ->
                            selectedGoals = if (selectedGoals.contains(goalName)) {
                                selectedGoals - goalName
                            } else {
                                selectedGoals + goalName
                            }
                        },
                        offset = componentOffset,
                        width = componentWidth
                    )

                    Spacer(modifier = Modifier.height(50.dp))



                    Button(
                        onClick = {
                            navController.navigate("home")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = LoginYellow, contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth(componentWidth)
                            .offset(y = componentOffset)
                    ) {
                        Text(
                            text = "Let's begin!", fontSize = 26.sp
                        )
                    }
                }
            }

            //green box (upper one)
            Box(
                contentAlignment = Alignment.Center,
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
                Text(
                    text = "CHOOSE YOUR GOAL",
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(0.8f),
                    color = LoginYellow,
                    textAlign = TextAlign.Center,
                    letterSpacing = 1.sp,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.ExtraBold,
                    style = TextStyle(
                        lineHeight = 44.sp
                    )
                )
            }
        }
    }
}



