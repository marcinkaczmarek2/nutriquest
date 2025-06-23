package tp.nutriquest.backend
import android.content.Context
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import java.io.File
import tp.nutriquest.ui.data.RegisterUser


fun RegisterUserFunction(context: Context, user: RegisterUser) {
    val filename = "${user.email}.json"
    val file = File(context.filesDir, filename)

    if (file.exists()) {
        println("User with email '${user.email}' already exists.")
        return
    }

    val backendUser = BackendUser(
        user,
        GenerateDailyQuestsForUser(context, user),
        GenerateWeeklyQuestsForUser(context, user),
    )

    val json = Json { prettyPrint = true }
    file.writeText(json.encodeToString(backendUser))
    PutUserInSessionMemory(context, user.email)
    println("New user registered and saved to ${file.absolutePath}")
}

