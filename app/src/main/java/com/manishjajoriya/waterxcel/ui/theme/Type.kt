package com.manishjajoriya.waterxcel.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.manishjajoriya.waterxcel.R

// Define Font Families
val SansSerifFont = FontFamily.Default // Uses system default sans-serif
val SerifFont = FontFamily.Serif // Good for formal/government-related text

// Custom Typography Styles
val Typography = Typography(
    // For headings (Eco-friendly & Government Reports)
    titleLarge = TextStyle(
        fontFamily = SerifFont,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.2.sp
    ),

    // For section titles (Formal yet modern)
    titleMedium = TextStyle(
        fontFamily = SansSerifFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.15.sp
    ),

    // Body text (Readable & professional)
    bodyLarge = TextStyle(
        fontFamily = SansSerifFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    // Labels (Small but clear, useful for coin rewards, badges)
    labelSmall = TextStyle(
        fontFamily = SansSerifFont,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),

    // Button text (Emphasized for CTA like "Earn Coins")
    labelLarge = TextStyle(
        fontFamily = SansSerifFont,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    )
)
