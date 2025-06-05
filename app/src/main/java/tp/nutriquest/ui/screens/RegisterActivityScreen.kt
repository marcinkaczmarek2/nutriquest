package tp.nutriquest.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
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
import tp.nutriquest.ui.components.CustomSlider
import tp.nutriquest.ui.components.DietSelector
import tp.nutriquest.ui.components.RegisterTopMenu
import tp.nutriquest.ui.components.YellowButton
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.BackgroundGrey

@Composable
fun RegisterActivityScreenInitialize(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenHeightDp: Dp = configuration.screenHeightDp.dp
    val boxHeight = screenHeightDp * 0.25f
    val componentOffset = boxHeight + 35.dp
    val componentWidth = 0.8f
    val activityHours = remember { mutableFloatStateOf(0f) }
    val mealsPerDay = remember { mutableFloatStateOf(0f) }
    var selectedDiet by remember { mutableStateOf("Regular") }
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
                    Spacer(modifier = Modifier.height(componentOffset))

                    CustomSlider(activityHours, componentWidth, "7", 0f, 14f, "Physical Activity", "(hours per week)")

                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = "Diet",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                        color = BackgroundGreen,
                        modifier = Modifier
                            .fillMaxWidth(componentWidth)
                    )

                    Spacer(modifier = Modifier.height(10.dp))


                    DietSelector(
                        selectedOption = selectedDiet,
                        onOptionSelected = { selectedDiet = it },
                        width = componentWidth
                    )

                    Spacer(modifier = Modifier.height(35.dp))

                    CustomSlider(mealsPerDay, componentWidth, "4", 0f, 8f, "Meals per day", "")

                    Spacer(modifier = Modifier.height(40.dp))

                    YellowButton(navController, "Continue", "register_allergy", modifier = Modifier.fillMaxWidth(componentWidth))
                }
            }
            //green box (upper one)
            RegisterTopMenu("FILL IN INFORMATION", navController, "register_data")
        }
    }
}

