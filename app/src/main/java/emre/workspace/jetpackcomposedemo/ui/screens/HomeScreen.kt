package emre.workspace.jetpackcomposedemo.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import emre.workspace.jetpackcomposedemo.data.model.Message
import emre.workspace.jetpackcomposedemo.ui.components.Conversation

@Composable
fun HomeScreen(
    messages: List<Message>,
    onMessageClick: (Message) -> Unit // Callback for navigating to the detail screen
) {
    Scaffold { padding ->
        // Use Conversation instead of LazyColumn
        Conversation(
            messages = messages,
            onMessageClick = onMessageClick,
            modifier = Modifier.padding(padding)
        )
    }
}
