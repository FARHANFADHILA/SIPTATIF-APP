package belajar.p2.siptatif.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import belajar.p2.siptatif.R

// Set of Material typography styles to start with
val opensans = FontFamily(
    Font(R.font.font1)
)
val opesansHebrew = FontFamily(
    Font(R.font.font2)
)
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = opesansHebrew,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
       fontFamily = opesansHebrew,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp
    ),
    titleSmall = TextStyle(
        fontFamily = opesansHebrew,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 30.sp,
        color = BuTTon,

    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
