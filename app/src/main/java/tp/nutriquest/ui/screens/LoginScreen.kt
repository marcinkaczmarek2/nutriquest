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
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import tp.nutriquest.R
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.BackgroundGrey
import tp.nutriquest.ui.theme.LoginYellow
import tp.nutriquest.ui.theme.TextFieldGreen
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.alpha
import tp.nutriquest.ui.components.CustomOutlinedTextField
import tp.nutriquest.ui.theme.Typography


@Composable
fun LoginScreenSetup(navController: NavController) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(BackgroundGreen)
    ) {
        // Logo + Teksty
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(BackgroundGrey)
                .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                .padding(vertical = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .background(
                            color = LoginYellow,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(12.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.nutriquest_logo),
                        contentDescription = "App logo",
                        modifier = Modifier
                            .height(120.dp) // było 200.dp
                            .width(160.dp)  // było 275.dp
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "NUTRIQUEST",
                    color = BackgroundGreen,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Text(
                    text = "YOUR PERSONAL",
                    color = BackgroundGreen,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = "NUTRITION CONTROLLER",
                    color = BackgroundGreen,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Login Panel bez offsetu
        LoginPanel(navController = navController)
    }
}


@Composable
fun LoginPanel(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMeChecked by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .background(Color.White)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CustomOutlinedTextField(
                label = "Email",
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomOutlinedTextField(
                label = "Password",
                value = password,
                onValueChange = { password = it },
                isPassword = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(0.9f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = rememberMeChecked,
                    onCheckedChange = { rememberMeChecked = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = BackgroundGreen,
                        uncheckedColor = BackgroundGreen,
                        checkmarkColor = Color.White
                    )
                )
                Text(
                    text = "Remember Me",
                    fontSize = 12.sp,
                    color = BackgroundGreen,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Forgot Password?",
                    fontSize = 12.sp,
                    color = BackgroundGreen
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    navController.navigate("home")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = LoginYellow,
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Login",
                    fontSize = 26.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(0.9f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Don't have an account?",
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Create an account",
                    fontSize = 12.sp,
                    color = BackgroundGreen,
                    modifier = Modifier.clickable {
                        navController.navigate("register_data")
                    }
                )
            }
        }
    }
}


