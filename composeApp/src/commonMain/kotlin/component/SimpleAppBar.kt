package component

import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import model.ClickableIcon

/**
 * 通用 appbar
 */
@Composable
fun <T : ClickableIcon> SimpleAppbar(
    title: String,
    menus: List<T>? = null,
    navigateBack: Boolean = true,
) {
    TopAppBar(
        title = { Text(title) },
        modifier = Modifier,
        navigationIcon = {
            if (navigateBack) {
                IconButton({
                    println("TODO go back")
                }) {
                    Icon(Icons.AutoMirrored.Default.ArrowBack, "Go back")
                }
            }
        },
        actions = {
            menus?.map {
                IconButton(onClick = it.onClick) {
                    Icon(it.icon, it.contentDescriptor)
                }
            }
        },
        backgroundColor = MaterialTheme.colorScheme.surface,
        contentColor = contentColorFor(MaterialTheme.colorScheme.surface),
    )
}