package org.compose_projects.socialocal.profile.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.compose_projects.socialocal.common.utils.DB_CONSTANTS.tableAccount_name

@Entity(tableName = tableAccount_name)
data class AccountEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "user")
    val user: String,
)
