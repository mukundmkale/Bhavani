package com.mukund.mvvmcodearchitecture.util.customFunction

import android.view.View

class ExtensionFunction {

    fun View.show() {
        visibility = View.VISIBLE
    }

    fun View.hide() {
        visibility = View.GONE
    }

    fun View.inVisible() {
        visibility = View.INVISIBLE
    }

    fun View.setSafeOnClickListener(onSafeClick:(View)-> Unit)
    {
        val safeClickListener= SafeClickListener{
            onSafeClick(it)
        }
        setOnClickListener(safeClickListener)
    }
}