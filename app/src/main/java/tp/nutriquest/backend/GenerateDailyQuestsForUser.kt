package tp.nutriquest.backend

import kotlinx.serialization.json.Json
import java.io.File
import tp.nutriquest.ui.data.RegisterUser
import tp.nutriquest.ui.data.Quest

fun GenerateDailyQuestsForUser(user: RegisterUser): List<Quest> {
    val AMOUNT_OF_QUESTS = 5
    val filename = "DailyQuests.json"
    val file = File(filename)

    if (!file.exists()) {
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
