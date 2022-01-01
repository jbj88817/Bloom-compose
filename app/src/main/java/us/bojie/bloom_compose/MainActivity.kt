package us.bojie.bloom_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import us.bojie.bloom_compose.ui.theme.BloomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BloomTheme {
                WelcomePage()
            }
        }
    }
}

@Composable
fun WelcomePage() {

}


@Preview
@Composable
fun WelcomePagePreview() {
    BloomTheme {
        WelcomePage()
    }
}