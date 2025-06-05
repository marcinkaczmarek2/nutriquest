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
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import tp.nutriquest.ui.components.AllergySelector
import tp.nutriquest.ui.components.CustomSlider
import tp.nutriquest.ui.components.RegisterTopMenu
import tp.nutriquest.ui.components.YellowButton
import tp.nutriquest.ui.data.AllergyOption
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.BackgroundGrey

@Composable
fun RegisterAllergyScreenInitialize(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenHeightDp: Dp = configuration.screenHeightDp.dp
    val boxHeight = screenHeightDp * 0.25f
    val componentOffset = boxHeight + 35.dp
    val componentWidth = 0.8f

    val allergyOptions = listOf(
        AllergyOption("Peanuts", R.drawable.peanut_icon),
        AllergyOption("Dairy", R.drawable.dairy_icon),
        AllergyOption("Gluten", R.drawable.gluten_icon),
        AllergyOption("Soy", R.drawable.soy_icon),
        AllergyOption("Seafood", R.drawable.seafood_icon),
        AllergyOption("Eggs", R.drawable.eggs_icon)
    )
    val selectedAllergies = remember { mutableStateOf(setOf<String>()) }
    val waterPerDay = remember { mutableFloatStateOf(0f) }
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

                    Text(
                        //TODO dodac guzik info, uzgodnic co ma tam byc
                        text = "Allergies",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                        color = BackgroundGreen,
                        modifier = Modifier
                            .fillMaxWidth(componentWidth)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    AllergySelector(
                        options = allergyOptions,
                        selectedOptions = selectedAllergies.value,
                        onOptionToggled = { name ->
                            selectedAllergies.value = if (selectedAllergies.value.contains(name)) {
                                selectedAllergies.value - name
                            } else {
                                selectedAllergies.value + name
                            }
                        },
                        width = componentWidth
                    )

                    Spacer(modifier = Modifier.height(70.dp))

                    CustomSlider(waterPerDay, componentWidth, "2", 0f, 4f, "Liters of water", "(per day)")

                    Spacer(modifier = Modifier.height(90.dp))

                    YellowButton(navController, "Continue", "register_goal", modifier = Modifier.fillMaxWidth(componentWidth))
                }
            }
            //green box (upper one)
            RegisterTopMenu("FILL IN INFORMATION", navController, "register_activity")
        }
    }
}


