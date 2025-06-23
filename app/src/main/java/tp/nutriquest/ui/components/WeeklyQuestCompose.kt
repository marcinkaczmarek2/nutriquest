package tp.nutriquest.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tp.nutriquest.R
import tp.nutriquest.ui.data.ResolvedWeeklyQuest
import tp.nutriquest.ui.data.WeeklyQuest
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.LoginTextGreen
import tp.nutriquest.ui.theme.LoginYellow
import tp.nutriquest.ui.theme.QuestCheckedTextGreen
import tp.nutriquest.ui.theme.WeeklyQuestGreen

@Composable
fun WeeklyQuestCompose(
    quest: ResolvedWeeklyQuest,
    onQuestChange: (ResolvedWeeklyQuest) -> Unit
) {
    val isChecked = quest.progress.currentValue >= quest.progress.maxValue

    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isChecked) LoginTextGreen else WeeklyQuestGreen
        ),
        border = if (isChecked) BorderStroke(2.dp, LoginTextGreen) else BorderStroke(2.dp, WeeklyQuestGreen)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .align(Alignment.CenterHorizontally),
                colors = CardDefaults.cardColors(
                    containerColor = if (isChecked) QuestCheckedTextGreen else BackgroundGreen
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = quest.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.question_icon),
                    contentDescription = "question mark",
                    colorFilter = ColorFilter.tint(LoginYellow),
                    modifier = Modifier.size(25.dp).alpha(0.75f)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = quest.information,
                    color = Color.White,
                    fontSize = 12.sp,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            CheckpointProgressBar(progress = quest.progress)

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {
                        if (quest.progress.currentValue > 0) {
                            val updatedQuest = quest.copy(
                                progress = quest.progress.copy(
                                    currentValue = quest.progress.currentValue - 1
                                )
                            )
                            onQuestChange(updatedQuest)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = WeeklyQuestGreen
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("-", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }

                Button(
                    onClick = {
                        if (quest.progress.currentValue < quest.progress.maxValue) {
                            val updatedQuest = quest.copy(
                                progress = quest.progress.copy(
                                    currentValue = quest.progress.currentValue + 1
                                )
                            )
                            onQuestChange(updatedQuest)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LoginYellow,
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("+", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}


