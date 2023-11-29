package ir.divar.androidtask.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = nazaninFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
        textDirection = TextDirection.Rtl,
        textAlign = TextAlign.Start
    ),
    titleMedium = TextStyle(
        fontFamily = nazaninFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.0.sp,
        letterSpacing = 0.2.sp,
        textDirection = TextDirection.Rtl,
        textAlign = TextAlign.Start
    ),
    titleSmall = TextStyle(
        fontFamily = nazaninFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 20.0.sp,
        letterSpacing = 0.1.sp,
        textDirection = TextDirection.Rtl,
        textAlign = TextAlign.Start
    ),
    bodyLarge = TextStyle(
        fontFamily = nazaninFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.0.sp,
        letterSpacing = 0.5.sp,
        textDirection = TextDirection.Rtl,
        textAlign = TextAlign.Start
    ),
    bodyMedium = TextStyle(
        fontFamily = nazaninFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.0.sp,
        letterSpacing = 0.2.sp,
        textDirection = TextDirection.Rtl,
        textAlign = TextAlign.Start
    ),
    bodySmall = TextStyle(
        fontFamily = nazaninFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.0.sp,
        letterSpacing = 0.4.sp,
        textDirection = TextDirection.Rtl,
        textAlign = TextAlign.Start
    ),
    labelLarge = TextStyle(
        fontFamily = nazaninFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.0.sp,
        letterSpacing = 0.1.sp,
        textDirection = TextDirection.Rtl,
        textAlign = TextAlign.Start
    ),
    labelMedium = TextStyle(
        fontFamily = nazaninFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.0.sp,
        letterSpacing = 0.4.sp,
        textDirection = TextDirection.Rtl,
        textAlign = TextAlign.Start
    ),
    labelSmall = TextStyle(
        fontFamily = nazaninFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 16.0.sp,
        letterSpacing = 0.5.sp,
        textDirection = TextDirection.Rtl,
        textAlign = TextAlign.Start
    )
)