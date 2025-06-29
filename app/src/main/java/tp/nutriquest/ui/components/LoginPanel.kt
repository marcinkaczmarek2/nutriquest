package tp.nutriquest.ui.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import tp.nutriquest.R
import tp.nutriquest.ui.data.LoginUser
import tp.nutriquest.ui.theme.LoginTextGreen
import tp.nutriquest.backend.*
import tp.nutriquest.ui.data.RegisterUser
import tp.nutriquest.ui.data.UserViewModel

@Composable
fun LoginPanel(navController: NavController, userViewModel: UserViewModel) {
    var email by remember { mutableStateOf("") } //TODO stad brac email i password do stworzenia loginusera
    var password by remember { mutableStateOf("") }
    var rememberMeChecked by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val superUser = RegisterUser(
        email = "superuser@gmail.com",
        name = "Super",
        surname = "User",
        username = "superuser",
        password = "123",
        height = "180",
        weight = "75",
        gender = "male",
        physicalActivity = 1.2f,
        selectedDiet = "Balanced",
        mealsPerDay = 3f,
        allergies = emptyList(), // brak alergii
        litersOfWater = 2.0f,
        goals = listOf("Improve overall wellbeing", "Improve appearance", "Support physical activity")
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 10.dp,
                    topEnd = 10.dp,
                    bottomStart = 10.dp,
                    bottomEnd = 10.dp
                )
            )
            .background(Color.White)
            .padding(horizontal = 24.dp, vertical = 40.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            LoginPanelTextField(
                label = "Email",
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                imageId = R.drawable.user_icon
            )

            Spacer(modifier = Modifier.height(24.dp))

            LoginPanelTextField(
                label = "Password",
                value = password,
                onValueChange = { password = it },
                isPassword = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                imageId = R.drawable.password_icon
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = rememberMeChecked,
                    onCheckedChange = { rememberMeChecked = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = LoginTextGreen,
                        uncheckedColor = LoginTextGreen,
                        checkmarkColor = Color.White
                    )
                )
                Text(
                    text = "Remember Me",
                    fontSize = 12.sp,
                    color = LoginTextGreen,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Forgot Password?",
                    fontSize = 12.sp,
                    color = LoginTextGreen
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            val route = remember { mutableStateOf("") }

            LaunchedEffect(route.value) {
                if (route.value.isNotBlank()) {
                    navController.navigate(route.value)
                    route.value = ""
                }
            }

            YellowButton(
                navController = navController,
                text = "Login",
                navigation = "noop",
                modifier = Modifier.fillMaxWidth(),
                onClickExtra = {
                    if (email.isNotBlank() && password.isNotBlank()) {
                        val loginUser = LoginUser(email = email, password = password)
                        if (LoginUserFunction(context, loginUser)) {
                            userViewModel.setUser(superUser)
                            Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                            route.value = "home"
                        } else {
                            Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(context, "Email and password cannot be empty", Toast.LENGTH_SHORT).show()
                    }
                }
            )





            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.fillMaxWidth(0.8f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Don't have an account?",
                    fontSize = 11.sp
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Create an account",
                    fontSize = 11.sp,
                    color = LoginTextGreen,
                    modifier = Modifier.clickable {
                        navController.navigate("register_data")
                    }
                )
            }
        }
    }
}
