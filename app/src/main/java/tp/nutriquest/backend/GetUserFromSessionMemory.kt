package tp.nutriquest.backend
import kotlinx.serialization.json.Json
import java.io.File


fun GetUserFromSessionMemory() : BackendUser? {
    var filename = "SessionUsername.json"
    var file = File(filename)
    if (!file.exists()) {
        println("Critical error, memory does not exist")
        return null
    }
    var json = file.readText()
    val mail = Json.decodeFromString<String>(json)

    //val backendUser = Json.decodeFromString<BackendUser>(json)

    filename = "${mail}.json"
    file = File(filename)
    if (!file.exists()) {
        println("Critical error, User does not exist")
        return null
    }
    json = file.readText()
    val backendUser = Json.decodeFromString<BackendUser>(json)
    println("User accesed from session memory")

    return backendUser

    // Serialize to JSON and save


}
