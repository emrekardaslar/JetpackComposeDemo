package emre.workspace.jetpackcomposedemo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ProfilePicture(
    imageRes: Int,
    contentDescription: String,
    size: Int = 40
) {
    Image(
        painter = painterResource(imageRes),
        contentDescription = contentDescription,
        modifier = Modifier
            .size(size.dp)
            .clip(CircleShape)
            .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
    )
}
