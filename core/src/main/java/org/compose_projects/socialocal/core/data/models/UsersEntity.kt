package org.compose_projects.socialocal.core.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UsersEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "user")
    val user: String,
    @ColumnInfo(name = "password")
    val password: String,
    @ColumnInfo(name = "description")
    val description: String? = null
)
