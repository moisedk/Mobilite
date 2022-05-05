package com.moise.mobilite.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.moise.mobilite.R
import com.moise.mobilite.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment() {
    private var _binding: FragmentPaymentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddPaymentOption.setOnClickListener{
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.flContainer, AddCardFragment())
                .addToBackStack("backStack")
                .commit()
        }
        binding.btnEnterPromoCode.setOnClickListener{
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.flContainer, PromotionFragment())
                .addToBackStack("backStack")
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}