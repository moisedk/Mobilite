package com.moise.mobilite.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.moise.mobilite.databinding.FragmentOtpBinding

class OtpFragment: Fragment() {
    private var _binding: FragmentOtpBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnResendOPT.setOnClickListener{
            Toast.makeText(context, "Code has been resent", Toast.LENGTH_SHORT).show()
        }
        binding.btnAccountCreation.setOnClickListener{
            startActivity(Intent(context, HomeMapsActivity::class.java))
        }
    }
}