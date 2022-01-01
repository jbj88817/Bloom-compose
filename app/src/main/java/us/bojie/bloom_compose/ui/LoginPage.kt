package us.bojie.bloom_compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import us.bojie.bloom_compose.ui.theme.BloomTheme

@Composable
fun LoginPage() {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Log in with email",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onPrimary
        )
        OutlinedTextField(
            value = "", onValueChange = {},
            label = { Text("Email address", style = MaterialTheme.typography.body1) },
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        OutlinedTextField(
            value = "", onValueChange = {},
            label = { Text("Password (8+ characters)", style = MaterialTheme.typography.body1) },
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "By clicking below, you agree to our Terms of Use and consent to our Privacy Policy",
            style = MaterialTheme.typography.body2,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onPrimary
        )
        Spacer(modifier = Modifier.height(16.dp))
        StyledButton(textContent = "Log in", onClick = { })
    }


}

@Preview
@Composable
fun LoginPagePreview() {
    BloomTheme {
        LoginPage()
    }
}