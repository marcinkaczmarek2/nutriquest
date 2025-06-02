package tp.nutriquest.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import tp.nutriquest.R
import tp.nutriquest.ui.components.AchievementCompose
import tp.nutriquest.ui.components.CheckpointProgressBar
import tp.nutriquest.ui.components.LowerNavigationMenu
import tp.nutriquest.ui.components.MainScreenContentColumnModifier
import tp.nutriquest.ui.components.TaskChart
import tp.nutriquest.ui.components.TopLogoAndStats
import tp.nutriquest.ui.data.Achievement
import tp.nutriquest.ui.data.Progress
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.BackgroundGrey
import tp.nutriquest.ui.theme.QuestGreen

@Composable
fun MainStatsScreenInitialize(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenHeightDp: Dp = configuration.screenHeightDp.dp
    val boxHeight = screenHeightDp * 0.9f
    val lowerMenuOffset = boxHeight + 20.dp
    val scrollState = rememberScrollState()
    var achievements = listOf(
        Achievement(100, "DAY STREAK", R.drawable.streak_icon),
        Achievement(4, "WEEKS OF HYDRATION", R.drawable.hydration_icon),
        Achievement(50, "NUTRI-TIPS READ", R.drawable.openbook_icon),
    )

    val progresses = listOf(
        Progress(100, 200, R.drawable.streak_icon),
        Progress(4, 5, R.drawable.hydration_icon),
        Progress(50, 75, R.drawable.openbook_icon),
    )


    val weeklyData = listOf(1, 2, 0, 3, 1, 2, 1)

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

                TopLogoAndStats()

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
                            text = "HOW YOU'RE DOING:",
                            fontSize = 26.sp,
                            color = BackgroundGreen,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally),
                            colors = CardDefaults.cardColors(
                                containerColor = QuestGreen
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "YOUR ACHIEVEMENTS",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp),
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            AchievementCompose(modifier = Modifier.weight(1f), achievements[0])
                            AchievementCompose(modifier = Modifier.weight(1f), achievements[1])
                            AchievementCompose(modifier = Modifier.weight(1f), achievements[2])
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally),
                            colors = CardDefaults.cardColors(
                                containerColor = QuestGreen
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "NEXT CHECKPOINTS",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp),
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))

                        CheckpointProgressBar(progresses[0])

                        Spacer(modifier = Modifier.height(20.dp))

                        CheckpointProgressBar(progresses[1])

                        Spacer(modifier = Modifier.height(20.dp))

                        CheckpointProgressBar(progresses[2])

                        Spacer(modifier = Modifier.height(30.dp))

                        //TODO dodac wykresy dla month i year oraz dzialac na prawdziwych danych
                        TaskChart(weeklyData = weeklyData)
                    }
                }
            }
        }
    }
}






