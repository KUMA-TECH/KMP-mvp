package theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable

interface ThemeExt {
    /**
     * custom color scheme for other platforms
     */
    @Composable
    fun CustomColorScheme(
        darkTheme: Boolean,
        dynamicColor: Boolean,
    ): ColorScheme?
}

expect fun getThemeExt(): ThemeExt