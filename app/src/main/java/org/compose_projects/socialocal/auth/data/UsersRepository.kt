package org.compose_projects.socialocal.auth.data

import kotlinx.coroutines.flow.Flow
import org.compose_projects.socialocal.auth.data.model.Users
import javax.inject.Inject

class UsersRepository @Inject  constructor(
    private val userDao: UsersDBDao
){
    fun getAllUsers(): Flow<List<Users>> =
         userDao.getUsers()

}