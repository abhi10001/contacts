package com.android.project.contacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.android.project.contacts.databinding.ActivityMainBinding
import io.reactivex.Observable
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val viewModel:ContactsViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this, R.layout.activity_main)

    }

    private fun createContactsObservable(): Observable<String> {
        return Observable.create{emitter ->

        }
    }
}