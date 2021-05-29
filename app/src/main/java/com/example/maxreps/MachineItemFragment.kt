package com.example.maxreps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A fragment representing a list of Items.
 */
class MachineItemFragment : Fragment() {

    private val viewModel: MachineItemViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_machine_item_list, container, false)

        viewModel.apply {
            // Set the adapter
            init()
            if (view is RecyclerView) {
                with(view) {
                    layoutManager = LinearLayoutManager(context)
                    list.observe(viewLifecycleOwner) {
                        adapter = MyItemRecyclerViewAdapter(it)
                    }
                }
            }
        }
        return view
    }
}
