package us.bojie.bloom_compose.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import us.bojie.bloom_compose.ui.theme.Gray
import us.bojie.bloom_compose.ui.theme.Green300

@Composable
fun StyledButton(
    textContent: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    darkTheme: Boolean = isSystemInDarkTheme()
) {
    Button(
        onClick = onClick, shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (darkTheme) Green300 else Gray,
            contentColor = MaterialTheme.colors.background
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(text = textContent, Modifier.padding(top = 8.dp, bottom = 8.dp))
    }
}