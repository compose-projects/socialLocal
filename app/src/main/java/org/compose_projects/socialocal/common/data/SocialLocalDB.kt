package org.compose_projects.socialocal.common.data

import androidx.room.Database
import androidx.room.RoomDatabase
import org.compose_projects.socialocal.auth.data.UsersDBDao
import org.compose_projects.socialocal.auth.data.model.Users
import org.compose_projects.socialocal.profile.data.AccountDBDao
import org.compose_projects.socialocal.profile.domain.models.Account

@Database(
    entities = [Users::class, Account::class],
    version = 1,
    exportSchema = false
)

abstract class SocialLocalDB: RoomDatabase() {
    abstract fun UsersDao(): UsersDBDao
    abstract  fun AccountDao(): AccountDBDao
}