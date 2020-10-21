package com.android.project.contacts

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

/**created by Abhi10001**/

inline fun <reified T : Activity> Context._startActivity(argsBundle: Bundle.() -> Unit ={}){
    val intent = Intent(this,T::class.java)
    intent.putExtras(Bundle().apply(argsBundle))
    startActivity(intent)
}