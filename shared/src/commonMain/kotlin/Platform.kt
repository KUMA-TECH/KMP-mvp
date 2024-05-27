/**
 * 各平台系统信息
 * 操作系统
 * 版本
 */
interface Platform {
    val name: String
}

expect fun getPlatform(): Platform