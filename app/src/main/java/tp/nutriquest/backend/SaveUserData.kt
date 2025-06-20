package tp.nutriquest.backend
import kotlinx.serialization.json.*
import java.io.File
import tp.nutriquest.ui.data.RegisterUser
import tp.nutriquest.ui.data.Quest
import tp.nutriquest.ui.data.WeeklyQuest


fun SaveUserData(newUser: BackendUser) {
    val filename = "${newUser.user.email}.json"
    val file = File(context.filesDir, filename)

    if (!file.exists()) {
        println("User disapeared")
        return
    }

    // Serialize to JSON and save
    val json = Json { prettyPrint = true }
    file.writeText(json.encodeToString(newUser))

    println("User data saved")
}
