package com.blastraven.b.foruvdice

import java.util.*

class Roll(num: Int) {
    var result = 0//ダイスロールの結果は!?
    var numface = num//ダイスの面数
    var commonmultiple = 0//最小公倍数
    var percentParam = Array<Int>(numface + 1) { 0 }//百分率の配列
    var outcome = 0//結果
    var directRand = (0..numface).random()//乱数
    var percentageRand = (1..100).random()//乱数
    var commonmultipleRand = 0//乱数
    fun ClosedRange<Int>.random() =
            Random().nextInt((endInclusive + 1) - start) + start

    fun roll(num: Int): Int {
        //判定方法分岐

        //各種初期化
        numface = num//ダイスの面数
        commonmultiple = 0//最小公倍数
        percentParam = Array<Int>(numface + 1) { 0 }//百分率の配列
        outcome = 0//結果
        directRand = (0..numface).random()//乱数
        percentageRand = (1..100).random()//乱数
        commonmultipleRand = 0//乱数

        //いざ転がす!
        //テスト用、まずは前回と同じ計算方式のPercentageRollを使用する
        PercentageRoll(numface)
        return result
    }

    //確率を直接表記
    fun DirectRoll(tossNum: Int) {
        var numface = tossNum
        directRand = (1..numface).random()
        for (i in 1..numface) {
            when (directRand) {
                i -> outcome = i
            }
        }
    }

    //確率を百分率で判定
    fun PercentageRoll(tossNum: Int) {
        val test = Array(7) { i -> i + 1 }
        this.numface = tossNum
        percentageRand = (1..100).random()
        for (i in 1..numface) {
            when (percentageRand) {
                in percentParam[i - 1]..percentParam[i] -> outcome = i
                //in test[i - 1]..test[i] -> outcome = i+1
            }
        }
        result = outcome
    }
    /*
     fun PercentageRoll(tossnum: Int) {
        this.numface = tossnum
        percentageRand = (1..100).random()
        for (i in 1..numface) {
            when (percentageRand) {
                in percentParam[i - 1]..percentParam[i] -> outcome = i
            }
        }
        result = outcome
    }
     */

    //確率を最小公倍数で判定
    fun commonmultipleRoll(tossnum: Int) {
        this.numface = tossnum
        commonmultipleRand = (0..commonmultiple).random()
        for (i in 1..numface) {
            when (commonmultipleRand) {
                in 2..10 -> outcome = i
            }
        }
    }

}