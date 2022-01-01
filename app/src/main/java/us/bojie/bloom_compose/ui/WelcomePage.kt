package us.bojie.bloom_compose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import us.bojie.bloom_compose.R
import us.bojie.bloom_compose.ui.theme.BloomTheme
import us.bojie.bloom_compose.ui.theme.Gray
import us.bojie.bloom_compose.ui.theme.Green300
import us.bojie.bloom_compose.ui.theme.Pink900

@Composable
fun WelcomePage() {
    val darkTheme = isSystemInDarkTheme()
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ) {
        Image(
            painter = painterResource(id = if (darkTheme) R.drawable.ic_dark_welcome_bg else R.drawable.ic_light_welcome_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        Image(
            painter = painterResource(id = if (darkTheme) R.drawable.ic_dark_welcome_illos else R.drawable.ic_light_welcome_illos),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(
                    top = this.maxHeight.times(0.15f),
                )
                .offset((36).dp, 0.dp),
            contentDescription = null
        )

        Column(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp)
        ) {
            Image(
                painter = painterResource(id = if (darkTheme) R.drawable.ic_dark_logo else R.drawable.ic_light_logo),
                contentDescription = null,
                Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Beautiful home garden solutions",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = if (darkTheme) Color.White else Gray
            )
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = {}, shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (darkTheme) Green300 else Gray,
                    contentColor = MaterialTheme.colors.background
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                Text(text = "Create account", Modifier.padding(top = 8.dp, bottom = 8.dp))
            }
            Spacer(modifier = Modifier.height(24.dp))
            TextButton(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = if (darkTheme) Color.White else Pink900,
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Log in")
            }

            Spacer(modifier = Modifier.height(36.dp))
        }

    }
}


@Preview
@Composable
fun WelcomePagePreview() {
    BloomTheme {
        WelcomePage()
    }
}
