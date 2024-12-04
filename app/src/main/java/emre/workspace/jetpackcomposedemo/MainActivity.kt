package emre.workspace.jetpackcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import emre.workspace.jetpackcomposedemo.ui.navigation.AppNavigation
import emre.workspace.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme
import emre.workspace.jetpackcomposedemo.viewmodel.DetailViewModel
import emre.workspace.jetpackcomposedemo.viewmodel.HomeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()

                    // Create ViewModel instances
                    val homeViewModel: HomeViewModel = viewModel()
                    val detailViewModel: DetailViewModel = viewModel()

                    AppNavigation(
                        navController = navController,
                        homeViewModel = homeViewModel,
                        detailViewModel = detailViewModel
                    )
                }
            }
        }
    }
}
