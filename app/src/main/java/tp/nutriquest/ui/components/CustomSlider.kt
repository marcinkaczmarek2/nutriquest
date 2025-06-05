package tp.nutriquest.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableFloatState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.LoginYellow

@Composable
fun CustomSlider(sliderValue: MutableFloatState, componentWidth: Float, sliderMiddleLegend: String,
                 minValue: Float, maxValue: Float, sliderTitle: String, sliderAdditionalText: String){

    SliderTitle(sliderValue, componentWidth, sliderTitle, sliderAdditionalText)

    Spacer(modifier = Modifier.height(2.dp))

    Slider(
        value = sliderValue.value,
        onValueChange = { sliderValue.value = it },
        valueRange = minValue..maxValue,
        steps = 0,
        colors = SliderDefaults.colors(
            activeTrackColor = BackgroundGreen,
            inactiveTrackColor = Color.White,
            thumbColor = LoginYellow
        ),
        modifier = Modifier
            .fillMaxWidth(componentWidth)
    )

    Spacer(modifier = Modifier.height(2.dp))

    SliderLegend(componentWidth, minValue, sliderMiddleLegend, maxValue)
}

@Composable
fun SliderTitle(
    sliderValue: MutableFloatState,
    componentWidth: Float,
    title: String,
    additionalText: String
) {
    val sliderTitle = "$title: ${sliderValue.value.toInt()} $additionalText"

    Text(
        text = sliderTitle,
        fontSize = 16.sp,
        textAlign = TextAlign.Start,
        fontWeight = FontWeight.Bold,
        color = BackgroundGreen,
        modifier = Modifier
            .fillMaxWidth(componentWidth)
    )
}

@Composable
fun SliderLegend(componentWidth: Float, minValue: Float, sliderMiddleLegend: String, maxValue: Float){
    Row(
        modifier = Modifier
            .fillMaxWidth(componentWidth)
    ) {
        Text(
            text = minValue.toInt().toString(),
            color = BackgroundGreen,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Start
        )

        Text(
            text = sliderMiddleLegend,
            color = BackgroundGreen,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )

        Text(
            text = maxValue.toInt().toString(),
            color = BackgroundGreen,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.End
        )
    }
}