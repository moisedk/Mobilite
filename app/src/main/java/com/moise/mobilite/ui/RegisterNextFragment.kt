package com.moise.mobilite.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.moise.mobilite.databinding.FragmentRegisterNextBinding

class RegisterNextFragment : Fragment() {
    private var _binding: FragmentRegisterNextBinding? = null
    private val binding get() = _binding !!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterNextBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRegister.setOnClickListener{
            val action = RegisterNextFragmentDirections.actionRegisterNextFragmentToOtpFragment()
            findNavController().navigate(action)
        }

    }
}