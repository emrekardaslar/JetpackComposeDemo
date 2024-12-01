package emre.workspace.jetpackcomposedemo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import emre.workspace.jetpackcomposedemo.data.model.Message
import emre.workspace.jetpackcomposedemo.ui.screens.DetailScreen
import emre.workspace.jetpackcomposedemo.ui.screens.HomeScreen
import com.google.gson.Gson

// Navigation route names
sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail/{message}") {
        fun createRoute(messageJson: String) = "detail/$messageJson"
    }
}

@Composable
fun AppNavigation(navController: NavHostController, messages: List<Message>) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        // Home screen
        composable(route = Screen.Home.route) {
            HomeScreen(messages = messages) { message ->
               val messageJson = Gson().toJson(message) // Convert message to JSON string
               navController.navigate(Screen.Detail.createRoute(messageJson))
            }
        }

        // Detail screen
        composable(route = Screen.Detail.route) { backStackEntry ->
            val messageJson = backStackEntry.arguments?.getString("message")
            val message = Gson().fromJson(messageJson, Message::class.java) // Convert JSON string back to Message
            message?.let { DetailScreen(message = it) }
        }
    }
}
