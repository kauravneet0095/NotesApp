package com.example.notesdemo.presentation.notes.component.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesdemo.R
import com.example.notesdemo.domain.model.NotesEntity
import com.example.notesdemo.interfaces.OnItemClickListener
import com.example.notesdemo.presentation.notes.component.adapter.vh.NotesVH

class NotesAdapter(
    private var notesList: List<NotesEntity>,
    val context: Context,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<NotesVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesVH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.notes_tiles, parent, false)
        return NotesVH(v)
    }

    override fun getItemCount(): Int {
        return notesList.size

    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: NotesVH, position: Int) {
        holder.binding?.tvNotesTitle?.text = notesList[position].title
        holder.binding?.tvNotesDesc?.text = notesList[position].description
        holder.binding?.imgEditNote?.setOnClickListener {
            listener.onItemClick(notesList[position].id)
        }
        notesList[position].cardColor?.let {
            it.toIntOrNull()?.let { it1 ->
                holder.binding?.parentLay?.setBackgroundColor(
                    it1
                )
            }
        }
    }

}