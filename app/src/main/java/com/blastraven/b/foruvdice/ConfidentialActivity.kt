package com.blastraven.b.foruvdice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.sdk27.coroutines.onClick

class ConfidentialActivity : AppCompatActivity() {
    var numface = 0
    var t = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        val intent = intent
        numface = intent.getIntExtra("Num", 0)
        val temp = Array<Int>(numface, { 0 })
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_confidential)
        for (i in 1..numface) {
            /*
            database.use {
                select(numface.toString())
                        .whereArgs("(face > {face})",
                                "face" to "$i")
            }.exec { parseList(classParser()) }
            */
        }
        //setContentView(R.layout.activity_confidential)
        linearLayout {
            scrollView {

                verticalLayout {
                    padding = dip(30)
                    for (i in 1..numface) {
                        button("$i:${temp[i - 1]}") {
                            textSize = 20f
                        }
                    }
                }
            }//.lparams(width = matchParent, height = matchParent)
            button("accept") {
                onClick {
                    for (i in 1..numface) {
                        database.use {
                            insert(numface.toString(),
                                    "face" to i,
                                    "param" to temp[i])
                        }
                    }
                    toast(t)
                }
            }
        }
    }
}