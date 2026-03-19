package com.example.programaandroi.repository

import com.example.programaandroi.model.User

class UserRepository {

    private val users = mutableListOf(
        User(1, "Juan", "juan@test.com", 25),
        User(2, "Maria", "maria@test.com", 30),
        User(3, "Carlos", "carlos@test.com", 28)
    )

    fun getAllUsers(): List<User> = users

    fun addUser(user: User) {
        users.add(user)
    }

    fun deleteUser(id: Int) {
        users.removeAll { it.id == id }
    }
}