package com.example.fragmenttutorial

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels


class FragmentA: Fragment() {
    // View model solution
    private val viewModel: ItemViewModel by activityViewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Error", "Fragment A attached")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d("Error", "ViewStateRestored")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)
        val text = view.findViewById<TextView>(R.id.my_text)
        // View model solution
        text.text = viewModel.currentTitle.value ?: "I’m waiting for updates!"

        // Fragment Result AP solution
//        setFragmentResultListener("requestKey") { _, bundle ->
//            val result = bundle.getString("title")
//            text.text = result ?: "I’m waiting for updates!"
//        }

        val button = view.findViewById<Button>(R.id.a_button_one)
        button.setOnClickListener {
            val fragmentB = FragmentB()
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container_view, fragmentB)
            transaction?.addToBackStack("fragments")
            transaction?.commit()
        }

        return view
    }
}