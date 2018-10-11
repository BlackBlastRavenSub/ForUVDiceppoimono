package com.blastraven.b.foruvdice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_roll.*
import org.jetbrains.anko.button
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.textView

class RollActivity : AppCompatActivity() {
    //roll作成
    val roll = Roll(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_roll)
        constraintLayout {
            textView(R.id.textView) {
                textSize = 24f
            }.lparams {
                width = matchParent
                topMargin = dip(8)
            }
            button("") {
                onClick {
                    roll.roll(intent.getIntExtra("Num", 0))
                }
            }
        }

        xxx.setOnClickListener {
            val catch = intent
            val set = intent.getIntExtra("Num", 0)
            val intent = Intent(this, ConfidentialActivity::class.java)
            intent.putExtra("Num", set)
            startActivity(intent)
        }
    }
}
