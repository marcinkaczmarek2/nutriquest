package tp.nutriquest.ui.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*
import kotlinx.serialization.Transient

@Serializable
data class Quest(
    val title: String,
    val information: String,
    val notAllowedFor: List<String>,
    val isChecked: Boolean = false
) {
    @Transient
    val checkedState: MutableState<Boolean> = mutableStateOf(isChecked)
}

