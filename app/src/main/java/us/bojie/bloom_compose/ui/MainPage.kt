package us.bojie.bloom_compose.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import us.bojie.bloom_compose.R

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun MainPage() {
    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
                .background(MaterialTheme.colors.background)
        ) {
            var showSearchLabel by remember { mutableStateOf(true) }
            val keyboardController = LocalSoftwareKeyboardController.current
            val focusRequester = remember { FocusRequester() }

            OutlinedTextField(
                leadingIcon = {
                    Row(Modifier.padding(start = 20.dp)) {
                        Icon(
                            painterResource(id = R.drawable.ic_search),
                            contentDescription = "Search",
                            Modifier.size(18.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))
                        AnimatedVisibility(
                            visible = showSearchLabel,
                            enter = fadeIn(animationSpec = tween(0)),
                            exit = fadeOut(animationSpec = tween(0))
                        ) {
                            Text(
                                text = "Search",
                                style = MaterialTheme.typography.body1,
                                color = MaterialTheme.colors.onPrimary,
                            )
                        }
                    }
                },
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .onFocusChanged { focusState ->
                        showSearchLabel = (!focusState.isFocused)
                    }
                    .focusRequester(focusRequester),
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                }),
            )
        }
    }
}

@Composable
fun BottomNavigationBar() {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Favorites,
        NavigationItem.Profile,
        NavigationItem.Cart
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = MaterialTheme.colors.onPrimary,
                unselectedContentColor = MaterialTheme.colors.onPrimary.copy(0.4f),
                alwaysShowLabel = true,
                selected = item.isSelected,
                onClick = {
                    /* Add code later */
                }
            )
        }
    }
}

sealed class NavigationItem(
    val route: String,
    val icon: Int,
    val title: String,
    val isSelected: Boolean = false
) {
    object Home : NavigationItem("home", R.drawable.ic_home, "Home", true)
    object Favorites : NavigationItem("favorites", R.drawable.ic_favorite_border, "Favorites")
    object Profile : NavigationItem("profile", R.drawable.ic_account_circle, "Profile")
    object Cart : NavigationItem("cart", R.drawable.ic_shopping_cart, "Cart")
}

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Preview
@Composable
fun MainPagePreview() {
    MainPage()
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar()
}
