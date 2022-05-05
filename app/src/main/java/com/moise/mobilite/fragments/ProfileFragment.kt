package com.moise.mobilite.fragments

import android.R
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.moise.mobilite.activities.MainActivity
import com.moise.mobilite.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivEditProfile2.setOnClickListener{
            Toast.makeText(requireContext(), "Will edit your profile", Toast.LENGTH_SHORT).show()
        }
        binding.tvLogout.setOnClickListener{
            AlertDialog.Builder(requireContext())
                .setTitle("Confirm Logout")
                .setMessage("Do you really want log out?")
                .setIcon(R.drawable.ic_dialog_alert)
                .setPositiveButton(
                    R.string.yes
                ) { _, _ ->
                    startActivity(Intent(requireContext(), MainActivity::class.java))
                    requireActivity().finish()
                    Toast.makeText(
                        requireContext(),
                        "Logged out",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .setNegativeButton(R.string.no, null)
                .show()
        }
        binding.tvDeleteAccount.setOnClickListener{
            Toast.makeText(requireContext(), "We need to confirm a few things", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}