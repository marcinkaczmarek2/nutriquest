package tp.nutriquest.backend
import kotlinx.serialization.json.*
import java.io.File
import tp.nutriquest.ui.data.LoginUser
import tp.nutriquest.ui.data.Quest
import tp.nutriquest.ui.data.WeeklyQuest


fun LoginUserFunction(user: LoginUser) : boolean {
    val filename = "${user.email}.json"
    val file = File(context.filesDir, filename)
    if (!file.exists()) {
        println("Login Failed")
        return false
    }
    //val json = file.readText()
    //val backendUser = Json.decodeFromString<BackendUser>(json)
    PutUserInSessionMemory(user.email)
    println("New user logined and saved to ${file.absolutePath}")
    return true

    // Serialize to JSON and save


}
