package com.android.project.contacts

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**created by Abhi10001**/

val contactsModule = module{
    single(createdAtStart = true){
        ContactsRepository()
    }
    viewModel { ContactsViewModel(get()) }
}