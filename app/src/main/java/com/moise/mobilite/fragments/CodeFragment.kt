package com.moise.mobilite.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.moise.mobilite.databinding.FragmentCodeBinding

class CodeFragment: Fragment() {
    private var _binding: FragmentCodeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCodeBinding.inflate(inflater, container, false)
       return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnShareCode.setOnClickListener{
//            TODO Create an implicit intent an launch an activity for sharing
            Toast.makeText(context, "Code shared", Toast.LENGTH_SHORT).show()
        }
        binding.tvCode.setOnClickListener{
            Toast.makeText(context, "Code copied to clipboard", Toast.LENGTH_SHORT).show()
        }
    }
}