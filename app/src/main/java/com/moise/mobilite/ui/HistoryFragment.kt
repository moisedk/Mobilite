package com.moise.mobilite.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moise.mobilite.R
import com.moise.mobilite.databinding.FragmentHistoryBinding
import java.util.*

class HistoryFragment : Fragment() {
    private val rideHistory = mutableListOf(
        Ride("Mother and Child Hospital", Calendar.getInstance().time, true),
        Ride("Port Louis Casela Nature Park", Calendar.getInstance().time, true),
        Ride("The City Orient Restaurant", Calendar.getInstance().time, false),
        Ride("Train Ride Waterfront", Calendar.getInstance().time, true),
    )
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.history_recyclerview)
        val adapter = HistoryAdapter(requireContext(), rideHistory)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}