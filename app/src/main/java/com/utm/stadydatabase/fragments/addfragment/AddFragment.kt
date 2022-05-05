package com.utm.stadydatabase.fragments.addfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.utm.stadydatabase.APP
import com.utm.stadydatabase.R
import com.utm.stadydatabase.database.Menu
import com.utm.stadydatabase.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddViewModel::class.java)

        binding.btnAddFood.setOnClickListener {
            val name = binding.detailsName.text.toString()
            val category = binding.detailsCategory.text.toString()
            val price = binding.detailsPrice.text.toString().toInt()
            val weight = binding.detailsWeight.text.toString().toInt()
            val amount = binding.detailsAmount.text.toString().toInt()

            viewModel.insert(Menu(category = category, name = name, price=price, weight=weight, amount=amount)){}
            APP.navController.navigate(R.id.action_addFragment_to_startFragment)
        }

        binding.btnBackAdd.setOnClickListener {
            APP.navController.navigate(R.id.action_addFragment_to_startFragment)
        }
    }
}