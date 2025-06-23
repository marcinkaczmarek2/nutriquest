package tp.nutriquest.backend
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import java.io.File
import tp.nutriquest.ui.data.RegisterUser
import tp.nutriquest.ui.data.Quest
import tp.nutriquest.ui.data.WeeklyQuest
import tp.nutriquest.backend.GenerateDailyQuestsForUser
import tp.nutriquest.backend.GenerateWeeklyQuestsForUser


fun RegisterUserFunction(user: RegisterUser) {
    val filename = "${user.email}.json"
    val file = File(filename)

    if (file.exists()) {
        println("User with email '${user.email}' already exists.")
        return
    }

    val backendUser = BackendUser(
        user,
        GenerateDailyQuestsForUser(user),
        GenerateWeeklyQuestsForUser(user),
        )

    // Serialize to JSON and save
    val json = Json { prettyPrint = true }
    file.writeText(json.encodeToString<BackendUser>(backendUser))
    PutUserInSessionMemory(user.email)
    println("New user registered and saved to ${file.absolutePath}")
}
