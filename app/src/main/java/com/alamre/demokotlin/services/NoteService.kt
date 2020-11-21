package com.alamre.demokotlin.services

import com.alamre.demokotlin.Note
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NoteService {
    @GET("api/")
    fun getNotes(): Call<List<Note>>

    @POST("api/create")
    fun addNote(@Body newNote: Note) : Call<Note>

}