package com.example.clothesui.ui.theme


import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.clothesui.R


// Set of Material typography styles to start with
//val Typography = Typography(
//    body1 = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp
//    )
//    /* Other default text styles to override
//    button = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.W500,
//        fontSize = 14.sp
//    ),
//    caption = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 12.sp
//    )
//    */
//)

val gothicA1 = FontFamily(
    listOf(
        Font(R.font.gothica1_regular, FontWeight.Normal),
        Font(R.font.gothica1_medium, FontWeight.Medium),
        Font(R.font.gothica1_semibold, FontWeight.SemiBold),
        Font(R.font.gothica1_bold, FontWeight.Bold),
        Font(R.font.gothica1_black, FontWeight.Black),
    )
)
val openSans = FontFamily(
    listOf(
        Font(R.font.open_sans_light,FontWeight.Light),
        Font(R.font.open_sans_regular,FontWeight.Normal),
        Font(R.font.open_sans_medium,FontWeight.Medium),
        Font(R.font.open_sans_semi_bold,FontWeight.SemiBold),
        Font(R.font.open_sans_bold,FontWeight.Bold),
        Font(R.font.open_sans_extra_bold,FontWeight.ExtraBold)
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        color = Color.Black,
        fontFamily = openSans,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    body1 = TextStyle(
        color = Color.Black,
        fontFamily = openSans,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
)