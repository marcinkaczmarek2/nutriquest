package tp.nutriquest.backend
import kotlinx.serialization.json.*
import java.io.File
import tp.nutriquest.ui.data.RegisterUser
import tp.nutriquest.ui.data.Quest
import tp.nutriquest.ui.data.WeeklyQuest


fun RegisterUserFunction(user: RegisterUser) {
    val filename = "${user.email}.json"
    val file = File(context.filesDir, filename)

    if (file.exists()) {
        println("User with email '${user.email}' already exists.")
        return
    }

    val backendUser = BackendUser(
        user,
        GenerateDailyQuestsForUser,
        GenerateWeeklyQuestsForUser,
        )

    // Serialize to JSON and save
    val json = Json { prettyPrint = true }
    file.writeText(json.encodeToString(backendUser))
    PutUserInSessionMemory(user.email)
    println("New user registered and saved to ${file.absolutePath}")
}
