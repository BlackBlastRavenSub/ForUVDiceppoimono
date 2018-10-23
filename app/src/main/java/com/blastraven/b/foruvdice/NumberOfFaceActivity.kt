package com.blastraven.b.foruvdice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_number_of_face.*
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
                        /*
                        テーブルネームは入力された面数の値と同じ(6面なら6)
                        以下要素一覧
                        id:識別番号(要はfaceと同じ)
                        face:サイコロの面の値
                        probability:その値の出る確率
                         */
                        //{$editText.text.toString()}
                        createTable("2", true,
                                "id" to INTEGER + PRIMARY_KEY + UNIQUE,
                                "face" to INTEGER,
                                "probability" to INTEGER)
                        //この真下にinsertすることは出来るのだが、ConfidentitalActvivtyからinsertすることが出来ない・・
                        //同じクラス内のデータベースにしかアクセスすることが出来ないのか？ そんなんだったらデータベースを使う価値は全く無いが、まさかそんなことはありえないだろう
                        //databaseのインスタンスを作成するのか？ankoの説明書にはそんな事書いてあるようには見えなかったが
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
