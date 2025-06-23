package tp.nutriquest.ui.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*
import java.io.File

@Serializable
data class Quest(
    var title: String,
    var information: String,
    var notAllowedFor: List<String>,
    val isChecked: MutableState<Boolean> = mutableStateOf(false)
)

