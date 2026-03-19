package com.example.programaandroi.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.programaandroi.R
import com.example.programaandroi.databinding.FragmentUserListBinding
import com.example.programaandroi.viewmodel.UserViewModel

class UserListFragment : Fragment(R.layout.fragment_user_list) {

    private var _binding: FragmentUserListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: UserViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUserListBinding.bind(view)

        viewModel.users.observe(viewLifecycleOwner) { users ->
            binding.textView.text = users.joinToString("\n") { user ->
                "${user.name} - ${user.email}"  // String non-null, sin Elvis
            }
        }

        binding.btnAdd.setOnClickListener {
            viewModel.addUser()
        }

        binding.btnGoDetail.setOnClickListener {
            viewModel.users.value?.firstOrNull()?.let { user ->
                viewModel.selectUser(user)
                findNavController().navigate(R.id.action_list_to_detail)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}