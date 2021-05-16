package com.template.snave_kotlin.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.template.snave_kotlin.R
import com.template.snave_kotlin.utils.extensions.setSafeOnClickListener
import kotlinx.android.synthetic.main.fragment_confirmation.*

class ConfirmationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachActions()
    }

    private fun attachActions() {
        logout_btn.setSafeOnClickListener {
            val action = ConfirmationFragmentDirections.actionConfirmationFragmentToLoginFragment()
            view?.findNavController()?.navigate(action)
        }

    }

}