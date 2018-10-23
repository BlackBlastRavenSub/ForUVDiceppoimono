package com.blastraven.b.foruvdice

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_roll.*
import kotlinx.android.synthetic.main.activity_roll.view.*
import kotlinx.android.synthetic.main.activity_title.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.sdk27.coroutines.onClick

class RollActivity : AppCompatActivity() {
    private var Instance: Context? = null

    //roll作成
    val roll = Roll(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Instance = this
        fun RollActivityGetContext(): Context {
            return Instance as Context
        }
        //setContentView(R.layout.activity_roll)
        verticalLayout {
            //判定結果を表示するView
            val textview = textView(R.id.textView) {
                textSize = 24f
            }.lparams {
                width = matchParent
                topMargin = dip(8)
            }
            button("ROLL!") {
                onClick {
                    textview.text = (Integer.toString(roll.roll(intent.getIntExtra("Num", 0))))
                }
            }.lparams {
                width = matchParent
                topMargin = dip(234)
            }
            button("再設定") {
                onClick {
                    finish()
                }
            }
            button("Confidential") {
                onClick {
                    val catch = intent
                    val set = intent.getIntExtra("Num", 0)
                    val intent = Intent(RollActivityGetContext(), ConfidentialActivity::class.java)
                    intent.putExtra("Num", set)
                    startActivity(intent)
                }
            }
        }

        /*xxx.setOnClickListener {
            val catch = intent
            val set = intent.getIntExtra("Num", 0)
            val intent = Intent(this, ConfidentialActivity::class.java)
            intent.putExtra("Num", set)
            startActivity(intent)
        }
        */
    }
}
