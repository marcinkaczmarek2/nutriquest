package tp.nutriquest.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
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
import tp.nutriquest.ui.theme.TextFieldGreen

@Composable
fun CustomOutlinedTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = label,
                color = Color.Black,
                modifier = Modifier.alpha(0.4f)
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(24.dp),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = BackgroundGreen,
            unfocusedBorderColor = BackgroundGreen,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            cursorColor = BackgroundGreen,
            focusedContainerColor = TextFieldGreen,
            unfocusedContainerColor = TextFieldGreen,
            focusedPlaceholderColor = Color.Gray,
            unfocusedPlaceholderColor = Color.Gray
        ),
        modifier = modifier
    )
}
