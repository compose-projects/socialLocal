package org.compose_projects.socialocal.auth.common.data

import androidx.room.Database
import androidx.room.RoomDatabase
import org.compose_projects.socialocal.auth.common.data.entities.AccountEntity
import org.compose_projects.socialocal.auth.data.UsersDBDao
import org.compose_projects.socialocal.auth.data.model.UsersEntity

@Database(
    entities = [UsersEntity::class, AccountEntity::class],
    version = 1,
    exportSchema = false
)

abstract class SocialLocalDB: RoomDatabase() {
    abstract fun UsersDao(): UsersDBDao
    abstract  fun AccountDao(): AccountDBDao
}