package tp.nutriquest.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import tp.nutriquest.R
import tp.nutriquest.ui.components.GoalOverviewCard
import tp.nutriquest.ui.components.LowerNavigationMenu
import tp.nutriquest.ui.components.MainScreenContentColumnModifier
import tp.nutriquest.ui.components.TopLogoAndStats
import tp.nutriquest.ui.data.Goal
import tp.nutriquest.ui.data.GoalOverview
import tp.nutriquest.ui.data.UserViewModel
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.BackgroundGrey

@Composable
fun MainEducationScreenInitialize(navController: NavController, userViewModel: UserViewModel) {
    val configuration = LocalConfiguration.current
    val screenHeightDp: Dp = configuration.screenHeightDp.dp
    val boxHeight = screenHeightDp * 0.9f
    val lowerMenuOffset = boxHeight + 20.dp
    val scrollState = rememberScrollState()

    var goals = listOf(
        Goal("Improve overall wellbeing", R.drawable.wellbeing_icon),
        Goal("Improve appearance", R.drawable.appearance_icon),
        Goal("Strengthen immunity", R.drawable.immunity_icon),
        Goal("Support physical activity", R.drawable.activity_icon),
        Goal("Improve concentration", R.drawable.concentration_icon)
    )

    val goalOverviews = listOf(
        GoalOverview(
            goal = goals[0],
            keyFocusAreas = listOf(
                "Stable energy throughout the day",
                "Mood & Focus",
                "Hydration"
            ),
            focusAreas = listOf(
                "by balancing blood sugar with fiber, whole grains and smart snacking",
                "via foods rich in magnesium, omega-3, and B-vitamins",
                "as a foundation of clear thinking and good digestion"
            )
        ),
        GoalOverview(
            goal = goals[1],
            keyFocusAreas = listOf(
                "Healthy fats",
                "Antioxidants",
                "Protein and biotin",
                "Hydration",
                "Zinc and vitamins A, C and E"
            ),
            focusAreas = listOf(
                "to maintain skin elasticity and reduce dryness",
                "to protect skin from oxidative stress and promote glow",
                "to support strong hair and nails",
                "for skin smoothness and natural radiance",
                "for regeneration and even skin tone"
            )
        ),
        GoalOverview(
            goal = goals[3],
            keyFocusAreas = listOf(
                "Complex carbohydrates",
                "Lean protein",
                "Magnesium & electrolytes",
                "Iron and B-vitamins"
            ),
            focusAreas = listOf(
                "to fuel workouts and aid recovery",
                "to support muscle repair and maintenance",
                "to prevent cramping and maintain endurance",
                "to enhance oxygen transport and energy metabolism"
            )
        )
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BackgroundGreen)
            ) {
                LowerNavigationMenu(
                    navController,
                    lowerMenuOffset
                )

            }

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
                    .background(BackgroundGrey)
            ) {

                TopLogoAndStats(userViewModel)

                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = MainScreenContentColumnModifier(scrollState)
                    ) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "YOUR GOALS:",
                            fontSize = 26.sp,
                            color = BackgroundGreen,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        //TODO przekazywac odpowiednie goale usera
                        GoalOverviewCard(goalOverviews[0])

                        Spacer(modifier = Modifier.height(20.dp))

                        GoalOverviewCard(goalOverviews[1])

                        Spacer(modifier = Modifier.height(20.dp))

                        GoalOverviewCard(goalOverviews[2])
                    }
                }
            }
        }
    }
}



