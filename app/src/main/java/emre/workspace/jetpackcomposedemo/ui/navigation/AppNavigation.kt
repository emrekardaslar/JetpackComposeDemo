package emre.workspace.jetpackcomposedemo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import emre.workspace.jetpackcomposedemo.ui.screens.DetailScreen
import emre.workspace.jetpackcomposedemo.ui.screens.HomeScreen
import emre.workspace.jetpackcomposedemo.viewmodel.DetailViewModel
import emre.workspace.jetpackcomposedemo.viewmodel.HomeViewModel

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    homeViewModel: HomeViewModel = viewModel(),
    detailViewModel: DetailViewModel = viewModel()
) {
    // Collect the StateFlow as State for composable usage
    val messages = homeViewModel.messages.collectAsState(initial = emptyList()).value
    val backgroundColor = homeViewModel.backgroundColor.value;
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                messages = messages, // Pass the collected messages
                onMessageClick = { message ->
                    detailViewModel.setSelectedMessage(message)
                    navController.navigate("detail")
                },
                backgroundColor = backgroundColor
            )
        }
        composable("detail") {
            val selectedMessage by detailViewModel.selectedMessage.collectAsState()

            selectedMessage?.let { message ->
                DetailScreen(message = message) // Pass the non-nullable message
            } ?: run {
                // Handle the case where selectedMessage is null (optional)
            }
        }

    }
}
