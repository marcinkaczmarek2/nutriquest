package tp.nutriquest.backend
import kotlinx.serialization.json.*
import java.io.File
import tp.nutriquest.ui.data.RegisterUser
import tp.nutriquest.ui.data.Quest
import tp.nutriquest.ui.data.WeeklyQuest


fun GenerateWeeklyQuestsForUser( user: RegisterUser) : List<WeeklyQuest> {

    filename = "WeeklyQuests.json

    file = File(context.filesDir, filename)
    if (!file.exists()) {
        println("Critical error, QuestFile does not exist")
        return
    }
    json = file.readText()
    val questList = Json.decodeFromString<List<WeeklyQuest>>(json)

    cal
    println("User accesed from session memory")
    val userQuestList: MutableList<Quest>
    var iter = 0
    for (quest in questList) {
        for(problem in quest.notAllowedFor)
        {
            if(problem == user.user.selectedDiet || problem in user.user.allergies)
            {
                break
            }
        }
        userQuestList.add(quest)
        iter++
        if(iter == 3) break
    }
    return userQuestList
}
