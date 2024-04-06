package org.compose_projects.socialocal.profile.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.compose_projects.socialocal.profile.domain.models.Account

@Dao
interface AccountDBDao {
    @Query("SELECT * FROM account")
    fun getUser(): Flow<List<Account>>

    @Query("SELECT * FROM account WHERE id = :id")
    fun getUser(id: Int): Flow<Account>

    @Insert
    suspend fun addUser(user: Account)

    @Update
    suspend fun updateUser(user: Account)

    @Delete
    suspend fun deleteUser(user: Account)

}