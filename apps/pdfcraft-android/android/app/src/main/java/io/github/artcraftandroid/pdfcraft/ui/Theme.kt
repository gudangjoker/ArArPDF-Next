package io.github.artcraftandroid.pdfcraft.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.github.artcraftandroid.pdfcraft.R

/** Inter (OFL, assets/fonts), PdfCraft's UI face, copied in by the build. */
val Inter = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
)

/** The colours the screens use beyond Material's roles (measured from the reference app's screens). */
@Immutable
data class PdfColors(
    val dark: Boolean,
    /** The app's surfaces: screens, bars and sheets. */
    val surface: Color,
    /** Slightly raised: cards, the search field, selected rows. */
    val surfaceRaised: Color,
    /** A pressed or selected control's background (the active tool, an open picker's button). */
    val pressed: Color,
    /** The viewer's desk around and between the pages. */
    val desk: Color,
    val pageEdge: Color,
    val text: Color,
    val textSecondary: Color,
    /** Dates and other quiet text (the comment list's dates). */
    val textTertiary: Color,
    /** Bar and sheet icons. */
    val icon: Color,
    val divider: Color,
    /** A sheet's drag handle. */
    val handle: Color,
    /** Selection, the active tool, checked rows. */
    val accent: Color,
    val onAccent: Color,
    /** Filled buttons (primary actions). */
    val button: Color,
    /** The PDF badge and destructive actions. */
    val red: Color,
    val scrim: Color,
    /** Hint toasts over the page. */
    val toast: Color,
    val onToast: Color,
    /** Labels of the viewer's bars (the reference's primary label colour). */
    val label: Color,
    /** The corner triangle of a tool with sub-tools (the same in both themes). */
    val cornerMark: Color = Color(0xFF4B4B4B),
    /** The active tool's icon and the Done check (the reference's darker blue on its bars). */
    val toolAccent: Color,
    /** The comment panel's "N of M" and its reply box's outline and hint. */
    val navigatorText: Color,
    val replyBorder: Color,
    /** Home, Files, Tools and Search: the reference's home background. */
    val home: Color,
    /** The card behind each page of Pages. */
    val pageCard: Color,
    /** Pop-up menus over the page (the text selection's). */
    val menu: Color,
    /** The band behind the navigation buttons in the viewer and its screens and sheets. */
    val navBand: Color,
    /** The Read aloud switch's track, off and on. */
    val switchOff: Color,
    val switchOn: Color,
)

val LightPdfColors = PdfColors(
    dark = false,
    surface = Color(0xFFFFFFFF),
    surfaceRaised = Color(0xFFEEF3FA),
    pressed = Color(0xFFDFEAFA),
    desk = Color(0xFFE6ECF5),
    pageEdge = Color(0x1F0F172A),
    text = Color(0xFF0F172A),
    textSecondary = Color(0xFF475569),
    textTertiary = Color(0xFF64748B),
    icon = Color(0xFF1E293B),
    divider = Color(0xFFDCE5F2),
    handle = Color(0xFF94A3B8),
    accent = Color(0xFF0062FF),
    onAccent = Color(0xFFFFFFFF),
    button = Color(0xFF0055F0),
    red = Color(0xFFE51919),
    scrim = Color(0x660B1120),
    toast = Color(0xFF1E293B),
    onToast = Color(0xFFFFFFFF),
    label = Color(0xFF0F172A),
    toolAccent = Color(0xFF0055F0),
    navBand = Color(0xFFFFFFFF),
    menu = Color(0xFFFFFFFF),
    pageCard = Color(0xFFE2E8F0),
    home = Color(0xFFF7F9FC),
    navigatorText = Color(0xFF1E293B),
    replyBorder = Color(0xFF64748B),
    switchOff = Color(0xFFCBD5E1),
    switchOn = Color(0xFF0062FF),
)

val DarkPdfColors = PdfColors(
    dark = true,
    surface = Color(0xFF131C2E),
    surfaceRaised = Color(0xFF1C2840),
    pressed = Color(0xFF253554),
    desk = Color(0xFF060A14),
    pageEdge = Color(0x1AFFFFFF),
    text = Color(0xFFF1F5F9),
    textSecondary = Color(0xFF94A3B8),
    textTertiary = Color(0xFF7B8FA8),
    icon = Color(0xFFE2E8F0),
    divider = Color(0xFF283754),
    handle = Color(0xFF64748B),
    accent = Color(0xFF4DA3FF),
    onAccent = Color(0xFF061224),
    button = Color(0xFF0062FF),
    red = Color(0xFFFF4D54),
    scrim = Color(0x99020617),
    toast = Color(0xFF1E293B),
    onToast = Color(0xFFF8FAFC),
    label = Color(0xFFF8FAFC),
    toolAccent = Color(0xFF4DA3FF),
    navBand = Color(0xFF0B1120),
    menu = Color(0xFF131C2E),
    pageCard = Color(0xFF1E293B),
    home = Color(0xFF0B1120),
    navigatorText = Color(0xFFE2E8F0),
    replyBorder = Color(0xFF64748B),
    switchOff = Color(0xFF334155),
    switchOn = Color(0xFF4DA3FF),
)

/**
 * E-ink mode's colours (#13): white, black text and icons, black for what's selected, black
 * edges around the pages on a white desk, one grey for what's pressed, and no dimming behind
 * sheets and dialogs. E-paper shows these without the ghosting greys and tints leave.
 */
val EInkPdfColors = LightPdfColors.copy(
    surfaceRaised = Color(0xFFFFFFFF),
    pressed = Color(0xFFD0D0D0),
    desk = Color(0xFFFFFFFF),
    pageEdge = Color(0xFF000000),
    text = Color(0xFF000000),
    textSecondary = Color(0xFF000000),
    textTertiary = Color(0xFF000000),
    icon = Color(0xFF000000),
    divider = Color(0xFF000000),
    handle = Color(0xFF000000),
    accent = Color(0xFF000000),
    onAccent = Color(0xFFFFFFFF),
    button = Color(0xFF000000),
    red = Color(0xFF000000),
    scrim = Color(0x00000000),
    toast = Color(0xFF000000),
    onToast = Color(0xFFFFFFFF),
    label = Color(0xFF000000),
    cornerMark = Color(0xFF000000),
    toolAccent = Color(0xFF000000),
    navBand = Color(0xFFFFFFFF),
    menu = Color(0xFFFFFFFF),
    pageCard = Color(0xFFFFFFFF),
    home = Color(0xFFFFFFFF),
    navigatorText = Color(0xFF000000),
    replyBorder = Color(0xFF000000),
    switchOff = Color(0xFFD0D0D0),
    switchOn = Color(0xFF000000),
)

val LocalPdfColors = staticCompositionLocalOf { LightPdfColors }

/** The colours in effect. */
val pdfColors: PdfColors @Composable get() = LocalPdfColors.current

/** How the app chooses light or dark (Preferences ▸ Theme). */
enum class ThemeChoice { System, Light, Dark }

/** The app's look: light or dark as [choice] says, or E-ink mode's black and white ([eInk]). */
@Composable
fun PdfcraftTheme(choice: ThemeChoice = ThemeChoice.System, eInk: Boolean = false, content: @Composable () -> Unit) {
    val dark = !eInk && when (choice) {
        ThemeChoice.System -> isSystemInDarkTheme()
        ThemeChoice.Light -> false
        ThemeChoice.Dark -> true
    }
    val c = when {
        eInk -> EInkPdfColors
        dark -> DarkPdfColors
        else -> LightPdfColors
    }
    val scheme: ColorScheme = if (dark) {
        darkColorScheme(primary = c.accent, onPrimary = c.onAccent, surface = c.surface, onSurface = c.text, background = c.surface, onBackground = c.text,
            surfaceVariant = c.surfaceRaised, onSurfaceVariant = c.textSecondary, outline = c.divider, error = c.red, surfaceContainer = c.surfaceRaised,
            surfaceContainerHigh = c.surfaceRaised, surfaceContainerHighest = c.surfaceRaised, surfaceContainerLow = c.surface)
    } else {
        lightColorScheme(primary = c.accent, onPrimary = c.onAccent, surface = c.surface, onSurface = c.text, background = c.surface, onBackground = c.text,
            surfaceVariant = c.surfaceRaised, onSurfaceVariant = c.textSecondary, outline = c.divider, error = c.red, surfaceContainer = c.surface,
            surfaceContainerHigh = c.surface, surfaceContainerHighest = c.surfaceRaised, surfaceContainerLow = c.surface)
    }
    val base = Typography()
    val typography = Typography(
        displayLarge = base.displayLarge.copy(fontFamily = Inter),
        headlineMedium = base.headlineMedium.copy(fontFamily = Inter),
        headlineSmall = base.headlineSmall.copy(fontFamily = Inter),
        titleLarge = TextStyle(fontFamily = Inter, fontWeight = FontWeight.SemiBold, fontSize = 20.sp, lineHeight = 26.sp),
        titleMedium = TextStyle(fontFamily = Inter, fontWeight = FontWeight.SemiBold, fontSize = 16.sp, lineHeight = 22.sp),
        titleSmall = TextStyle(fontFamily = Inter, fontWeight = FontWeight.Medium, fontSize = 14.sp, lineHeight = 20.sp),
        bodyLarge = TextStyle(fontFamily = Inter, fontSize = 16.sp, lineHeight = 22.sp),
        bodyMedium = TextStyle(fontFamily = Inter, fontSize = 14.sp, lineHeight = 20.sp),
        bodySmall = TextStyle(fontFamily = Inter, fontSize = 12.sp, lineHeight = 16.sp),
        labelLarge = TextStyle(fontFamily = Inter, fontWeight = FontWeight.Medium, fontSize = 14.sp, lineHeight = 20.sp),
        labelMedium = TextStyle(fontFamily = Inter, fontWeight = FontWeight.Medium, fontSize = 12.sp, lineHeight = 16.sp),
        labelSmall = TextStyle(fontFamily = Inter, fontWeight = FontWeight.Medium, fontSize = 11.sp, lineHeight = 14.sp),
    )
    CompositionLocalProvider(LocalPdfColors provides c) {
        MaterialTheme(colorScheme = scheme, typography = typography, content = content)
    }
}
