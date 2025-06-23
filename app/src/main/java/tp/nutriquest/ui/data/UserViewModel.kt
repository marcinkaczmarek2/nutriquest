package tp.nutriquest.ui.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    var currentUser by mutableStateOf<RegisterUser?>(null)
        private set

    fun setUser(user: RegisterUser) {
        currentUser = user
    }


    fun getUser(): RegisterUser? {
        return currentUser
    }
}