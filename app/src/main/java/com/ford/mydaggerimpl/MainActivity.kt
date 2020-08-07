package com.ford.mydaggerimpl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var injectedModel: Model
    @Inject lateinit var anotherModel: InjectableModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        println("MainActivity -> model -> text=${injectedModel.text}")
        println("MainActivity -> anotherModel -> value=${anotherModel.firstValue}")
    }
}