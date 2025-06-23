package tp.nutriquest.backend
import android.content.Context
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import java.io.File
import tp.nutriquest.ui.data.RegisterUser
import tp.nutriquest.ui.data.Quest
import tp.nutriquest.ui.data.WeeklyQuest


fun SaveUserData(context: Context, newUser: BackendUser) {
    val filename = "${newUser.user.email}.json"
    val file = File(context.filesDir, filename)

    if (!file.exists()) {
        println("User disappeared")
        return
    }

    // Serialize to JSON and save
    val json = Json { prettyPrint = true }
    file.writeText(json.encodeToString(newUser))

    println("User data saved")
}
