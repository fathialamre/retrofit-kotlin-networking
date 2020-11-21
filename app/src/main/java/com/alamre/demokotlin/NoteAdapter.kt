package com.alamre.demokotlin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class NoteAdapter(private val noteList: List<Note>) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.note = noteList[position]
        holder.txtNote.text = noteList[position].title
        holder.txtBody.text = noteList[position].body

//        holder.itemView.setOnClickListener { v ->
//            val context = v.context
//            val intent = Intent(context, DestinationDetailActivity::class.java)
//            intent.putExtra(DestinationDetailActivity.ARG_ITEM_ID, holder.note!!.id)
//
//            context.startActivity(intent)
//        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtNote: TextView = itemView.findViewById(R.id.txtTitle)
        val txtBody: TextView = itemView.findViewById(R.id.txtBody)
        var note: Note? = null

        override fun toString(): String {
            return """${super.toString()} '${txtNote.text}'"""
        }
    }
}