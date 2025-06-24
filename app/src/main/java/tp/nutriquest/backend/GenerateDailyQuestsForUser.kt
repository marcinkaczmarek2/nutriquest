package tp.nutriquest.backend

import android.content.Context
import kotlinx.serialization.json.Json
import java.io.File
import tp.nutriquest.ui.data.RegisterUser
import tp.nutriquest.ui.data.Quest

fun GenerateDailyQuestsForUser(context: Context, user: RegisterUser?): List<Quest> {
    val AMOUNT_OF_QUESTS = 4
    val filename = "DailyQuests.json"
    val file = File(context.filesDir, filename)

    if (!file.exists() || user == null) {
        println("Critical error, QuestFile does not exist")
        return emptyList()
    }

    val json = file.readText()
    val questList = Json.decodeFromString<List<Quest>>(json)

    val userQuestList = mutableListOf<Quest>()
    var iter = 0

    for (quest in questList) {
        val skip = quest.notAllowedFor.any { problem ->
            problem == user.selectedDiet || problem in user.allergies
        }
        if (!skip) {
            userQuestList.add(quest)
            iter++
        }
        if (iter == AMOUNT_OF_QUESTS) break
    }

    println("User accessed from session memory")
    return userQuestList
}
