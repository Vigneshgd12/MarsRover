package com.snooper

import com.snooper.roverposition.RoverPositionCalculator
import java.util.*

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val `in` = Scanner(System.`in`)
        println("Please enter the top-right co-ordinates of the plateau in the format of (5,5) :")
        val topRightPosition = `in`.nextLine().toUpperCase()
        var loop: String = "Y";
        while(loop.equals("Y")) {
            println("Please enter the rover co-ordinates and direction in the format of (0,2,N) :")
            val currentPosition = `in`.nextLine().toUpperCase()
            println("Please enter the instructions according to which the rover has to move. in the format of (LMMLMMRM) " +
                    "Allowed inputs are L, M and R. L-> left turn, R- right turn and M-> move forward :")
            val instructions = `in`.nextLine().toUpperCase()
            println(RoverPositionCalculator.calculateRoverPosition(topRightPosition, currentPosition, instructions))
            println("Do you wish to enter another rover's details? Y|N ")
            loop = `in`.nextLine().toUpperCase()
        }
    }
}