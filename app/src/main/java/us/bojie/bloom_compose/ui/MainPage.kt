package us.bojie.bloom_compose.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import us.bojie.bloom_compose.R
import us.bojie.bloom_compose.model.NavigationItem
import us.bojie.bloom_compose.model.RowFlower
import us.bojie.bloom_compose.model.getRowFlowerData

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
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar()
            Spacer(modifier = Modifier.height(24.dp))
            LazyColumn(Modifier.fillMaxSize()) {
                item {
                    Header("Browse themes", Modifier.padding(horizontal = 16.dp))
//                        Icon(
//                            painterResource(id = R.drawable.ic_filter_list),
//                            contentDescription = "Filter",
//                            Modifier.size(24.dp)
//                        )
//                    }
                }
                item { Spacer(modifier = Modifier.height(16.dp)) }

                item {
                    LazyRow(
                        Modifier.padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        val rowFlowerData = getRowFlowerData()

                        items(rowFlowerData.size) { index ->
                            RowFlowerCard(rowFlower = rowFlowerData[index])
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Header(
    title: String,
    modifier: Modifier = Modifier,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    Row(modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onPrimary
        )
        Spacer(modifier = modifier.weight(1f))
        trailingIcon?.invoke()
    }
}

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
private fun SearchBar(modifier: Modifier = Modifier) {
    var showSearchLabel by remember { mutableStateOf(true) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        leadingIcon = {
            Row(modifier.padding(start = 20.dp)) {
                Icon(
                    painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search",
                    Modifier.size(18.dp)
                )

                Spacer(modifier = modifier.width(8.dp))
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
        modifier = modifier
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
            focusManager.clearFocus()
            keyboardController?.hide()
        }),
    )
}

@Composable
fun RowFlowerCard(rowFlower: RowFlower) {
    Card(
        Modifier
            .height(136.dp)
            .width(130.dp)
            .background(MaterialTheme.colors.surface),
        shape = MaterialTheme.shapes.small,
        elevation = 4.dp
    ) {

        Column(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface)
        ) {
            Image(
                painter = painterResource(id = rowFlower.image),
                contentDescription = rowFlower.title,
                Modifier
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.surface)) {
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = rowFlower.title,
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.height(36.dp)
                )
            }
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
