package tp.nutriquest.ui.data

import androidx.compose.runtime.MutableState

data class WeeklyQuest(
    val title: String,
    val information: String,
    val progress: MutableState<Progress>,
    val isChecked: MutableState<Boolean>
)



