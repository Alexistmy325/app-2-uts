package com.example.programaandroi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.programaandroi.model.User
import com.example.programaandroi.repository.UserRepository

class UserViewModel : ViewModel() {

    private val repository = UserRepository()

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    private val _selectedUser = MutableLiveData<User?>()
    val selectedUser: LiveData<User?> = _selectedUser

    init {
        loadUsers()
    }

    fun loadUsers() {
        _users.value = repository.getAllUsers()
    }

    fun addUser() {
        val newId = (_users.value?.size ?: 0) + 1
        val user = User(newId, "Nuevo $newId", "nuevo$newId@test.com", 20 + newId)
        repository.addUser(user)
        loadUsers()
    }

    fun selectUser(user: User) {
        _selectedUser.value = user
    }
}