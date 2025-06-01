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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.OutlinedTextField
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
import tp.nutriquest.R
import tp.nutriquest.ui.theme.BackgroundGreen
import tp.nutriquest.ui.theme.BackgroundGrey
import tp.nutriquest.ui.theme.LoginYellow
import tp.nutriquest.ui.theme.TextFieldGreen
import tp.nutriquest.ui.theme.Typography


@Composable
fun LoginScreenSetup() {
    val configuration = LocalConfiguration.current
    val screenHeightDp: Dp = configuration.screenHeightDp.dp
    val boxHeight = screenHeightDp * 0.75f

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            //green box (lower one)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BackgroundGreen)
            )

            //grey box (upper one)
            Box(

                modifier = Modifier
                    .fillMaxWidth()
                    .height(boxHeight)
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 10.dp,
                            bottomEnd = 10.dp
                        )
                    )
                    .background(BackgroundGrey),
                contentAlignment = Alignment.Center,
            ) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .background(
                                    color = LoginYellow,
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .padding(16.dp)

                        ) {
                            Image(
                                //TODO LOGO JEST TROCHE ROZPIXELOWOWANE WIEC FAJNIE BY BYLO JE PODMIENIC NA SVG
                                painter = painterResource(R.drawable.nutriquest_logo),
                                contentDescription = "App logo",
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(275.dp)
                            )
                        }

                        Text(
                            text = "NUTRIQUEST",
                            modifier = Modifier.padding(top = 20.dp),
                            color = BackgroundGreen,
                            fontSize = 36.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = "YOUR PERSONAL",
                            modifier = Modifier.padding(top = 2.dp),
                            color = BackgroundGreen,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = "NUTRITION CONTROLLER",
                            color = BackgroundGreen,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium
                        )


                    }
                }
            }
        }
        LoginPanel(offsetFromTop = boxHeight - 150.dp)
    }
}

@Composable
fun LoginPanel(offsetFromTop: Dp) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .absoluteOffset(y = offsetFromTop)
            .background(Color.White)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            //TODO ZROBIC ZEBY SIE DALO PISAC W TYCH FIELDACH
            OutlinedTextField(
                value = "Email",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(TextFieldGreen)
                    .border(0.dp, TextFieldGreen)
                //TODO dodac ikonke user
                //TODO zapisywac gdzies wczytywane dane, badz je gdzies przekazywac
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = "Password",
                onValueChange = {},
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(TextFieldGreen)
                    .border(0.dp, TextFieldGreen)
                //TODO dodac ikonke klodki
                //TODO zapisywac gdzies wczytywane dane, badz je gdzies przekazywac
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(0.9f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = false,
                    onCheckedChange = {},
                    //TODO zmienic kolor checkbox oraz zeby sie dalo zaznaczyc
                )
                Text(
                    text = "Remember Me",
                    fontSize = 12.sp,
                    color = BackgroundGreen,
                    modifier = Modifier.padding(start = 8.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Forgot Password?",
                    fontSize = 12.sp,
                    color = BackgroundGreen
                    //TODO dodac mozliwosc klikniecia (nwm czy wprowadzamy to)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                //TODO w onClick funkcja sprawdzajaca czy dane sie zgadzaja (zwraca true jezeli sie zgadzaja)
                //TODO jezeli FALSE wyswietla sie odpowiedni komunikat
                //TODO jezeli TRUE zostajemy przeniesieni do odpowiedniego ekranu
                onClick = {},
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
                    modifier = Modifier
                        .clickable {
                            //TODO przeniesc do RegisterScreen (trzeba go napisac)
                        }
                )
            }


        }

    }
}

