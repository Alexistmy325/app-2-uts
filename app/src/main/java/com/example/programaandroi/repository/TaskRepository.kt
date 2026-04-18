package com.example.programaandroidi.repository

import android.content.Context
import com.example.programaandroidi.model.Task
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TaskRepository(context: Context) {

    private val prefs = context.getSharedPreferences("tasks_prefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    private var tasks: MutableList<Task> = loadTasks()

    fun getAllTasks(): List<Task> = tasks

    fun addTask(task: Task) {
        tasks.add(task)
        saveTasks()
    }

    private fun saveTasks() {
        val json = gson.toJson(tasks)
        prefs.edit().putString("tasks", json).apply()
    }

    private fun loadTasks(): MutableList<Task> {
        val json = prefs.getString("tasks", null) ?: return mutableListOf()
        val type = object : TypeToken<List<Task>>() {}.type
        return gson.fromJson(json, type)
    }
}