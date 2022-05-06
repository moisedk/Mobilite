package com.moise.mobilite.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.moise.mobilite.activities.HomeMapsActivity
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

        binding.btnAccountCreation.setOnClickListener{
            startActivity(Intent(context, HomeMapsActivity::class.java))
            requireActivity().finish()
        }
        val resend = "Resend"
        val spannableString = SpannableString(resend)
        val clickableSpan = object : ClickableSpan (){
            override fun onClick(widget: View) {
                Toast.makeText(requireContext(), "Will be resent!", Toast.LENGTH_SHORT).show()
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }
        spannableString.setSpan(clickableSpan, 0, resend.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.tvResendOPT.text = spannableString
        binding.tvResendOPT.movementMethod = LinkMovementMethod.getInstance()
        binding.tvResendOPT.highlightColor = Color.TRANSPARENT
    }
}