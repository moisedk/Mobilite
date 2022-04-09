package com.moise.mobilite.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.moise.mobilite.databinding.FragmentAddCardBinding


class AddCardFragment : Fragment() {
    private var _binging: FragmentAddCardBinding? = null
    private val binding get() = _binging!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binging = FragmentAddCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddCard.setOnClickListener{
            Toast.makeText(context, "Card being added...", Toast.LENGTH_SHORT).show()
            clearScreen()
        }

    }

    private fun clearScreen() {
        binding.tvCardFullName.text = null
        binding.edtCardNumber.text = null
        binding.etCardPhone.text = null
        binding.etCardDate.text = null
        binding.etCVC.text = null
        binding.etPIN.text = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binging = null
    }
}