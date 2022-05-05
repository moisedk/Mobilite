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
import com.moise.mobilite.R
import com.moise.mobilite.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener{
            context?.startActivity(Intent(context, HomeMapsActivity::class.java))
            requireActivity().finish()
        }
        val spannableString = SpannableString(getString(R.string.forgot_password_help))
        val clickableSpan = object : ClickableSpan(){
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false

            }

            override fun onClick(widget: View) {
                Toast.makeText(requireContext(), "Help is on the way!", Toast.LENGTH_SHORT).show()
            }
        }
        spannableString.setSpan(clickableSpan, 17, 25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.tvPasswordRecover.text = spannableString
        binding.tvPasswordRecover.movementMethod = LinkMovementMethod.getInstance()
        binding.tvPasswordRecover.highlightColor = Color.TRANSPARENT
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}