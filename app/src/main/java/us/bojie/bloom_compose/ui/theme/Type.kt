package us.bojie.bloom_compose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import us.bojie.bloom_compose.R

private val NunitoSans = FontFamily(
    Font(R.font.nunitosans_bold, FontWeight.Bold),
    Font(R.font.nunitosans_light, FontWeight.Light),
    Font(R.font.nunitosans_semibold, FontWeight.SemiBold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = NunitoSans,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.sp
    ),
    h2 = TextStyle(
        fontFamily = NunitoSans,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 0.15.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = NunitoSans,
        fontSize = 16.sp,
        fontWeight = FontWeight.Light,
        letterSpacing = 0.sp
    ),
    body1 = TextStyle(
        fontFamily = NunitoSans,
        fontSize = 14.sp,
        fontWeight = FontWeight.Light,
        letterSpacing = 0.sp
    ),
    body2 = TextStyle(
        fontFamily = NunitoSans,
        fontSize = 12.sp,
        fontWeight = FontWeight.Light,
        letterSpacing = 0.sp
    ),
    button = TextStyle(
        fontFamily = NunitoSans,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 1.sp
    ),
    caption = TextStyle(
        fontFamily = NunitoSans,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.sp
    )
)
