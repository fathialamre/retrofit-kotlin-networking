package com.alamre.demokotlin.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alamre.demokotlin.Note
import com.alamre.demokotlin.R
import com.alamre.demokotlin.services.NoteService
import com.alamre.demokotlin.services.ServiceBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.create_note_activity.*
import retrofit2.Call
import retrofit2.Response

class CreateNoteActivity : AppCompatActivity() {
    private val noteService = ServiceBuilder.buildService(NoteService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_note_activity)



        val fab: View = findViewById(R.id.btnAdd)
        fab.setOnClickListener { view ->
            insertNote()
            Snackbar.make(view, "Note Inserted Successfully", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }
    }

    private fun insertNote() {
        val note = Note()
        note.title = txtTitle.text.toString();
        note.body  = txtBody.text.toString();

        noteService.addNote(note).enqueue(object : retrofit2.Callback<Note> {
            override fun onResponse(call: Call<Note>, response: Response<Note>) {
                finish()
            }

            override fun onFailure(call: Call<Note>, t: Throwable) {
                println(call)
                println(t.message)
            }

        })
    }
}