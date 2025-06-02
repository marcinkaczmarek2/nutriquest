package tp.nutriquest.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import tp.nutriquest.ui.components.DietSelector
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.BackgroundGrey
import tp.nutriquest.ui.theme.LoginYellow

@Composable
fun RegisterActivityScreenInitialize(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenHeightDp: Dp = configuration.screenHeightDp.dp
    val boxHeight = screenHeightDp * 0.25f
    val componentOffset = boxHeight + 20.dp
    val componentWidth = 0.8f
    var activityHours by remember { mutableFloatStateOf(0f) }
    var mealsPerDay by remember { mutableFloatStateOf(0f) }
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

                    Text(
                        //TODO USTAWIC JAKAS FAJNA CZCIONKE
                        text = "Physical Activity: ${activityHours.toInt()} (hours per week)",
                        fontSize = 18.sp,
                        textAlign = TextAlign.Start,
                        color = BackgroundGreen,
                        modifier = Modifier
                            .offset(y = componentOffset)
                            .fillMaxWidth(componentWidth)
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Slider(
                        value = activityHours,
                        onValueChange = { activityHours = it },
                        valueRange = 0f..14f,
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
                            text = "7",
                            color = BackgroundGreen,
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = "14",
                            color = BackgroundGreen,
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.End
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        //TODO USTAWIC JAKAS FAJNA CZCIONKE
                        text = "Diet",
                        fontSize = 18.sp,
                        textAlign = TextAlign.Start,
                        color = BackgroundGreen,
                        modifier = Modifier
                            .offset(y = componentOffset)
                            .fillMaxWidth(componentWidth)
                    )

                    Spacer(modifier = Modifier.height(10.dp))


                    DietSelector(
                        selectedOption = selectedDiet,
                        onOptionSelected = { selectedDiet = it },
                        offset = componentOffset,
                        width = componentWidth
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        //TODO USTAWIC JAKAS FAJNA CZCIONKE
                        text = "Meals per day: ${mealsPerDay.toInt()}",
                        fontSize = 18.sp,
                        textAlign = TextAlign.Start,
                        color = BackgroundGreen,
                        modifier = Modifier
                            .offset(y = componentOffset)
                            .fillMaxWidth(componentWidth)
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Slider(
                        value = mealsPerDay,
                        onValueChange = { mealsPerDay = it },
                        valueRange = 0f..8f,
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
                            text = "1",
                            color = BackgroundGreen,
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.Start
                        )

                        Text(
                            text = "4",
                            color = BackgroundGreen,
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = "8",
                            color = BackgroundGreen,
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.End
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))



                    Button(
                        onClick = {
                            navController.navigate("register_allergy")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = LoginYellow,
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth(componentWidth)
                            .offset(y = componentOffset)
                    ) {
                        Text(
                            text = "Continue",
                            fontSize = 26.sp
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
                            bottomStart = 10.dp,
                            bottomEnd = 10.dp
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

