package tp.nutriquest.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import tp.nutriquest.ui.components.CustomOutlinedTextField
import tp.nutriquest.ui.components.RegisterTopMenu
import tp.nutriquest.ui.components.YellowButton
import tp.nutriquest.ui.data.RegisterViewModel
import tp.nutriquest.ui.theme.BackgroundGrey
import tp.nutriquest.backend.*

@Composable
fun RegisterDataScreenInitialize(navController: NavController, viewModel: RegisterViewModel = viewModel()) {
    val configuration = LocalConfiguration.current
    val screenHeightDp: Dp = configuration.screenHeightDp.dp
    val boxHeight = screenHeightDp * 0.25f
    val textFieldOffset = boxHeight + 20.dp
    val spaceBetweenFields = 24.dp
    val fieldWidth = 0.85f

    var email by remember { mutableStateOf(viewModel.email) }
    var name by remember { mutableStateOf(viewModel.name) }
    var surname by remember { mutableStateOf(viewModel.surname) }
    var username by remember { mutableStateOf(viewModel.username) }
    var password by remember { mutableStateOf(viewModel.password) }
    var height by remember { mutableStateOf(viewModel.height) }
    var weight by remember { mutableStateOf(viewModel.weight) }
    var gender by remember { mutableStateOf(viewModel.gender) }
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

                    YellowButton(
                        navController, "Continue", "register_activity",
                        modifier = Modifier.fillMaxWidth(fieldWidth),
                        onClickExtra = {
                            viewModel.email = email
                            viewModel.name = name
                            viewModel.surname = surname
                            viewModel.username = username
                            viewModel.password = password
                            viewModel.height = height
                            viewModel.weight = weight
                            viewModel.gender = gender
                            //TODO tutaj jest tworzona data part RegisterUser
                        }
                    )
                }
            }
            //green box (upper one)
            RegisterTopMenu("CREATE YOUR ACCOUNT", navController, "login")
        }
    }
}




