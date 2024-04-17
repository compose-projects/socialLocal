package org.compose_projects.socialocal.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import org.compose_projects.socialocal.core.data.daos.AccountDBDao
import org.compose_projects.socialocal.core.data.daos.UsersDBDao
import org.compose_projects.socialocal.core.data.models.AccountEntity
import org.compose_projects.socialocal.core.data.models.UsersEntity

@Database(
    entities = [UsersEntity::class, AccountEntity::class],
    version = 1,
    exportSchema = false
)

abstract class SocialLocalDB: RoomDatabase() {
    abstract fun UsersDao(): UsersDBDao
    abstract  fun AccountDao(): AccountDBDao
}