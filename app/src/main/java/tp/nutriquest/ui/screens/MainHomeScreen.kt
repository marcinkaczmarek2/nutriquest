package tp.nutriquest.ui.screens

import android.content.Context
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import tp.nutriquest.ui.components.LowerNavigationMenu
import tp.nutriquest.ui.components.MainScreenContentColumnModifier
import tp.nutriquest.ui.components.QuestCompose
import tp.nutriquest.ui.components.TopLogoAndStats
import tp.nutriquest.ui.components.WeeklyQuestCompose
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.BackgroundGrey
import tp.nutriquest.backend.*
import tp.nutriquest.ui.data.ResolvedProgress
import tp.nutriquest.ui.data.ResolvedWeeklyQuest
import tp.nutriquest.ui.data.UserViewModel
import tp.nutriquest.ui.data.WeeklyQuest
import kotlin.collections.map


@Composable
fun MainHomeScreenInitialize(navController: NavController, userViewModel: UserViewModel) {
    val configuration = LocalConfiguration.current
    val screenHeightDp: Dp = configuration.screenHeightDp.dp
    val boxHeight = screenHeightDp * 0.9f
    val lowerMenuOffset = boxHeight + 20.dp
    val scrollState = rememberScrollState()
    val user = userViewModel.getUser()
    val context = LocalContext.current
    var quests = remember { GenerateDailyQuestsForUser(context, user) }

    var weeklyQuests = remember { GenerateWeeklyQuestsForUser(context, user) }.toMutableList()

    val resolvedQuests = mapToResolvedWeeklyQuests(context, weeklyQuests).toMutableList()

//    var quests = remember { //TODO do serializacji
//        listOf(
//            Quest(
//                "2 liters of water",
//                "Staying hydrated improves focus and overall mood.",
//                listOf(""),
//                false //TODO tutaj oznaczenie czy quest zaliczony
//            ),
//            Quest(
//                "2 dark chocolate cubes",
//                "Flavonoids can enhance blood flow to your brain, boosting mental clarity and reducing stress.",
//                listOf(""),
//                false
//            ),
//            Quest(
//                "a banana",
//                "Packed with potassium, it supports muscle function and helps prevent cramps.",
//                listOf(""),
//                false
//            ),
//            Quest(
//                "handful of nuts",
//                "Rich in healthy fats and magnesium, they support brain health and satiety.",
//                listOf("Nuts"),
//                false
//            ),
//            Quest(
//                "a glass of green tea",
//                "Contains L-theanine and caffeine — a combo that improves alertness without jitters.",
//                listOf(""),
//                false
//            ),
//        )
//    }


//    val weeklyQuests = remember {
//        listOf(
//            mutableStateOf(
//                WeeklyQuest(
//                    title = "Eat vegetables",
//                    information = "Eat vegetables at least 7 times this week. Boosts fiber and supports digestion. Keep it up all week!",
//                    notAllowedFor = listOf(""),
//                    progress = Progress(currentValue = 0, maxValue = 7, iconId = R.drawable.vegetables_icon),
//                    isChecked = false
//                )
//            ),
//            mutableStateOf(
//                WeeklyQuest(
//                    title = "Eat vegetables",
//                    information = "Eat vegetables at least 7 times this week. Boosts fiber and supports digestion. Keep it up all week!",
//                    notAllowedFor = listOf(""),
//                    progress = Progress(currentValue = 0, maxValue = 7, iconId = R.drawable.vegetables_icon),
//                    isChecked = false
//                )
//            )
//        )
//    }


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
                        quests.forEach { quest->
                            QuestCompose(quest)
                            Spacer(modifier = Modifier.height(25.dp))
                        }

//                        QuestCompose(quests[0])
//
//                        Spacer(modifier = Modifier.height(25.dp))
//
//                        QuestCompose(quests[1])
//
//                        Spacer(modifier = Modifier.height(25.dp))
//
//                        QuestCompose(quests[2])
//
//                        Spacer(modifier = Modifier.height(25.dp))
//
//                        QuestCompose(quests[3])
//
//                        Spacer(modifier = Modifier.height(25.dp))
//
//                        QuestCompose(quests[4])
//
//                        Spacer(modifier = Modifier.height(25.dp))
//

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
                        for (index in resolvedQuests.indices) {
                            val weeklyQuest = resolvedQuests[index]
                            WeeklyQuestCompose(
                                quest = weeklyQuest,
                                onQuestChange = { updatedQuest ->
                                    resolvedQuests[index] = updatedQuest
                                }
                            )
                            Spacer(modifier = Modifier.height(25.dp))
                        }

//                        WeeklyQuestCompose(
//                            quest = weeklyQuests[0].value,
//                            onQuestChange = { updatedQuest ->
//                                weeklyQuests[0].value = updatedQuest
//                            })
//
//                        Spacer(modifier = Modifier.height(25.dp))
//
//                        WeeklyQuestCompose(
//                            quest = weeklyQuests[1].value,
//                            onQuestChange = { updatedQuest ->
//                                weeklyQuests[1].value = updatedQuest
//                            })
//
//                        Spacer(modifier = Modifier.height(25.dp))
                    }
                }
            }
        }
    }
}

fun resolveDrawableId(context: Context, iconName: String): Int {
    return context.resources.getIdentifier(iconName, "drawable", context.packageName)
}


fun mapToResolvedWeeklyQuests(context: Context, quests: List<WeeklyQuest>): List<ResolvedWeeklyQuest> {
    return quests.map { quest ->
        val iconId = resolveDrawableId(context, quest.progress.iconName)
        val resolvedProgress = ResolvedProgress(
            currentValue = quest.progress.currentValue,
            maxValue = quest.progress.maxValue,
            iconId = iconId
        )
        ResolvedWeeklyQuest(
            title = quest.title,
            information = quest.information,
            notAllowedFor = quest.notAllowedFor,
            progress = resolvedProgress,
            isChecked = quest.isChecked
        )
    }
}