package tp.nutriquest.ui.data

import androidx.compose.runtime.MutableState
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*
import java.io.File

@Serializable
data class WeeklyQuest(
    val title: String,
    val information: String,
    var notAllowedFor: List<String>,
    val progress: MutableState<Progress>,
    val isChecked: MutableState<Boolean>
)



