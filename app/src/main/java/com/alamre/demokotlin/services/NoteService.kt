package com.alamre.demokotlin.services

import com.alamre.demokotlin.Note
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NoteService {
    @GET("notes/")
    fun getNotes(): Call<List<Note>>

    @POST("notes/add")
    fun addNote(@Body newNote: Note) : Call<Note>

}