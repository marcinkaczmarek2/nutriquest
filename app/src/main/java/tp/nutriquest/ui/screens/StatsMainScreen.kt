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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tp.nutriquest.R
import tp.nutriquest.ui.components.AchievementCompose
import tp.nutriquest.ui.components.CheckpointProgressBar
import tp.nutriquest.ui.components.IconRow
import tp.nutriquest.ui.components.QuestCompose
import tp.nutriquest.ui.components.SwitchToHomeScreen
import tp.nutriquest.ui.components.TaskChart
import tp.nutriquest.ui.data.Achievement
import tp.nutriquest.ui.data.Progress
import tp.nutriquest.ui.data.Quest
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.BackgroundGrey
import tp.nutriquest.ui.theme.LoginYellow
import tp.nutriquest.ui.theme.QuestGreen

@Composable
fun StatsMainScreenInitialize() {
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
                IconRow(
                    onHomeClick = { },
                    onStatsClick = { },
                    onEducationClick = { },
                    onOptionsClick = { },
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
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 30.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .background(color = LoginYellow, shape = RoundedCornerShape(16.dp))
                            .padding(8.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.nutriquest_logo),
                            contentDescription = "App logo",
                            modifier = Modifier
                                .height(50.dp)
                                .width(60.dp)
                        )
                    }

                    Text(
                        text = "NUTRITION QUEST",
                        color = BackgroundGreen,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.align(Alignment.Center),
                        textAlign = TextAlign.Center
                    )

                    Card(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .height(50.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = BackgroundGreen
                        ),
                        border = BorderStroke(2.dp, BackgroundGreen)
                    ) {
                        Row(
                            //TODO wyrownac ten streak row caly bo troche krzywo
                            modifier = Modifier
                                .padding(horizontal = 12.dp, vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.streak_icon),
                                contentDescription = "flame icon",
                                colorFilter = ColorFilter.tint(LoginYellow),
                                modifier = Modifier.size(30.dp)
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                //TODO dodac ilosc dni streaka rzeczywistego usera
                                text = "69",
                                color = LoginYellow,
                                fontWeight = FontWeight.Bold,
                                fontSize = 30.sp
                            )
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .fillMaxHeight(0.85f)
                            .offset(y = 45.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color.White)
                            .padding(16.dp)
                            .verticalScroll(scrollState)
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






