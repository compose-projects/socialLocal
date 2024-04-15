package org.compose_projects.sl.TextField.config

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp

interface TextFieldSizes {
    val height: Dp
    val width: Dp
    val shape: RoundedCornerShape
    val maxLines: Int
    val maxChar: Int

}