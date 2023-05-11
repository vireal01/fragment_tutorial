package com.example.fragmenttutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels


class FragmentC: Fragment() {
    // View model solution
    private val viewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_c, container, false)
        val buttonOne = view.findViewById<Button>(R.id.c_button_one)
        val buttonTwo = view.findViewById<Button>(R.id.c_button_two)
        val buttonThree = view.findViewById<Button>(R.id.c_button_three)

        buttonOne.setOnClickListener {
            val newFragmentATitle = "Hello from fragment C!"
            // Fragment Result AP solution
//            setFragmentResult("requestKey", bundleOf("title" to newFragmentATitle))

            // View model solution
            viewModel.firstButtonTitle(newFragmentATitle)
        }

        buttonTwo.setOnClickListener {
            val fragment = FragmentA()
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container_view, fragment)
            // Fragment Result AP solution
//            setFragmentResult("requestKey", bundleOf("title" to null))
            // View model solution
            viewModel.clearData()

            transaction?.commit()
            activity?.supportFragmentManager?.popBackStack("fragments", FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }

        buttonThree.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

        return view
    }
}