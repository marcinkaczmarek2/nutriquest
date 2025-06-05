package tp.nutriquest.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import tp.nutriquest.R
import tp.nutriquest.ui.components.GoalSelector
import tp.nutriquest.ui.components.RegisterTopMenu
import tp.nutriquest.ui.components.YellowButton
import tp.nutriquest.ui.data.Goal
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.BackgroundGrey

@Composable
fun RegisterGoalScreenInitialize(navController: NavController) {
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
    val scrollState = rememberScrollState()
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
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                        .padding(bottom = 50.dp)
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Spacer(modifier = Modifier.height(componentOffset))

                    Text(
                        text = "What do you want to achieve?",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                        color = BackgroundGreen,
                        modifier = Modifier
                            .fillMaxWidth(componentWidth)
                    )


                    Spacer(modifier = Modifier.height(10.dp))


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
                        width = componentWidth
                    )

                    Spacer(modifier = Modifier.height(50.dp))



                    YellowButton(navController, "Let's begin!", "home", modifier = Modifier.fillMaxWidth(componentWidth))
                }
            }

            //green box (upper one)
            RegisterTopMenu("CHOOSE YOUR GOAL", navController, "register_allergy")
        }
    }
}



