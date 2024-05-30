package component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.SnackbarHost
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.ClickableIcon
import model.MenuModel
import theme.AppTheme

@Composable
fun AppLauncher(
    usingMaterial3: Boolean = false,
    darkTheme: Boolean = isSystemInDarkTheme(),
    title: String,
    fab: ClickableIcon?,
    bottomBar: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    if (usingMaterial3)
        AppTheme(darkTheme, true) {
            Scaffold(
                modifier = Modifier.padding(0.dp),
                topBar = { SimpleAppbar<MenuModel>(title, navigateBack = false) },
                bottomBar = bottomBar,
                snackbarHost = { },
                floatingActionButton = {
                    fab?.let {
                        FloatingActionButton(
                            onClick = it.onClick,
                            backgroundColor = MaterialTheme.colorScheme.secondary,
                            contentColor = contentColorFor(MaterialTheme.colorScheme.secondary),
                        ) { Icon(it.icon, it.contentDescriptor) }
                    }
                },
                floatingActionButtonPosition = FabPosition.End,
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = contentColorFor(MaterialTheme.colorScheme.background),
                contentWindowInsets = ScaffoldDefaults.contentWindowInsets,
            ) {
                content(it)
            }
        }
    else Material2Theme(
        MaterialTheme.colorScheme,
        MaterialTheme.shapes,
        MaterialTheme.typography,
        content
    )
}

@Composable
fun Material2Theme(
    colorScheme: ColorScheme = MaterialTheme.colorScheme,
    shapes: Shapes = MaterialTheme.shapes,
    typography: Typography = MaterialTheme.typography,
    content: @Composable (PaddingValues) -> Unit
) {
    androidx.compose.material.MaterialTheme(
        androidx.compose.material.MaterialTheme.colors.copy(
            primary = colorScheme.primary,
            primaryVariant = colorScheme.surfaceVariant,
            secondary = colorScheme.secondary,
            secondaryVariant = colorScheme.surfaceContainerHighest,
            background = colorScheme.background,
            surface = colorScheme.surface,
            error = colorScheme.error,
            onPrimary = colorScheme.onPrimary,
            onSecondary = colorScheme.onSecondary,
            onBackground = colorScheme.onBackground,
            onSurface = colorScheme.onSurface,
            onError = colorScheme.onError,
            isLight = !isSystemInDarkTheme()
        ),
        androidx.compose.material.MaterialTheme.typography.copy(
            h1 = typography.displayLarge,
            h2 = typography.displayMedium,
            h3 = typography.displaySmall,
            h4 = typography.headlineLarge,
            h5 = typography.headlineMedium,
            h6 = typography.headlineSmall,
            subtitle1 = typography.titleMedium,
            subtitle2 = typography.titleSmall,
            body1 = typography.bodyMedium,
            body2 = typography.bodySmall,
            button = typography.labelMedium,
            caption = typography.labelSmall,
            overline = typography.labelSmall
        ),
        androidx.compose.material.MaterialTheme.shapes.copy(
            small = shapes.small,
            medium = shapes.medium,
            large = shapes.large
        )
    ) {
        androidx.compose.material.Scaffold(
            contentWindowInsets = WindowInsets.safeContent,
            modifier = Modifier.padding(0.dp),
            scaffoldState = rememberScaffoldState(),
            topBar = {},
            bottomBar = {},
            snackbarHost = { SnackbarHost(it) },
            floatingActionButton = {},
            floatingActionButtonPosition = androidx.compose.material.FabPosition.End,
            isFloatingActionButtonDocked = false,
            drawerContent = null,
            drawerGesturesEnabled = true,
            drawerShape = androidx.compose.material.MaterialTheme.shapes.large,
            drawerElevation = androidx.compose.material.DrawerDefaults.Elevation,
            drawerBackgroundColor = androidx.compose.material.MaterialTheme.colors.surface,
            drawerContentColor = contentColorFor(androidx.compose.material.MaterialTheme.colors.surface),
            drawerScrimColor = androidx.compose.material.DrawerDefaults.scrimColor,
            backgroundColor = androidx.compose.material.MaterialTheme.colors.background,
            contentColor = contentColorFor(androidx.compose.material.MaterialTheme.colors.background),
        ) {
            content(it)
        }
    }
}