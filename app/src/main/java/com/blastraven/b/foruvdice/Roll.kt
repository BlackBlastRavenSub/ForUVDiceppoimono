package com.blastraven.b.foruvdice

import java.util.*

class Roll(num: Int) {
    var result=0//ダイスロールの結果は!?
    var numface = num//ダイスの面数
    var commonmultiple = 0//最小公倍数
    var Percentparam = arrayListOf<Int>(numface, 0)//百分率の配列
    var Outcome = 0//結果
    var directrand = (0..numface).random()//乱数
    var Percentagerand = (1..100).random()//乱数
    var commonmultiplerand = 0//乱数
    fun ClosedRange<Int>.random() =
            Random().nextInt((endInclusive + 1) - start) + start

    fun roll(num: Int):Int {
        //判定方法分岐

        //各種初期化
        numface = num//ダイスの面数
        commonmultiple = 0//最小公倍数
        Percentparam = arrayListOf<Int>(numface, 0)//百分率の配列
        Outcome = 0//結果
        directrand = (0..numface).random()//乱数
        Percentagerand = (1..100).random()//乱数
        commonmultiplerand = 0//乱数

        //いざ転がす!
        //テスト用
        return result
    }

    //確率を直接表記
    fun DirectRoll(tossnum: Int) {
        var numface = tossnum
        directrand = (1..numface).random()
        for (i in 1..numface) {
            when (directrand) {
                i -> Outcome = i
            }
        }
    }

    //確率を百分率で判定
    fun PercentageRoll(tossnum: Int) {
        this.numface = tossnum
        Percentagerand = (1..100).random()
        for (i in 1..numface) {
            when (Percentagerand) {
                in Percentparam[i - 1]..Percentparam[i] -> Outcome = i
            }
        }

    }

    //確率を最小公倍数で判定
    fun commonmultipleRoll(tossnum: Int) {
        this.numface = tossnum
        commonmultiplerand = (0..commonmultiple).random()
        for (i in 1..numface) {
            when (commonmultiplerand) {
                in 2..10 -> Outcome = i
            }
        }
    }

}