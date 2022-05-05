package com.utm.stadydatabase.fragments.startfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.utm.stadydatabase.APP
import com.utm.stadydatabase.MainActivity
import com.utm.stadydatabase.R
import com.utm.stadydatabase.adapters.NoteAdapter
import com.utm.stadydatabase.database.Menu
import com.utm.stadydatabase.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NoteAdapter
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStartBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        viewModel.initDatabase()
        layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView = binding.rvNotes
        recyclerView.layoutManager = layoutManager
        adapter = NoteAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllNotes().observe(viewLifecycleOwner) { list ->
            adapter.setList(list.asReversed())
        }

        binding.btnAdd.setOnClickListener {

            APP.navController.navigate(R.id.action_startFragment_to_addFragment)
        }
    }

    companion object {
        fun clickItem(menu: Menu){
            val bundle = Bundle()
            bundle.putSerializable("menu", menu)
            APP.navController.navigate(R.id.action_startFragment_to_detailsFragment, bundle)
        }
    }
}