package com.moise.mobilite.fragments

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
import androidx.navigation.fragment.findNavController
import com.moise.mobilite.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private val terms: CharSequence = "By signing up, you agree to Photo's Terms of Service and Privacy Policy"
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnNext.setOnClickListener {
            val action = RegisterFragmentDirections.actionRegisterFragmentToOtpFragment()
            findNavController().navigate(action)
        }
        binding.btnWithGoogle.setOnClickListener {
            Toast.makeText(
                context,
                "Logging in with Google Authentication API!!!",
                Toast.LENGTH_SHORT
            ).show()
        }
        val spannableString = SpannableString(terms)
        val clickableSpan = object : ClickableSpan() {
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }

            override fun onClick(widget: View) {
                Toast.makeText(requireContext(), "Terms and services", Toast.LENGTH_SHORT).show()
            }
        }
        spannableString.setSpan(clickableSpan, terms.indexOf("Terms"), terms.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.tvTerms.text = spannableString
        binding.tvTerms.movementMethod = LinkMovementMethod.getInstance()
        binding.tvTerms.highlightColor = Color.TRANSPARENT
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}