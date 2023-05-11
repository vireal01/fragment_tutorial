package com.example.fragmenttutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels


class FragmentB: Fragment() {
    // View model solution
    private val viewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_b, container, false)
        val buttonOne = view.findViewById<Button>(R.id.b_button_one)
        val buttonTwo = view.findViewById<Button>(R.id.b_button_two)
        val buttonThree = view.findViewById<Button>(R.id.b_button_three)

        buttonOne.setOnClickListener {
            val newFragmentATitle = "Hello from fragment B!"
            // View model solution
            viewModel.firstButtonTitle(newFragmentATitle)

            // Fragment Result AP solution
//            setFragmentResult("requestKey", bundleOf("title" to newFragmentATitle))
        }

        buttonTwo.setOnClickListener {
            val fragmentC = FragmentC()
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container_view, fragmentC)
            transaction?.addToBackStack("fragments")
            transaction?.commit()
        }

        buttonThree.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

        return view
    }
}