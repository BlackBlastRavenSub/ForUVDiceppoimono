package com.blastraven.b.foruvdice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.button
import org.jetbrains.anko.db.*
import org.jetbrains.anko.dip
import org.jetbrains.anko.padding
import org.jetbrains.anko.verticalLayout

class ConfigActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_config)
        verticalLayout {
            padding = dip(30)

            button("Login") {
                textSize = 26f
            }
        }

        database.use {
            createTable("Customer", true,
                    "id" to INTEGER + PRIMARY_KEY + UNIQUE,
                    "name" to TEXT,
                    "photo" to BLOB)
        }
    }
    fun SaveConfig() {

    }
}
