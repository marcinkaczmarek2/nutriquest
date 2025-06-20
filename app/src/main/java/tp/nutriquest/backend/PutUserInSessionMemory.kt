package tp.nutriquest.backend
import kotlinx.serialization.json.*
import java.io.File
import tp.nutriquest.ui.data.LoginUser
import tp.nutriquest.ui.data.Quest
import tp.nutriquest.ui.data.WeeklyQuest


fun PutUserInSessionMemory(email: String) {
    val filename = "SessionUsername.json"
    val file = File(context.filesDir, filename)


    val json = Json { prettyPrint = true }
    file.writeText(json.encodeToString(email))


    println("User put in session memory")
}
