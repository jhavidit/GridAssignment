package tech.jhavidit.assignment

import java.util.ArrayList

fun createList(count : Int) : ArrayList<Int> {
    val list = ArrayList<Int>()
    for(i in 0 until count){
        for(j in 0 until count){
            if(i==0 || j==0 || i==count-1 || j==count-1 || i==j || i==count-j-1){
                list.add(1)
            }
            else
                list.add(0)
        }
    }

    return list
}