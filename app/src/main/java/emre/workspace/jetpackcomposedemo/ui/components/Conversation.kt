package emre.workspace.jetpackcomposedemo.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import emre.workspace.jetpackcomposedemo.data.model.Message

@Composable
fun Conversation(
    messages: List<Message>,
    onMessageClick: (Message) -> Unit,
    modifier: Modifier = Modifier // Accepting modifier to allow customization
) {
    LazyColumn(modifier = modifier) {
        items(messages) { message ->
            MessageCard(
                msg = message,
                modifier = Modifier.clickable { onMessageClick(message) }
            )
        }
    }
}
