package com.example.zvent3.newguest

import androidx.lifecycle.ViewModel

class AddguestViewModel : ViewModel() {
    private var valueWidth: String? = null
    private var values: ArrayList<String?>? = null
    private var type: String? = null
    fun getValueWidth(): String? {
        return valueWidth
    }

    fun setValueWidth(valueWidth: String?) {
        this.valueWidth = valueWidth
    }

    fun getvalues(): ArrayList<String?>? {
        return values
    }

    fun setvalues(values: ArrayList<String?>?) {
        this.values = values
    }


}
