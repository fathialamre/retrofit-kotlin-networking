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

        println("call")

        val fab: View = findViewById(R.id.btnAdd)
        fab.setOnClickListener {
            print("aaaaaa")
            insertNote()
        }
    }

    private fun insertNote() {
        val note = Note()
        note.title = txtTitle.text.toString();
        note.body  = txtBody.text.toString();
            print("aaaaaa")
        noteService.addNote(note).enqueue(object : retrofit2.Callback<Note> {
            override fun onResponse(call: Call<Note>, response: Response<Note>) {
                print(response.body())
                finish()
            }

            override fun onFailure(call: Call<Note>, t: Throwable) {
                println(call)
                println(t.message)
            }

        })
    }
}