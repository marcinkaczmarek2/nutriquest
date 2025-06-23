package tp.nutriquest.ui.data
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*
import java.io.File

@Serializable
data class RegisterUser (
    val email: String,
    val name: String,
    val surname: String,
    val username: String,
    val password: String,
    val height: String,
    val weight: String,
    val gender: String,
    val physicalActivity: Float,
    val selectedDiet: String,
    val mealsPerDay: Float,
    val allergies: List<String>,
    val litersOfWater: Float,
    val goals: List<String>,
)
