package org.compose_projects.socialocal.common.domain.model

import org.compose_projects.socialocal.core.model.IpDevice

data class Chat (
    val image: Int,
    val name: String,
    val ipDevice: IpDevice
)