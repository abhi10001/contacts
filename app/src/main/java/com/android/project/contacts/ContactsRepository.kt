package com.android.project.contacts

import android.content.ContentResolver
import android.database.Cursor
import android.provider.ContactsContract

class ContactsRepository {
    fun readContacts(contentResolver: ContentResolver): ArrayList<String> {
        var arrayList  = ArrayList<String>()
        val cursor: Cursor? =
            contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null)
        if (cursor?.moveToFirst()!!) {
            do {
                //cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.STARRED)) for fav
                arrayList.add(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)))
            } while (cursor.moveToNext())
        }
        return arrayList
    }
}