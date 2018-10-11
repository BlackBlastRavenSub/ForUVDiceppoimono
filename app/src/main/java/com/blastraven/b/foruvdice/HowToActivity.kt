package com.blastraven.b.foruvdice

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import org.jetbrains.anko.button
import org.jetbrains.anko.dip
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.verticalLayout

class HowToActivity : AppCompatActivity() {
    private var Instance: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_how_to)
        Instance = this
        fun HowToActivityGetContext(): Context {
            return Instance as Context
        }
        linearLayout {
            //1行目
            verticalLayout {
                //このアプリについて
                button("このアプリについて") {
                    textSize = 15f
                    onClick {
                        AlertDialog.Builder(HowToActivityGetContext())
                                .setTitle("このアプリについて")
                                .setMessage("TEST")
                                .setPositiveButton("確認") { dialog, which ->
                                }.show()
                    }
                }//このアプリについて(ここまで)
                //注意事項
                button("注意事項") {
                    textSize = 15f
                    onClick {
                        AlertDialog.Builder(HowToActivityGetContext())
                                .setTitle("注意事項")
                                .setMessage("このアプリは個人が開発しています。\n" +
                                        "そのため予告のないサービスの終了・修復不可能なバグ\n" +
                                        "等が発生する可能性があります。予めご了承してから当サービスをご利用してください！")
                                .setPositiveButton("確認") { dialog, which ->
                                }.show()
                    }
                }//注意事項(ここまで)
            }.lparams { rightMargin = dip(32) }
            //2行目

            verticalLayout {
                //操作法について
                button("操作法について") {
                    textSize = 20f
                    onClick {
                        AlertDialog.Builder(HowToActivityGetContext())
                                .setTitle("操作法について")
                                .setMessage("TEST")
                                .setPositiveButton("確認") { dialog, which ->
                                }.show()
                    }
                }
                //操作法について(ここまで)
            }.lparams { rightMargin = dip(4) }
        }

    }
}
