package ru.plumsoftware.movie_search.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val appTypography = Typography(
    labelLarge = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.W700,
        fontSize = 26.sp,
        letterSpacing = 0.1.sp
    ),
    headlineLarge = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.W700,
        fontSize = 20.sp,
        letterSpacing = 0.1.sp
    ),
    titleLarge = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.W700,
        fontSize = 16.sp,
        letterSpacing = 0.1.sp
    ),
    titleMedium = TextStyle(
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.W500,
        fontSize = 18.sp,
        letterSpacing = 0.15.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.W400,
        fontStyle = FontStyle.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.05.sp
    )
)