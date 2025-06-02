package tp.nutriquest.ui.components

import androidx.navigation.NavController

data class IconClickActions(
    val onHomeClick: () -> Unit,
    val onStatsClick: () -> Unit,
    val onEducationClick: () -> Unit,
    val onOptionsClick: () -> Unit
)

fun createIconClickActions(navController: NavController): IconClickActions {
    return IconClickActions(
        onHomeClick = { navController.navigate("home") },
        onStatsClick = { navController.navigate("stats") },
        onEducationClick = { navController.navigate("education") },
        onOptionsClick = { navController.navigate("settings") }
    )
}
