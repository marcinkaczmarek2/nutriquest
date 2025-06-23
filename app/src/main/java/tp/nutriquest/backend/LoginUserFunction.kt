package tp.nutriquest.backend
import android.content.Context
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import java.io.File
import tp.nutriquest.ui.data.LoginUser
import tp.nutriquest.ui.data.Quest
import tp.nutriquest.ui.data.WeeklyQuest


fun LoginUserFunction(context: Context, user: LoginUser) : Boolean {
    val filename = "${user.email}.json"
    val file = File(context.filesDir, filename)
    if (!file.exists()) {
        println("Login Failed")
        return false
    }
    //val json = file.readText()
    //val backendUser = Json.decodeFromString<BackendUser>(json)
    PutUserInSessionMemory(context, user.email)
    println("New user logged in and saved to ${file.absolutePath}")
    return true

    // Serialize to JSON and save
    //TODO niech zwraca odpowiednie obiekt RegisterUser, jezeli nie uda sie logowanie to niech zwroci null

}
