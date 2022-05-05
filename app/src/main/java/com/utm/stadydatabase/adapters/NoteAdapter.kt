package com.utm.stadydatabase.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.utm.stadydatabase.R
import com.utm.stadydatabase.database.Menu
import com.utm.stadydatabase.fragments.startfragment.StartFragment
import kotlinx.android.synthetic.main.item_layout.view.*

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view)

    var listMenu = emptyList<Menu>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.itemView.item_title.text = listMenu[position].name

    }

    override fun getItemCount(): Int {
        return listMenu.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Menu>){
        listMenu = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            StartFragment.clickItem(listMenu[holder.adapterPosition])
        }
    }
}