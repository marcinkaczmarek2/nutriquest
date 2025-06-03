package tp.nutriquest.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import tp.nutriquest.ui.components.CustomOutlinedTextField
import tp.nutriquest.ui.components.RegisterTopMenu
import tp.nutriquest.ui.components.YellowButton
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.BackgroundGrey
import tp.nutriquest.ui.theme.LoginYellow

@Composable
fun RegisterDataScreenInitialize(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenHeightDp: Dp = configuration.screenHeightDp.dp
    val boxHeight = screenHeightDp * 0.25f
    val textFieldOffset = boxHeight + 20.dp
    val spaceBetweenFields = 24.dp
    val fieldWidth = 0.85f

    var email by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            //grey box (lower one)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BackgroundGrey)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .verticalScroll(scrollState)
                        .padding(bottom = 50.dp)
                ) {
                    //TODO na wszystkich guzikach zmienic kolor tekstu, naprawic ramki, tekst bardziej do prawej
                    Spacer(modifier = Modifier.height(textFieldOffset))

                    CustomOutlinedTextField(
                        label = "Email",
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier
                            .fillMaxWidth(fieldWidth)
                    )

                    Spacer(modifier = Modifier.height(spaceBetweenFields))

                    CustomOutlinedTextField(
                        label = "Name",
                        value = name,
                        onValueChange = { name = it },
                        modifier = Modifier
                            .fillMaxWidth(fieldWidth)
                    )

                    Spacer(modifier = Modifier.height(spaceBetweenFields))

                    CustomOutlinedTextField(
                        label = "Surname",
                        value = surname,
                        onValueChange = { surname = it },
                        modifier = Modifier
                            .fillMaxWidth(fieldWidth)
                    )

                    Spacer(modifier = Modifier.height(spaceBetweenFields))

                    CustomOutlinedTextField(
                        label = "Username",
                        value = username,
                        onValueChange = { username = it },
                        modifier = Modifier
                            .fillMaxWidth(fieldWidth)
                    )

                    Spacer(modifier = Modifier.height(spaceBetweenFields))

                    CustomOutlinedTextField(
                        label = "Password",
                        value = password,
                        onValueChange = { password = it },
                        isPassword = true,
                        modifier = Modifier
                            .fillMaxWidth(fieldWidth)
                    )

                    Spacer(modifier = Modifier.height(spaceBetweenFields))

                    CustomOutlinedTextField(
                        label = "Height",
                        value = height,
                        onValueChange = { height = it },
                        modifier = Modifier
                            .fillMaxWidth(fieldWidth)
                    )


                    Spacer(modifier = Modifier.height(spaceBetweenFields))

                    CustomOutlinedTextField(
                        label = "Weight",
                        value = weight,
                        onValueChange = { weight = it },
                        modifier = Modifier
                            .fillMaxWidth(fieldWidth)
                    )


                    Spacer(modifier = Modifier.height(spaceBetweenFields))

                    CustomOutlinedTextField(
                        label = "Gender",
                        value = gender,
                        onValueChange = { gender = it },
                        modifier = Modifier
                            .fillMaxWidth(fieldWidth)
                    )

                    Spacer(modifier = Modifier.height(spaceBetweenFields + 10.dp))

                    YellowButton(navController, "Continue", "register_activity", modifier = Modifier.fillMaxWidth(fieldWidth))
                }
            }
            //green box (upper one)
            RegisterTopMenu("CREATE YOUR ACCOUNT", navController, "login")
        }
    }
}




