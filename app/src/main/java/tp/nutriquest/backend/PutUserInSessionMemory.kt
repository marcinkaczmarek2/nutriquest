package tp.nutriquest.backend
import android.content.Context
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import java.io.File
import tp.nutriquest.ui.data.LoginUser
import tp.nutriquest.ui.data.Quest
import tp.nutriquest.ui.data.WeeklyQuest


fun PutUserInSessionMemory(context: Context,email: String) {
    val filename = "SessionUsername.json"
    val file = File(context.filesDir, filename)


    val json = Json { prettyPrint = true }
    file.writeText(json.encodeToString(email))


    println("User put in session memory")
}
