package com.example.evansontemplate.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.evansontemplate.R
import com.example.evansontemplate.utils.extensions.setSafeOnClickListener
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachActions()
    }

    private fun attachActions() {
        loginBtn.setSafeOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToMainFragment()
            view?.findNavController()?.navigate(action)
        }

    }

}