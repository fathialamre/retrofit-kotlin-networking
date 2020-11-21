package com.alamre.demokotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class NoteAdapter(private val noteList: List<Note>) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.note_list_item,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val imgURI: String = noteList[position].pictureUrl.toString()

        holder.note = noteList[position]
        holder.txtNote.text = noteList[position].title
        holder.txtBody.text = noteList[position].body
        Glide.with(holder.itemView.context).load(imgURI).into(holder.imgView)

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
        val imgView: ImageView = itemView.findViewById(R.id.imageView)
        var note: Note? = null

        override fun toString(): String {
            return """${super.toString()} '${txtNote.text}'"""
        }
    }
}