package tp.nutriquest.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tp.nutriquest.ui.theme.LoginYellow

@Composable
fun RegisterHeaderText(headerText: String){
    Text(
        text = headerText,
        modifier = Modifier
            .padding(top = 80.dp)
            .fillMaxWidth(),
        color = LoginYellow,
        textAlign = TextAlign.Center,
        letterSpacing = 2.sp,
        fontSize = 44.sp,
        fontWeight = FontWeight.ExtraBold,
        style = TextStyle(
            lineHeight = 60.sp
        )
    )
}