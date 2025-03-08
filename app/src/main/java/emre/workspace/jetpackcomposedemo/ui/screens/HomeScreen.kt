package emre.workspace.jetpackcomposedemo.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import emre.workspace.jetpackcomposedemo.data.model.Message
import emre.workspace.jetpackcomposedemo.ui.components.Conversation

@Composable
fun HomeScreen(
    messages: List<Message>,
    onMessageClick: (Message) -> Unit,
    backgroundColor: String
) {
    Scaffold { padding ->
        androidx.compose.material3.Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(android.graphics.Color.parseColor(backgroundColor))
        ) {
            Conversation(
                messages = messages,
                onMessageClick = onMessageClick,
                modifier = Modifier.padding(padding)
            )
        }
    }
}
