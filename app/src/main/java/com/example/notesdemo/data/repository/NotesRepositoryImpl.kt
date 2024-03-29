package com.example.notesdemo.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.notesdemo.data.data_source.db.NotesDao
import com.example.notesdemo.data.data_source.db.NotesDatabase
import com.example.notesdemo.domain.model.NotesEntity
import com.example.notesdemo.domain.repository.NotesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesRepositoryImpl(val notesDao: NotesDao?) : NotesRepository {

    private fun initialiseDB(context: Context): NotesDatabase {
        return NotesDatabase.getInstance(context)
    }

    override fun addNote(notesEntity: NotesEntity, context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            initialiseDB(context)
            notesDao?.addNotes(notesEntity)
        }
    }

    override fun getAllNotes(): LiveData<List<NotesEntity>>? {
        return notesDao?.getAllNotes()
    }

    override fun updateNotes(notesEntity: NotesEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            notesDao?.updateNotes(
                notesEntity.id,
                notesEntity.title,
                notesEntity.description,
                notesEntity.cardColor,
                notesEntity.isEdited,
                notesEntity.createdAt,
                notesEntity.updatedAt
            )
        }
    }

    override fun getDataById(id: Int): LiveData<NotesEntity>? {
        return notesDao?.getDataById(id)
    }
}


