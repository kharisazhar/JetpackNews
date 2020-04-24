package com.kharisazhar.jetpacknews

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.surface.Card
import androidx.ui.material.surface.Surface
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview

val mediumGray = Color(0xFFEAEBEC)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    HomePageScreen()
                }
            }
        }
    }
}

@Composable
fun HomePageScreen() {
    VerticalScroller {
        Column(
            crossAxisSize = LayoutSize.Expand,
            modifier = Spacing(24.dp)
        ) {
            SettingsRow()
            NewsLetterRow()
        }
    }
}

@Composable
fun JetpackNewsTitle(title: String) {
    Text(
        text = title,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        ),
        modifier = Spacing(0.dp, 0.dp, 0.dp, 8.dp)
    )
}

@Composable
fun JetpackNewsButton(title: String){
    Button(
        text = title,
        onClick = {

        },
        style = ContainedButtonStyle(
            color = mediumGray,
            shape = RoundedCornerShape(8.dp)
        )
    )
}

@Composable
fun SettingsRow() {
    val settingsBannerImage = +imageResource(R.drawable.ic_banner1)

    /// JetpackNewsTitle : Your Custom Widget
    JetpackNewsTitle(title = "Settings")

    Row(
        mainAxisAlignment = MainAxisAlignment.SpaceBetween,
        mainAxisSize = LayoutSize.Expand,
        crossAxisAlignment = CrossAxisAlignment.Center
    ) {
        Text(text = "You are not a subscriber", style = +themeTextStyle { body2 })

        /// JetpackNewsButton : Your Custom Widget
        JetpackNewsButton(title = "See options")
    }

    Container(expanded = true, height = 180.dp, modifier = Spacing(0.dp, 24.dp, 0.dp, 24.dp)) {
        Clip(shape = RoundedCornerShape(8.dp)) {
            DrawImage(image = settingsBannerImage)
        }
    }
}

@Composable
fun NewsLetterRow() {
    Row(
        mainAxisAlignment = MainAxisAlignment.SpaceBetween,
        mainAxisSize = LayoutSize.Expand,
        crossAxisAlignment = CrossAxisAlignment.Center,
        modifier = Spacing(0.dp, 0.dp, 0.dp, 16.dp)
    ) {
        JetpackNewsTitle(title = "My Newsletter")
        JetpackNewsButton(title = "Show catalogue")
    }
    Column {
        JetpackNewsCardLetter(
            title = "Breaking News Alerts",
            description = "Stay informed as soon as important news breaks arround the world."
        )
        JetpackNewsCardLetter(
            title = "Jetpack News",
            description = "Jetpack Compose is a modern toolkit for building native Android UI."
        )
        JetpackNewsCardLetter(
            title = "Composable functions",
            description = "Jetpack Compose is built around composable functions."
        )
    }
}

@Composable
fun JetpackNewsCardLetter(title: String, description: String) {
    Padding(0.dp, 0.dp, 0.dp, 16.dp) {
        Card(
            shape = RoundedCornerShape(4.dp),
            elevation = 1.2.dp
        ) {
            Padding(padding = 16.dp) {
                Column {
                    Row(
                        mainAxisAlignment = MainAxisAlignment.SpaceBetween,
                        mainAxisSize = LayoutSize.Expand,
                        crossAxisAlignment = CrossAxisAlignment.Center,
                        modifier = Spacing(0.dp, 0.dp, 0.dp, 12.dp)
                    ) {
                        Text(
                            text = title,
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        )
                    }
                    Text(
                        text = description,
                        style = +themeTextStyle { body1 })
                }
            }
        }
    }
}

@Composable
fun VectorImage(@DrawableRes id: Int, tint: Color = Color.Transparent) {
    val vector = +vectorResource(id)
    WithDensity {
        Container(
            width = vector.defaultWidth.toDp(),
            height = vector.defaultHeight.toDp()
        ) {
            DrawVector(vector, tint)
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        Surface {
            HomePageScreen()
        }
    }
}
