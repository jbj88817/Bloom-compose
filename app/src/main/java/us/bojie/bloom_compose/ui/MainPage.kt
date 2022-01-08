package us.bojie.bloom_compose.ui

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import us.bojie.bloom_compose.R

@Composable
fun MainPage() {
    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) {

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
                selected = false,
                onClick = {
                    /* Add code later */
                }
            )
        }
    }
}

sealed class NavigationItem(val route: String, val icon: Int, val title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    object Favorites : NavigationItem("favorites", R.drawable.ic_favorite_border, "Favorites")
    object Profile : NavigationItem("profile", R.drawable.ic_account_circle, "Profile")
    object Cart : NavigationItem("cart", R.drawable.ic_shopping_cart, "Cart")
}

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
