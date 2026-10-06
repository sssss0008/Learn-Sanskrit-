package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
  primary = SaffronPrimaryDark,
  onPrimary = SaffronOnPrimaryDark,
  primaryContainer = SaffronPrimaryContainerDark,
  onPrimaryContainer = SaffronOnPrimaryContainerDark,
  secondary = GoldSecondaryDark,
  onSecondary = GoldOnSecondaryDark,
  secondaryContainer = GoldSecondaryContainerDark,
  onSecondaryContainer = GoldOnSecondaryContainerDark,
  tertiary = MaroonTertiaryDark,
  onTertiary = MaroonOnTertiaryDark,
  tertiaryContainer = MaroonTertiaryContainerDark,
  onTertiaryContainer = MaroonOnTertiaryContainerDark,
  background = TempleDarkBackground,
  onBackground = TempleDarkOnBackground,
  surface = TempleDarkSurface,
  onSurface = TempleDarkOnSurface,
  surfaceVariant = TempleDarkSurfaceVariant,
  onSurfaceVariant = TempleDarkOnSurfaceVariant,
)

private val LightColorScheme = lightColorScheme(
  primary = SaffronPrimary,
  onPrimary = SaffronOnPrimary,
  primaryContainer = SaffronPrimaryContainer,
  onPrimaryContainer = SaffronOnPrimaryContainer,
  secondary = GoldSecondary,
  onSecondary = GoldOnSecondary,
  secondaryContainer = GoldSecondaryContainer,
  onSecondaryContainer = GoldOnSecondaryContainer,
  tertiary = MaroonTertiary,
  onTertiary = MaroonOnTertiary,
  tertiaryContainer = MaroonTertiaryContainer,
  onTertiaryContainer = MaroonOnTertiaryContainer,
  background = SandalwoodBackground,
  onBackground = SandalwoodOnBackground,
  surface = SandalwoodSurface,
  onSurface = SandalwoodOnSurface,
  surfaceVariant = SandalwoodSurfaceVariant,
  onSurfaceVariant = SandalwoodOnSurfaceVariant,
)

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicColor: Boolean = false, // Keep warm Vedic aesthetic default
  content: @Composable () -> Unit,
) {
  val colorScheme = when {
    dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
      val context = LocalContext.current
      if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }
    darkTheme -> DarkColorScheme
    else -> LightColorScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    content = content
  )
}
