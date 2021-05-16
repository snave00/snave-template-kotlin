package com.snave.sabong_guide.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.snave.sabong_guide.R
import com.snave.sabong_guide.utils.extensions.setSafeOnClickListener
import kotlinx.android.synthetic.main.fragment_choose_recipient.*

class ChooseRecipientFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachActions()
    }

    private fun attachActions() {
        next_btn.setSafeOnClickListener {
            val action = ChooseRecipientFragmentDirections.actionChooseRecipientFragmentToSpecifyAmountFragment()
            view?.findNavController()?.navigate(action)
        }

        cancel_btn.setSafeOnClickListener {
            activity?.onBackPressed()
        }
    }
}