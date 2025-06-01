package tp.nutriquest.ui.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf


data class Quest(
    var title: String,
    var information: String,
    val isChecked: MutableState<Boolean> = mutableStateOf(false)
)

