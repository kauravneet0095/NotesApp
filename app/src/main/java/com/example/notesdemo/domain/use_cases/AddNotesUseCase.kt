package com.example.notesdemo.domain.use_cases

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.notesdemo.domain.model.NotesEntity
import com.example.notesdemo.domain.repository.NotesRepository

class AddNotesUseCase constructor(private val notesRepository: NotesRepository) {

    fun addNotes(note: NotesEntity, context: Context) {
        notesRepository.addNote(note, context)
    }

    fun getAllNotes(): LiveData<List<NotesEntity>>? {
        return notesRepository.getAllNotes()
    }

    fun updateStudentDetails(context: Context, notesEntity: NotesEntity) {
        notesRepository.updateStudentDetails(context, notesEntity)
    }

    fun getDataById(id: Int): NotesEntity? {
        return notesRepository.getDataById(id)
    }
}