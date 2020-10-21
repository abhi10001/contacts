package com.android.project.contacts

import android.content.ContentResolver
import android.database.Cursor
import android.provider.ContactsContract
import androidx.lifecycle.ViewModel

class ContactsViewModel(val repository: ContactsRepository): ViewModel() {
     fun readContacts(contentResolver: ContentResolver): ArrayList<String> {
       return repository.readContacts(contentResolver)
    }
}