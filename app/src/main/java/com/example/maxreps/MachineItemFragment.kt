package com.example.maxreps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maxreps.databinding.FragmentMachineItemListBinding

/**
 * A fragment representing a list of Items.
 */
class MachineItemFragment : Fragment() {

    private val viewModel: MachineItemViewModel by viewModels()

    private var _binding: FragmentMachineItemListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMachineItemListBinding.inflate(layoutInflater)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            list.layoutManager = LinearLayoutManager(context)
        }

        viewModel.apply {
            init()
            list.observe(viewLifecycleOwner) {
                binding.list.adapter = MyItemRecyclerViewAdapter(it)
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
