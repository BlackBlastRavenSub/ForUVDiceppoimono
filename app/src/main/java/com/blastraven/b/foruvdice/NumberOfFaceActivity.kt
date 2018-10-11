package com.blastraven.b.foruvdice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.db.INTEGER
import org.jetbrains.anko.db.PRIMARY_KEY
import org.jetbrains.anko.db.UNIQUE
import org.jetbrains.anko.db.createTable
import org.jetbrains.anko.toast

class NumberOfFaceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_of_face)

        input.setOnClickListener {
            if (editText.text.toString() != "") {
                var num = Integer.parseInt(editText.text.toString())
                if (num != 0) {
                    database.use {
                        createTable("{$editText.text.toString()}", true,
                                "face" to INTEGER + PRIMARY_KEY + UNIQUE,
                                "param" to INTEGER)
                    }
                    val intent = Intent(this, RollActivity::class.java)
                    intent.putExtra("Num", num)
                    startActivity(intent)
                } else {
                    toast("0面は判定できない")
                }
            } else {
                toast("値を入力してください!")
            }
        }
    }
}
