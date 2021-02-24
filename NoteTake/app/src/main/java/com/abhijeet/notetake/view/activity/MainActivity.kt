package com.abhijeet.notetake.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhijeet.notetake.R
import com.abhijeet.notetake.model.Note
import com.abhijeet.notetake.view.adapter.INotesAdapter
import com.abhijeet.notetake.view.adapter.NoteAdapter
import com.abhijeet.notetake.viewmodel.NoteViewModel

class MainActivity : AppCompatActivity(), INotesAdapter {

    lateinit var viewModel : NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.note_recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NoteAdapter(this, this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this,
        ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        viewModel.allNotes.observe( this, Observer {
            it?.let {
                adapter.updateList(it)
            }
        } )

    }

    override fun onItemClicked(note: Note) {
        viewModel.deleteNote(note)
        Toast.makeText(this, "Success Delete" , Toast.LENGTH_LONG).show()
    }

    fun submitData(view: View) {
        val addText = findViewById<TextView>(R.id.et_text)
        viewModel.insertNote(Note(addText.text.toString()))
        Toast.makeText(this, "Success Insertion" , Toast.LENGTH_LONG).show()
    }


}