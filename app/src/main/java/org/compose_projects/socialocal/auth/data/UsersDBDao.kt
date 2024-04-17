package org.compose_projects.socialocal.auth.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.compose_projects.socialocal.auth.data.model.UsersEntity
import org.compose_projects.socialocal.common.utils.DB_CONSTANTS

@Dao
interface UsersDBDao {
    @Query("SELECT * FROM ${DB_CONSTANTS.tableUsers_name}")
    fun getUsers(): Flow<List<UsersEntity>>

    @Query("SELECT * FROM ${DB_CONSTANTS.tableUsers_name} WHERE id = :id")
    fun getUser(id: Int): Flow<UsersEntity>

    @Query("SELECT * FROM ${DB_CONSTANTS.tableUsers_name} WHERE user = :username")
    fun getPassword(username: String): Flow<UsersEntity>

    @Insert
    suspend fun addUser(user: UsersEntity)

    @Update
    suspend fun updateUser(user: UsersEntity)

    @Delete
    suspend fun deleteUser(user: UsersEntity)

}