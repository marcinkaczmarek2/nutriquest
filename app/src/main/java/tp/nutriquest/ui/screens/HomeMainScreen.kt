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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import tp.nutriquest.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.BackgroundGrey
import tp.nutriquest.ui.theme.LoginYellow
import tp.nutriquest.ui.theme.QuestGreen
import tp.nutriquest.ui.data.Quest
import tp.nutriquest.ui.components.IconRow
import tp.nutriquest.ui.components.QuestCompose


@Composable
fun HomeMainScreenInitialize() {
    val configuration = LocalConfiguration.current
    val screenHeightDp: Dp = configuration.screenHeightDp.dp
    val boxHeight = screenHeightDp * 0.9f
    val lowerMenuOffset = boxHeight + 20.dp
    val scrollState = rememberScrollState()
    val quests = remember {
        listOf(
            Quest("2 liters of water",
                "Staying hydrated improves focus and overall mood.",
                mutableStateOf(false)),
            Quest("2 cubes of dark chocolate",
                "Flavonoids can enchance blood flow to your brain, boosting mental clarity and reducing stress.",
            mutableStateOf(false)),
            Quest("a banana",
                "Packed with potassium, it supports muscle function and helps prevent cramps.",
                mutableStateOf(false)),
            Quest("2 liters of water",
                "Staying hydrated improves focus and overall mood.",
                mutableStateOf(false)),
        )
    }


        Box(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(BackgroundGreen)
                )   {
                    //TODO zaimplementowac na stale akcje na klikniecie, zeby przy kazdym wywolaniu nie musiec tego implementowac
                    IconRow(
                        onHomeClick = {  },
                        onStatsClick = {  },
                        onEducationClick = {  },
                        onOptionsClick = {  },
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
                                text = "TODAY'S QUESTS",
                                fontSize = 26.sp,
                                color = BackgroundGreen,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            QuestCompose(quests[0])

                            Spacer(modifier = Modifier.height(25.dp))

                            QuestCompose(quests[1])

                            Spacer(modifier = Modifier.height(25.dp))

                            QuestCompose(quests[2])

                            Spacer(modifier = Modifier.height(25.dp))

                            QuestCompose(quests[3])

                        }
                    }
                }
            }
        }
    }


