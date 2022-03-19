package org.eval.ui.home

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.eval.R

open class HomeViewModel(private val home: Fragment) {
    open fun toEval() {
        home.findNavController().navigate(R.id.action_HomeFragment_to_EvalFragment)
    }

    open fun toBmi() {
        home.findNavController().navigate(R.id.action_HomeFragment_to_BmiFragment)
    }
}