package tp.nutriquest.ui.data

import kotlinx.serialization.Serializable

@Serializable
data class Progress(
    val currentValue: Int,
    val maxValue: Int,
    val iconName: String,
)
