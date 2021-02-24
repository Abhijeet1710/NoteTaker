package com.abhijeet.notetake.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abhijeet.notetake.R
import com.abhijeet.notetake.model.Note

class NoteAdapter(private val context: Context, private val listener: INotesAdapter): RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    val allNotes = ArrayList<Note>()

    inner class NoteViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.tv_note)
        val deleteBtn = itemView.findViewById<ImageView>(R.id.img_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.note_row, parent, false))
        viewHolder.deleteBtn.setOnClickListener {
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentItem = allNotes[position]
        holder.textView.text = currentItem.note
    }

    override fun getItemCount(): Int = allNotes.size

    fun updateList(newList : List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

}

interface INotesAdapter {
    fun onItemClicked(note : Note)
}