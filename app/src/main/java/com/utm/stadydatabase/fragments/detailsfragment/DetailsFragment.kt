package com.utm.stadydatabase.fragments.detailsfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.utm.stadydatabase.APP
import com.utm.stadydatabase.R
import com.utm.stadydatabase.database.Menu
import com.utm.stadydatabase.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    lateinit var binding: FragmentDetailsBinding
    lateinit var currentNote: Menu

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        currentNote = arguments?.getSerializable("menu") as Menu
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

        binding.foodName.text = currentNote.name
        binding.foodCategory.text = "Category: " + currentNote.category
        binding.foodPrice.text = "Price: " + currentNote.price + " UAH"
        binding.foodWeight.text = "Weight: " + currentNote.weight + "kg"
        binding.foodAmount.text = "Amount: " + currentNote.amount

        binding.btnBackDetails.setOnClickListener {
            APP.navController.navigate(R.id.action_detailsFragment_to_startFragment)
        }

        binding.btnDelete.setOnClickListener {
            viewModel.delete(currentNote){}
            APP.navController.navigate(R.id.action_detailsFragment_to_startFragment)
        }
    }
}