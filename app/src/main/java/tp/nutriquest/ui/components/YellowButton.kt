package tp.nutriquest.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import tp.nutriquest.ui.theme.LoginYellow

@Composable
fun YellowButton(
    navController: NavController,
    text: String,
    navigation: String,
    modifier: Modifier,
    onClickExtra: (() -> Unit)? = null
) {
    Button(
        onClick = {
            onClickExtra?.invoke()
            navController.navigate(navigation)
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = LoginYellow,
            contentColor = Color.White
        ),
        modifier = modifier
    ) {
        Text(
            text = text,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
    }
}