package tp.nutriquest.ui.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {
    var email by mutableStateOf("")
    var name by mutableStateOf("")
    var surname by mutableStateOf("")
    var username by mutableStateOf("")
    var password by mutableStateOf("")
    var height by mutableStateOf("")
    var weight by mutableStateOf("")
    var gender by mutableStateOf("")
    var physicalActivity by mutableStateOf(0f)
    var selectedDiet by mutableStateOf("")
    var mealsPerDay by mutableStateOf(0f)
    var allergies by mutableStateOf(listOf<String>())
    var litersOfWater by mutableStateOf(0f)
    var goals by mutableStateOf(listOf<String>())

    fun toRegisterUser(): RegisterUser {
        return RegisterUser(
            email = email,
            name = name,
            surname = surname,
            username = username,
            password = password,
            height = height,
            weight = weight,
            gender = gender,
            physicalActivity = physicalActivity,
            selectedDiet = selectedDiet,
            mealsPerDay = mealsPerDay,
            allergies = allergies,
            litersOfWater = litersOfWater,
            goals = goals
        )
    }
}
