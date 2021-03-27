package com.example.evansontemplate.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.evansontemplate.R
import com.example.evansontemplate.utils.extensions.setSafeOnClickListener
import kotlinx.android.synthetic.main.fragment_specify_amount.*

class SpecifyAmountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachActions()
    }

    private fun attachActions() {
        send_btn.setSafeOnClickListener {
            val action = SpecifyAmountFragmentDirections.actionSpecifyAmountFragmentToConfirmationFragment()
            view?.findNavController()?.navigate(action)
        }

        cancel_btn.setSafeOnClickListener {
            activity?.onBackPressed()
        }
    }
}