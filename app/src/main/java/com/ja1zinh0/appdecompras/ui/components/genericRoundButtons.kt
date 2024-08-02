package com.ja1zinh0.appdecompras.ui.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ja1zinh0.appdecompras.R

@Composable
fun GenericRoundButton(
    text: String = "",
    backgroundColor: Color = Color.White,
    textColor: Color = Color.Black,
    borderColor: Color = Color.Yellow,
    onClick: () -> Unit = { },
) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(30.dp))
            .border(width = 2.dp, color = borderColor, shape = RoundedCornerShape(30.dp))
            .background(backgroundColor)
            .width(220.dp)
            .height(48.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            style = TextStyle(
                color = textColor,
                fontSize = 30.sp,
            ), text = text
        )
    }
}

@Composable
fun GoogleRoundButton(
    text: String = "",
    backgroundColor: Color = Color.White,
    textColor: Color = Color.Black,
    borderColor: Color = Color.Yellow,
    onClick: () -> Unit = { },
) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(5.dp))
            .border(width = 2.dp, color = borderColor, shape = RoundedCornerShape(5.dp))
            .background(backgroundColor)
            .width(220.dp)
            .height(34.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center,
    ) {
        Row(){
            Image(
                painter = rememberVectorPainter(image = ImageVector.vectorResource(id = R.drawable.google_icon)),
                contentDescription = "https://icons8.com/icon/17949/google",
                modifier = Modifier.size(24.dp) // Ajuste o tamanho do ícone conforme necessário
            )
            Box(modifier = Modifier.width(10.dp)){}
            Text(
                style = TextStyle(
                    color = textColor,
                    fontSize = 18.sp,
                ), text = text
            )
        }
    }
}