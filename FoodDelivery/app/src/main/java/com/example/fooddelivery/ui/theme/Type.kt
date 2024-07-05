package com.example.fooddelivery.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.R

// Set of Material typography styles to start with
val fonts = FontFamily(
    fonts = listOf(
        Font(R.font.popins_regular, style = FontStyle.Normal),
        Font(R.font.poppins_medium, style = FontStyle.Normal, weight = FontWeight.Medium),
        Font(R.font.poppins_semibold, style = FontStyle.Normal, weight = FontWeight.SemiBold)
    )

)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp

    ),

    bodyMedium = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp

),
    bodySmall = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = 9.sp,
)
)