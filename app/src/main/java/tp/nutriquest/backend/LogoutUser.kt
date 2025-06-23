package tp.nutriquest.backend
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import java.io.File
import tp.nutriquest.ui.data.LoginUser
import tp.nutriquest.ui.data.Quest
import tp.nutriquest.ui.data.WeeklyQuest


fun LogoutUser() {
    val filename = "SessionUsername.json"
    val file = File(filename)

    file.writeText("")  // wyczyszczenie pliku

    println("User removed from session memory")
}
