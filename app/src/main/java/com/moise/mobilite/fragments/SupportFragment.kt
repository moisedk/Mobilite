package com.moise.mobilite.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moise.mobilite.R
import com.moise.mobilite.databinding.FragmentSupportBinding


class SupportFragment : Fragment() {
    private var _binding: FragmentSupportBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSupportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btSelectOlderRide.setOnClickListener{
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.flContainer, HistoryFragment())
                .addToBackStack("backStack")
                .commit()
        }

        binding.ivOpenUsingBolt.setOnClickListener{
            if(binding.cvUsingBolt.isVisible) {
                binding.cvUsingBolt.isVisible = false
                binding.ivOpenUsingBolt.setImageResource(R.drawable.ic_baseline_arrow_forward_ios_24)
            }
            else {
                binding.cvUsingBolt.isVisible = true
                binding.ivOpenUsingBolt.setImageResource(R.drawable.ic_baseline_arrow_down_24)
            }
        }
        binding.ivOpenAccountData.setOnClickListener{
            if(binding.cvAccountData.isVisible) {
                binding.cvAccountData.isVisible = false
                binding.ivOpenAccountData.setImageResource(R.drawable.ic_baseline_arrow_forward_ios_24)
            }
            else {
                binding.cvAccountData.isVisible = true
                binding.ivOpenAccountData.setImageResource(R.drawable.ic_baseline_arrow_down_24)
            }
        }
        binding.ivOpenPaymentPricing.setOnClickListener{
            if(binding.cvPaymentPricing.isVisible) {
                binding.cvPaymentPricing.isVisible = false
                binding.ivOpenPaymentPricing.setImageResource(R.drawable.ic_baseline_arrow_forward_ios_24)
            }
            else {
                binding.cvPaymentPricing.isVisible = true
                binding.ivOpenPaymentPricing.setImageResource(R.drawable.ic_baseline_arrow_down_24)
            }
        }
        binding.ivOpenAppAndFeatures.setOnClickListener{
            if(binding.cvAppAndFeature.isVisible) {
                binding.cvAppAndFeature.isVisible = false
                binding.ivOpenAppAndFeatures.setImageResource(R.drawable.ic_baseline_arrow_forward_ios_24)
            }
            else {
                binding.cvAppAndFeature.isVisible = true
                binding.ivOpenAppAndFeatures.setImageResource(R.drawable.ic_baseline_arrow_down_24)
            }
        }
        binding.ivOpenAboutBolt.setOnClickListener{
            if(binding.cvAboutBolt.isVisible) {
                binding.cvAboutBolt.isVisible = false
                binding.ivOpenAboutBolt.setImageResource(R.drawable.ic_baseline_arrow_forward_ios_24)
            }
            else {
                binding.cvAboutBolt.isVisible = true
                binding.ivOpenAboutBolt.setImageResource(R.drawable.ic_baseline_arrow_down_24)
            }        }
    }

}