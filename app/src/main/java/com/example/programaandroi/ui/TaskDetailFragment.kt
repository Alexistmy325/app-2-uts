package com.example.programaandroidi.ui

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.programaandroidi.R
import com.example.programaandroidi.TaskReminderReceiver
import com.example.programaandroidi.model.Task
import com.example.programaandroidi.repository.TaskRepository

class TaskDetailFragment : Fragment() {

    private lateinit var repo: TaskRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_task_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val title = view.findViewById<EditText>(R.id.etTitle)
        val desc = view.findViewById<EditText>(R.id.etDesc)
        val check = view.findViewById<CheckBox>(R.id.cbReminder)
        val btnSave = view.findViewById<Button>(R.id.btnSave)

        repo = TaskRepository(requireContext())

        btnSave.setOnClickListener {

            val task = Task(
                id = System.currentTimeMillis().toInt(),
                title = title.text.toString(),
                description = desc.text.toString(),
                hasReminder = check.isChecked
            )

            repo.addTask(task)

            if (check.isChecked) {
                programReminder()
            }

            findNavController().navigateUp()
        }
    }

    private fun programReminder() {
        val intent = Intent(requireContext(), TaskReminderReceiver::class.java)

        val pendingIntent = PendingIntent.getBroadcast(
            requireContext(),
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val alarmManager = requireContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager

        alarmManager.set(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis() + 30000,
            pendingIntent
        )
    }
}