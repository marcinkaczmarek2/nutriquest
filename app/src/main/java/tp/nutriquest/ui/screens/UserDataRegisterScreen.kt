package tp.nutriquest.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import tp.nutriquest.ui.components.CustomOutlinedTextField
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.BackgroundGrey
import tp.nutriquest.ui.theme.LoginYellow

@Composable
fun UserDataRegisterScreenInitialize(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenHeightDp: Dp = configuration.screenHeightDp.dp
    val boxHeight = screenHeightDp * 0.25f
    val textFieldOffset = boxHeight + 20.dp
    val fieldWidth = 0.8f

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
                    modifier = Modifier.fillMaxSize()
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
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CustomOutlinedTextField(
                        label = "Name",
                        value = name,
                        onValueChange = { name = it },
                        modifier = Modifier
                            .fillMaxWidth(fieldWidth)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CustomOutlinedTextField(
                        label = "Surname",
                        value = surname,
                        onValueChange = { surname = it },
                        modifier = Modifier
                            .fillMaxWidth(fieldWidth)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CustomOutlinedTextField(
                        label = "Username",
                        value = username,
                        onValueChange = { username = it },
                        modifier = Modifier
                            .fillMaxWidth(fieldWidth)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CustomOutlinedTextField(
                        label = "Password",
                        value = password,
                        onValueChange = { password = it },
                        isPassword = true,
                        modifier = Modifier
                            .fillMaxWidth(fieldWidth)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CustomOutlinedTextField(
                        label = "Height",
                        value = height,
                        onValueChange = { height = it },
                        modifier = Modifier
                            .fillMaxWidth(fieldWidth)
                            .align(Alignment.CenterHorizontally)
                    )


                    Spacer(modifier = Modifier.height(16.dp))

                    CustomOutlinedTextField(
                        label = "Weight",
                        value = weight,
                        onValueChange = { weight = it },
                        modifier = Modifier
                            .fillMaxWidth(fieldWidth)
                            .align(Alignment.CenterHorizontally)
                    )


                    Spacer(modifier = Modifier.height(16.dp))

                    CustomOutlinedTextField(
                        label = "Gender",
                        value = gender,
                        onValueChange = { gender = it },
                        modifier = Modifier
                            .fillMaxWidth(fieldWidth)
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        //TODO dodac onClick przeslanie tych danych a konkretnie funkcje validujaca dane, a nastepnie
                        //TODO jezeli FALSE wyswietla sie odpowiedni komunikat
                        //TODO jezeli TRUE zostajemy przeniesieni do odpowiedniego ekranu
                        onClick = {
                            navController.navigate("register_activity")
                        }, colors = ButtonDefaults.buttonColors(
                            containerColor = LoginYellow, contentColor = Color.White
                        ), modifier = Modifier
                            .fillMaxWidth(fieldWidth)
                    ) {
                        Text(
                            text = "Continue", fontSize = 26.sp
                        )
                    }
                }
            }
            //green box (upper one)
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(boxHeight)
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 10.dp, bottomEnd = 10.dp
                        )
                    )
                    .background(BackgroundGreen)
            ) {
                Text(
                    text = "CREATE YOUR ACCOUNT",
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(),
                    color = LoginYellow,
                    textAlign = TextAlign.Center,
                    letterSpacing = 1.sp,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.ExtraBold,
                    style = TextStyle(
                        lineHeight = 44.sp
                    )
                )
            }
        }
    }
}
