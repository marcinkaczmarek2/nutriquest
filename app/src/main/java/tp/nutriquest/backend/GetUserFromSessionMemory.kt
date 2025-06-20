package tp.nutriquest.backend
import kotlinx.serialization.json.*
import java.io.File
import tp.nutriquest.ui.data.LoginUser
import tp.nutriquest.ui.data.Quest
import tp.nutriquest.ui.data.WeeklyQuest


fun GetUserFromSessionMemory() : BackendUser {
    val filename = "SessionUsername.json"
    val file = File(context.filesDir, filename)
    if (!file.exists()) {
        println("Critical error, memory does not exist")
        return
    }
    val json = file.readText()
    val mail = Json.decodeFromString<String>(json)

    //val backendUser = Json.decodeFromString<BackendUser>(json)

    filename = "${mail}.json"
    file = File(context.filesDir, filename)
    if (!file.exists()) {
        println("Critical error, User does not exist")
        return
    }
    json = file.readText()
    val backendUser = Json.decodeFromString<BackendUser>(json)
    println("User accesed from session memory")

    return backendUser;

    // Serialize to JSON and save


}
