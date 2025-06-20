package tp.nutriquest.backend
import tp.nutriquest.ui.data.RegisterUser
import tp.nutriquest.ui.data.Quest
import tp.nutriquest.ui.data.WeeklyQuest
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*
import java.io.File

@Serializable
data class BackendUser(
    val user: RegisterUser,
    val quests: List<Quest>,
    val weeklyQuests: List<WeeklyQuest>,
)

