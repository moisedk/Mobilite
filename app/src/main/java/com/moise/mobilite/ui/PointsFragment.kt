package com.moise.mobilite.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.moise.mobilite.R
import com.moise.mobilite.databinding.FragmentPointsBinding

class PointsFragment: Fragment() {
    private var totalPoints = 100
    private var _binding: FragmentPointsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPointsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRedeem.setOnClickListener{
            totalPoints.minus(5)
            binding.tvTotalPoints.text = getString(R.string.total_points, totalPoints)
            Toast.makeText(context, "5 Points redeemed", Toast.LENGTH_SHORT).show()
        }
        binding.btnRefer.setOnClickListener{
            totalPoints.plus(5)
            Toast.makeText(context, "Thanks! You  earned 5 points", Toast.LENGTH_SHORT).show()
        }
    }
}