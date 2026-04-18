package com.example.programaandroi.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.programaandroi.R
import com.example.programaandroi.viewmodel.UserViewModel

class UserDetailFragment : Fragment(R.layout.fragment_task_detail) {

    private val viewModel: UserViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val textDetail = view.findViewById<TextView>(R.id.textDetail)
        val btnBack = view.findViewById<Button>(R.id.btnBack)

        viewModel.selectedUser.observe(viewLifecycleOwner) {
            textDetail.text = it?.name ?: "Sin usuario"
        }

        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}