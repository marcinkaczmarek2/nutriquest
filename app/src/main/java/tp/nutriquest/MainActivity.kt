package tp.nutriquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tp.nutriquest.ui.data.RegisterViewModel
import tp.nutriquest.ui.screens.MainEducationScreenInitialize
import tp.nutriquest.ui.screens.LoginScreenInitialize
import tp.nutriquest.ui.screens.RegisterDataScreenInitialize
import tp.nutriquest.ui.screens.RegisterActivityScreenInitialize
import tp.nutriquest.ui.screens.RegisterAllergyScreenInitialize
import tp.nutriquest.ui.screens.RegisterGoalScreenInitialize
import tp.nutriquest.ui.screens.MainHomeScreenInitialize
import tp.nutriquest.ui.screens.MainStatsScreenInitialize
import tp.nutriquest.ui.screens.MainSettingsScreenInitialize
import tp.nutriquest.ui.theme.NutriquestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            NutriquestTheme {
                val navController = rememberNavController()
                val registerViewModel: RegisterViewModel = viewModel()

                NavHost(navController = navController, startDestination = "login") {

                    composable("login") { LoginScreenInitialize(navController) }

                    composable("register_data") {
                        RegisterDataScreenInitialize(navController, registerViewModel)
                    }
                    composable("register_activity") {
                        RegisterActivityScreenInitialize(navController, registerViewModel)
                    }
                    composable("register_allergy") {
                        RegisterAllergyScreenInitialize(navController, registerViewModel)
                    }
                    composable("register_goal") {
                        RegisterGoalScreenInitialize(navController, registerViewModel)
                    }

                    composable("home") { MainHomeScreenInitialize(navController) }
                    composable("stats") { MainStatsScreenInitialize(navController) }
                    composable("education") { MainEducationScreenInitialize(navController) }
                    composable("settings") { MainSettingsScreenInitialize(navController) }
                }
            }
        }
    }
}

