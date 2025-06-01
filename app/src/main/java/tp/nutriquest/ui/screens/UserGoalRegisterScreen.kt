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
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.BackgroundGrey
import tp.nutriquest.ui.theme.LoginYellow

@Composable
fun UserGoalRegisterScreenInitialize() {
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
                        onClick = {},
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

@Composable
fun GoalSelector(
    options: List<Goal>,
    selectedOptions: Set<String>,
    onOptionSelected: (String) -> Unit,
    offset: Dp,
    width: Float
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(width)
            .offset(y = offset),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        options.forEach { option ->
            val isSelected = selectedOptions.contains(option.name)

            Spacer(modifier = Modifier.height(5.dp))

            Card(
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()
                    .clickable { onOptionSelected(option.name) },
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isSelected) LoginYellow else BackgroundGreen
                ),
                border = if (isSelected) BorderStroke(2.dp, Color(0xFF388E3C)) else null
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = option.name,
                        color = if (isSelected) Color.Black else Color.White,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )

                    Image(
                        painter = painterResource(id = option.iconRes),
                        contentDescription = option.name,
                        colorFilter = ColorFilter.tint(if (isSelected) Color.Black else LoginYellow),
                        modifier = Modifier.size(45.dp)
                    )
                }
            }
        }
    }
}


data class Goal(
    val name: String,
    val iconRes: Int
)