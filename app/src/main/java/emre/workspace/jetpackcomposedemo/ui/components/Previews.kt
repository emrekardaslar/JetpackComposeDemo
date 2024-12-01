package emre.workspace.jetpackcomposedemo.ui.components
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import emre.workspace.jetpackcomposedemo.data.model.Message
import emre.workspace.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

@Preview
@Composable
fun PreviewMessageCard() {
    JetpackComposeDemoTheme {
        MessageCard(msg = Message("Lexi", "Check out Jetpack Compose!"))
    }
}

@Preview
@Composable
fun PreviewConversation() {
    JetpackComposeDemoTheme {
        // Sample data for preview
        val messages = listOf(
            Message("Lexi", "Check out Jetpack Compose!"),
            Message("John", "Let's explore more about Compose.")
        )
        // Previewing the Conversation composable
        Conversation(
            messages = messages,
            onMessageClick = { /* No action for preview */ },
            modifier = Modifier.padding(8.dp)
        )
    }
}

