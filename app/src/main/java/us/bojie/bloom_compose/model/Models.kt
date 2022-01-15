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

data class Flower(@DrawableRes val image: Int, val title: String, val isChecked: Boolean = false)

fun getRowFlowerData() = listOf(
    Flower(R.drawable.desert_chic, "Desert chic"),
    Flower(R.drawable.tiny_terrariums, "Tiny terrariums"),
    Flower(R.drawable.jungle_vibes, "Jungle vibes"),
    Flower(R.drawable.easy_care, "Easy care"),
    Flower(R.drawable.statements, "Statements"),
)

fun getColumnFlowerData() = listOf(
    Flower(R.drawable.monstera, "Monstera", true),
    Flower(R.drawable.aglaonema, "Aglaonema"),
    Flower(R.drawable.peace_lily, "Peace Lily"),
    Flower(R.drawable.fiddle_leaf_tree, "Fiddle leaf tree"),
    Flower(R.drawable.snake_plant, "Snake plant"),
    Flower(R.drawable.pothos, "Pothos")
)
