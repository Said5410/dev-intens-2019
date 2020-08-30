package com.hfad.devintensive.extensions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR


fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, unites: TimeUnits = TimeUnits.SECOND) : Date{
    var time = this.time

    time += when(unites){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date:Date=Date()): String {
//    var diff = date.time - this.time
//    var humanStr = ""
//    if (diff in 0 until 1) humanStr = "только что"
//    if (diff in 2 until 45) humanStr = "несколько секунд назад"
//    if (diff in 45 until 75) humanStr = "минуту назад"
//    if (diff in 75 until 45*60){
//        var minutesAgo = (diff / 60).toString()
//        var ends = ""
//        if (minutesAgo.length > 1 && minutesAgo[minutesAgo.length-2] == '1') ends = ""
//        if (minutesAgo[minutesAgo.length-1] == '1') ends = "у"
//        if (minutesAgo[minutesAgo.length-1] in '2'..'4') ends = "ы"
//        humanStr = "$minutesAgo минут$ends назад"
//    }
//    if (diff in 45*60 until 75*60) humanStr = "час назад"
//    if (diff in 75*60 until 22*60*60){
//        var hoursAgo = (diff / 60 / 60).toString()
//        var ends = ""
//        if (hoursAgo[hoursAgo.length-1] in '2'..'4' ) ends = "а"
//        if (hoursAgo[hoursAgo.length-1] in '5'..'9' || hoursAgo[hoursAgo.length-1] =='0') ends = "ов"
//        humanStr = "$hoursAgo час$ends назад"
//    }
//    if (diff in 22*60*60 until 26*60*60) humanStr = "день назад"
//    if (diff in 26*60*60 until 360*24*60*60){
//        var daysAgo = (diff /24/60/60).toString()
//        var ends =""
//        if (daysAgo[daysAgo.length-1] == '1')
//    }
    TODO("not implemented")
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}