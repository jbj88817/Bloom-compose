package us.bojie.bloom_compose.model

import androidx.annotation.DrawableRes
import us.bojie.bloom_compose.R

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

data class RowFlower(@DrawableRes val image: Int, val title: String)

fun getRowFlowerData() = listOf(
    RowFlower(R.drawable.desert_chic, "Desert chic"),
    RowFlower(R.drawable.tiny_terrariums, "Tiny terrariums"),
    RowFlower(R.drawable.jungle_vibes, "Jungle vibes"),
    RowFlower(R.drawable.easy_care, "Easy care"),
    RowFlower(R.drawable.statements, "Statements"),
)
