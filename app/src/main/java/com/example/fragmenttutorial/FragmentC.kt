package com.example.fragmenttutorial

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResult


class FragmentC: Fragment() {
    @SuppressLint("MissingInflatedId", "ResourceType", "CommitTransaction")
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
            setFragmentResult("requestKey", bundleOf("title" to newFragmentATitle))
        }

        buttonTwo.setOnClickListener {
            val fragment = FragmentA()
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container_view, fragment)
            setFragmentResult("requestKey", bundleOf("title" to null))
            transaction?.commit()
            activity?.supportFragmentManager?.popBackStack("fragments", FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }

        buttonThree.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

        return view
    }
}