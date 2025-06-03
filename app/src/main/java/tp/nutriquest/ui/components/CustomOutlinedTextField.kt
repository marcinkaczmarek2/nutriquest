package tp.nutriquest.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.QuestGreen
import tp.nutriquest.ui.theme.TextFieldGreen

@Composable
fun CustomOutlinedTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false,
    modifier: Modifier = Modifier
) {
    val visualTransformation =
        if (isPassword) PasswordVisualTransformation() else VisualTransformation.None

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        visualTransformation = visualTransformation,
        singleLine = true,
        textStyle = LocalTextStyle.current.copy(color = Color.Black),
        modifier = modifier
            .background(Color.White, shape = RoundedCornerShape(24.dp))
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(24.dp)
            )
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .fillMaxWidth(),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                if (value.isEmpty()) {
                    Text(
                        text = label,
                        color = Color.Black.copy(alpha = 0.4f)
                    )
                }
                innerTextField()
            }
        }
    )
}
