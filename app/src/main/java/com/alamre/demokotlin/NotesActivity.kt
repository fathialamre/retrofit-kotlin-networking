package com.alamre.demokotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.alamre.demokotlin.activities.CreateNoteActivity
import com.alamre.demokotlin.services.NoteService
import com.alamre.demokotlin.services.ServiceBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.notes_activity.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.security.auth.callback.Callback

class NotesActivity : AppCompatActivity() {

    private val noteService = ServiceBuilder.buildService(NoteService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notes_activity)



        loadData()
        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this, CreateNoteActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun loadData() {
        noteService.getNotes().enqueue(object : retrofit2.Callback<List<Note>> {
            override fun onResponse(call: Call<List<Note>>, response: Response<List<Note>>) {
                showData(response.body()!!)
            }

            override fun onFailure(call: Call<List<Note>>, t: Throwable) {
                println(t)
            }

        })
    }

    private fun showData(noteList: List<Note>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@NotesActivity)
            adapter = NoteAdapter(noteList)
        }
    }
}
