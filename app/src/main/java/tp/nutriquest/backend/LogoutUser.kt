package tp.nutriquest.backend
import kotlinx.serialization.json.*
import java.io.File
import tp.nutriquest.ui.data.LoginUser
import tp.nutriquest.ui.data.Quest
import tp.nutriquest.ui.data.WeeklyQuest


fun LogoutUser() {
    val filename = "SessionUsername.json"
    val file = File(context.filesDir, filename)

    val json = Json { prettyPrint = true }
    file.writeText(json.encodeToString())


    println("User removed from session memory")
}
