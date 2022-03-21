package org.eval.ui.bmi

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import org.eval.R
import org.eval.databinding.FragmentBmiBinding

class BmiFragment : Fragment() {

    private var _binding: FragmentBmiBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBmiBinding.inflate(inflater, container, false)
        binding.data = BmiViewModel().also { it.man = true }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bmi, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_bmi_clear -> {
                binding.data?.onReset()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}