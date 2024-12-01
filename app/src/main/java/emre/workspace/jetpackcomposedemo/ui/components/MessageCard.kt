package emre.workspace.jetpackcomposedemo.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import emre.workspace.jetpackcomposedemo.R
import emre.workspace.jetpackcomposedemo.data.model.Message

@Composable
fun MessageCard(
    msg: Message,
    modifier: Modifier = Modifier // Added Modifier parameter
) {
    Row(
        modifier = modifier
            .padding(all = 8.dp)
    ) {
        // Profile Picture
        ProfilePicture(
            imageRes = R.drawable.ppgithub,
            contentDescription = "${msg.author}'s profile picture"
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Track expansion state
        var isExpanded by remember { mutableStateOf(false) }

        // Animated background color
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
        )

        // Message content
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
