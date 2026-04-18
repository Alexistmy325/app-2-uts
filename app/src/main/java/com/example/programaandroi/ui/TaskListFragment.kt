package com.example.programaandroi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.programaandroi.R
import com.example.programaandroi.repository.TaskRepository

class TaskListFragment : Fragment() {

    private var repo: TaskRepository? = null
    private var listView: ListView? = null
    private var btnAdd: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        listView = view.findViewById(R.id.listView)
        btnAdd = view.findViewById(R.id.btnAdd)

        repo = TaskRepository(requireContext())

        cargarTareas()

        btnAdd?.setOnClickListener {
            findNavController().navigate(R.id.action_list_to_detail)
        }
    }

    override fun onResume() {
        super.onResume()
        cargarTareas()
    }

    private fun cargarTareas() {
        val tasks = repo?.getAllTasks() ?: emptyList()

        val titles: List<String> = tasks.map { it.title }

        val adapter = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_list_item_1,
            titles
        )

        listView?.adapter = adapter
    }
}
