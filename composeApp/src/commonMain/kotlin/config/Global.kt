package config

import base.ScreenCreator
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

object Global {

    const val USING_MATERIAL3 = true
    const val API_URL = ""

    const val DATABASE_SCHEMA = "app.db"
    const val DATA_STORE_SCHEMA = "app.preferences_pb"
}

/**
 * 底部导航栏配置, 枚举名为 RouteName
 */
enum class NavigationScreens(
    val label: String,
    val icon: ImageVector,
    val creator: ScreenCreator,
) {
    Home("Home", Icons.Default.Home, { ui.home.HomeScreen() }),
    Summary("Summary", Icons.Default.Info, { ui.summary.SummaryScreen() }),
    Settings("Settings", Icons.Default.Settings, { ui.settings.SettingsScreen() }),
}