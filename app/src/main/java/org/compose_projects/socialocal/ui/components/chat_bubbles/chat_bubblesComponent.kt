package org.compose_projects.socialocal.ui.components.chat_bubbles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import md_theme_dark_onPrimary
import md_theme_dark_onPrimaryContainer
import md_theme_dark_primary

@Composable
fun SLChatBubbles(message: String, left: Boolean) {

    if (left) {
        Row(Modifier.height(IntrinsicSize.Max)) {
            // Columna para el triángulo
            Column(
                modifier = Modifier
                    .background(
                        color = md_theme_dark_onPrimary.copy(alpha = 0.7F),
                        shape = TriangleEdgeShape(offset = 15, left = left)
                    )
                    .width(8.dp)
                    .fillMaxHeight()
            ) {
            }

            // Columna para el mensaje
            Column(
                modifier = Modifier
                    .background(
                        color = md_theme_dark_onPrimary.copy(alpha = 0.7F),
                        shape = RoundedCornerShape(
                            4.dp,
                            4.dp,
                            4.dp,
                            0.dp
                        )
                    )
            ) {
                Text(
                    message,
                    color = md_theme_dark_primary,
                    modifier = Modifier.padding(5.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    } else {
        Row(Modifier.height(IntrinsicSize.Max)) {
            Column(
                modifier = Modifier.background(
                    color = md_theme_dark_primary.copy(alpha = 0.7F),
                    shape = RoundedCornerShape(4.dp, 4.dp, 0.dp, 4.dp)
                )
            ) {
                Text(
                    message,
                    color = Color.White.copy(0.85F),
                    modifier = Modifier.padding(5.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Column(
                modifier = Modifier
                    .background(
                        color = md_theme_dark_primary.copy(alpha = 0.7F),
                        shape = TriangleEdgeShape(15, left = left)
                    )
                    .width(8.dp)
                    .fillMaxHeight()
            ) {

            }
        }
    }
}


class TriangleEdgeShape(private val offset: Int, private val left: Boolean) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        if (left) {
            val trianglePath = Path().apply {
                // Empieza en la esquina inferior derecha
                moveTo(x = size.width, y = size.height)
                // Línea hacia arriba en el mismo eje x
                lineTo(x = size.width, y = size.height - this@TriangleEdgeShape.offset)
                // Línea diagonal hacia la esquina inferior izquierda
                lineTo(x = size.width - this@TriangleEdgeShape.offset, y = size.height)
                // Cierra el path volviendo al inicio
                close()
            }
            return Outline.Generic(path = trianglePath)
        } else {
            val trianglePath = Path().apply {
                moveTo(x = 0f, y = size.height - offset)
                lineTo(x = 0f, y = size.height)
                lineTo(x = 0f + offset, y = size.height)
            }
            return Outline.Generic(path = trianglePath)
        }
    }
}


