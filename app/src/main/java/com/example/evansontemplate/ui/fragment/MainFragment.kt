package com.example.evansontemplate.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.evansontemplate.R
import com.example.evansontemplate.ui.base.BaseFragment
import com.example.evansontemplate.utils.extensions.setSafeOnClickListener
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachActions()
    }

    private fun attachActions() {
        view_transactions_btn.setSafeOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToViewTransactionFragment3()
            view?.findNavController()?.navigate(action)
        }

        send_money_btn.setSafeOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToChooseRecipientFragment()
            view?.findNavController()?.navigate(action)
        }

        view_balance_btn.setSafeOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToViewBalanceFragment()
            view?.findNavController()?.navigate(action)
        }
    }

}