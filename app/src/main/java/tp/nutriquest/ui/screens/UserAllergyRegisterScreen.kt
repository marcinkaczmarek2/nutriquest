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
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import tp.nutriquest.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import tp.nutriquest.ui.components.AllergySelector
import tp.nutriquest.ui.data.AllergyOption
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.BackgroundGrey
import tp.nutriquest.ui.theme.LoginYellow

@Composable
fun UserAllergyRegisterScreenInitialize(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenHeightDp: Dp = configuration.screenHeightDp.dp
    val boxHeight = screenHeightDp * 0.25f
    val componentOffset = boxHeight + 20.dp
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
    var waterPerDay by remember { mutableStateOf(0f) }
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

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        //TODO dodac guzik info, uzgodnic co ma tam byc
                        text = "Allergies",
                        fontSize = 18.sp,
                        textAlign = TextAlign.Start,
                        color = BackgroundGreen,
                        modifier = Modifier
                            .offset(y = componentOffset)
                            .fillMaxWidth(componentWidth)
                    )

                    Spacer(modifier = Modifier.height(2.dp))

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
                        offset = componentOffset,
                        width = componentWidth
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    Text(
                        //TODO USTAWIC JAKAS FAJNA CZCIONKE
                        text = "Liters of water per day: ${waterPerDay.toInt()}",
                        fontSize = 18.sp,
                        textAlign = TextAlign.Start,
                        color = BackgroundGreen,
                        modifier = Modifier
                            .offset(y = componentOffset)
                            .fillMaxWidth(componentWidth)
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Slider(
                        value = waterPerDay,
                        onValueChange = { waterPerDay = it },
                        valueRange = 0f..4f,
                        steps = 0,
                        colors = SliderDefaults.colors(
                            activeTrackColor = BackgroundGreen,
                            inactiveTrackColor = Color.White,
                            thumbColor = LoginYellow
                        ),
                        modifier = Modifier
                            .offset(y = componentOffset)
                            .fillMaxWidth(componentWidth)

                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(componentWidth)
                            .offset(y = componentOffset)
                    ) {
                        Text(
                            text = "0",
                            color = BackgroundGreen,
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.Start
                        )

                        Text(
                            text = "2",
                            color = BackgroundGreen,
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = "4",
                            color = BackgroundGreen,
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.End
                        )
                    }

                    Spacer(modifier = Modifier.height(50.dp))



                    Button(
                        onClick = {
                            navController.navigate("register_goal")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = LoginYellow, contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth(componentWidth)
                            .offset(y = componentOffset)
                    ) {
                        Text(
                            text = "Continue", fontSize = 26.sp
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
                    text = "FILL IN INFORMATION",
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


