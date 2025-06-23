package tp.nutriquest.ui.data

import androidx.compose.runtime.MutableState
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*
import java.io.File

@Serializable
data class WeeklyQuest(
    val title: String,
    val information: String,
    val notAllowedFor: List<String>,
    var progress: Progress,
    var isChecked: Boolean
)



