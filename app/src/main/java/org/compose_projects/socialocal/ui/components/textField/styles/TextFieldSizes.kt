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
            override val width: Dp = 250.dp
            override val maxChar: Int = 35
            override val shape: RoundedCornerShape = RoundedCornerShape(8.dp)
        }

}