package com.moise.mobilite.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.moise.mobilite.databinding.FragmentPromotionBinding

class PromotionFragment: Fragment() {
    private var _binding: FragmentPromotionBinding? = null
    private val binding: FragmentPromotionBinding = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPromotionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnApply.setOnClickListener{
            binding.tvCode.text = null
            Toast.makeText(context, "Promo code applied", Toast.LENGTH_SHORT).show()
        }
    }
}