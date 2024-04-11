package org.compose_projects.socialocal.ui.components.textField.styles

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.compose_projects.socialocal.ui.components.textField.config.TextFieldSizes

object TextFieldSizes {

    val defaultSize: TextFieldSizes
        get() = object : TextFieldSizes{
            override val maxLines: Int = 1
            override val height: Dp = 56.dp
            override val width: Dp = 260.dp
            override val maxChar: Int = 28
            override val shape: RoundedCornerShape = RoundedCornerShape(25.dp)
        }
    val descriptionSize: TextFieldSizes
        get() = object : TextFieldSizes{
            override val maxLines: Int = 5
            override val height: Dp = 150.dp
            override val width: Dp = 250.dp
            override val maxChar: Int = 150
            override val shape: RoundedCornerShape = RoundedCornerShape(10.dp)
        }

}