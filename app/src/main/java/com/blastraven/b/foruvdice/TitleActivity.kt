package com.blastraven.b.foruvdice

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.button
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.verticalLayout

class TitleActivity : AppCompatActivity() {
    private var Instance: Context? = null
    val uri: Uri = Uri.parse("http://temporaryaddress.jpn.ph")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Instance = this
        fun TitleActivityGetContext(): Context {
            return Instance as Context
        }
        setContentView(R.layout.activity_title)
        // val roll = findViewById<Button>(R.id.button)
        verticalLayout {
            button("ROLL.EXE") {
                textSize = 15f
                onClick {
                    val intent = Intent(TitleActivityGetContext(), NumberOfFaceActivity::class.java)
                    startActivity(intent)
                }
            }
            button("HELP") {
                textSize = 15f
                onClick {
                    val intent = Intent(TitleActivityGetContext(), NumberOfFaceActivity::class.java)
                    startActivity(intent)
                }
            }
            button("SETTING") {
                textSize = 15f
                onClick {
                    val intent = Intent(TitleActivityGetContext(), SettingsActivity::class.java)
                    startActivity(intent)
                }
            }
            button("ACCESSHOME") {
                textSize = 15f
                onClick {
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)
                }
            }
        }
    }
}
