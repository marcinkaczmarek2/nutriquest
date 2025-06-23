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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import tp.nutriquest.ui.components.LowerNavigationMenu
import tp.nutriquest.ui.components.MainScreenContentColumnModifier
import tp.nutriquest.ui.components.QuestCompose
import tp.nutriquest.ui.components.TopLogoAndStats
import tp.nutriquest.ui.components.WeeklyQuestCompose
import tp.nutriquest.ui.data.Progress
import tp.nutriquest.ui.data.Quest
import tp.nutriquest.ui.data.WeeklyQuest
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.BackgroundGrey
import tp.nutriquest.backend.*


@Composable
fun MainHomeScreenInitialize(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenHeightDp: Dp = configuration.screenHeightDp.dp
    val boxHeight = screenHeightDp * 0.9f
    val lowerMenuOffset = boxHeight + 20.dp
    val scrollState = rememberScrollState()
    var quests = remember { //TODO do serializacji
        listOf(
            Quest(
                "2 liters of water",
                "Staying hydrated improves focus and overall mood.",
                listOf(""),
                mutableStateOf(false) //TODO tutaj oznaczenie czy quest zaliczony
            ),
            Quest(
                "2 dark chocolate cubes",
                "Flavonoids can enhance blood flow to your brain, boosting mental clarity and reducing stress.",
                listOf(""),
                mutableStateOf(false)
            ),
            Quest(
                "a banana",
                "Packed with potassium, it supports muscle function and helps prevent cramps.",
                listOf(""),
                mutableStateOf(false)
            ),
            Quest(
                "handful of nuts",
                "Rich in healthy fats and magnesium, they support brain health and satiety.",
                listOf("Nuts"),
                mutableStateOf(false)
            ),
            Quest(
                "a glass of green tea",
                "Contains L-theanine and caffeine — a combo that improves alertness without jitters.",
                listOf(""),
                mutableStateOf(false)
            ),
        )
    }


    val weeklyQuests = remember { //TODO do serializacji
        listOf(
            mutableStateOf(
                WeeklyQuest(
                    title = "Eat vegetables",
                    information = "Eat vegetables at least 7 times this week. Boosts fiber and supports digestion. Keep it up all week!",
                    listOf(""),
                    progress = mutableStateOf(Progress(currentValue = 0, maxValue = 7, iconId = R.drawable.vegetables_icon)),
                    isChecked = mutableStateOf(false)
                )
            ),

            mutableStateOf(
                WeeklyQuest(
                    title = "New healthy foods",
                    information = "Try introducing a new fruit, vegetable, grain, or nut daily. This improves nutrient diversity and helps you discover new favorites.",
                    listOf(""),
                    progress = mutableStateOf(Progress(currentValue = 0, maxValue = 7, iconId = R.drawable.healthy_food_icon)),
                    isChecked = mutableStateOf(false)
                )
            ),

            mutableStateOf(
                WeeklyQuest(
                    title = "Home-cooked meals",
                    information = "Try to make at home-cooked meals at least 5 times this week. Home cooking gives you full control over ingredients and portion sizes — a key step toward better nutrition.",
                    listOf(""),
                    progress = mutableStateOf(Progress(currentValue = 0, maxValue = 5, iconId = R.drawable.cooking_icon)),
                    isChecked = mutableStateOf(false)
                )
            ),

        )

    }


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
                            text = "TODAY'S QUESTS",
                            fontSize = 26.sp,
                            color = BackgroundGreen,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        //TODO quests = GetUserFromSessionMemory().quests
                        //TODO start przekazywania questow
                        QuestCompose(quests[0])

                        Spacer(modifier = Modifier.height(25.dp))

                        QuestCompose(quests[1])

                        Spacer(modifier = Modifier.height(25.dp))

                        QuestCompose(quests[2])

                        Spacer(modifier = Modifier.height(25.dp))

                        QuestCompose(quests[3])

                        Spacer(modifier = Modifier.height(25.dp))

                        QuestCompose(quests[4])

                        Spacer(modifier = Modifier.height(25.dp))


                        Text(
                            text = "WEEKLY QUESTS",
                            fontSize = 26.sp,
                            color = BackgroundGreen,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        //TODO quests = GetUserFromSessionMemory().weeklyQuests
                        //TODO start przekazywania questow
                        WeeklyQuestCompose(quest = weeklyQuests[0].value)

                        Spacer(modifier = Modifier.height(25.dp))

                        WeeklyQuestCompose(quest = weeklyQuests[1].value)

                        Spacer(modifier = Modifier.height(25.dp))

                        WeeklyQuestCompose(quest = weeklyQuests[2].value)
                    }
                }
            }
        }
    }
}


