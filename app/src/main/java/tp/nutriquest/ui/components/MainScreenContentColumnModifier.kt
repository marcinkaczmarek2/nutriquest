package tp.nutriquest.ui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

fun MainScreenContentColumnModifier(scrollState: ScrollState): Modifier {
    return Modifier
        .fillMaxWidth(0.8f)
        .fillMaxHeight(0.9f)
        .padding(top = 70.dp)
        .clip(RoundedCornerShape(20.dp))
        .background(Color.White)
        .padding(16.dp)
        .verticalScroll(scrollState)
}
