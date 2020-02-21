package com.snooper.helper

import com.snooper.exception.InvalidRoverPositionException
import com.snooper.exception.InvalidTopRightCoordinateException
import com.snooper.model.Direction
import com.snooper.model.Moves
import com.snooper.model.PlateauCoordinates
import com.snooper.model.RoverPosition
import java.util.*

object RoverPositionHelper {
    fun getPlateauCoordinates(topRightPosition: String): PlateauCoordinates {
        val topRightParams = topRightPosition.split(",".toRegex()).toTypedArray()
        return if (topRightParams.size == 2) {
            try {
                PlateauCoordinates(topRightParams[0].toInt(), topRightParams[1].toInt())
            } catch (e: Exception) {
                throw InvalidTopRightCoordinateException(topRightPosition)
            }
        } else {
            throw InvalidTopRightCoordinateException(topRightPosition)
        }
    }

    fun getCurrentPosition(currentPossition: String): RoverPosition {
        val positionParams = currentPossition.split(",".toRegex()).toTypedArray()
        return if (positionParams.size == 3) {
            try {
                RoverPosition(positionParams[0].toInt(), positionParams[1].toInt(), Direction.valueOf(positionParams[2]))
            } catch (e: Exception) {
                throw InvalidRoverPositionException(currentPossition)
            }
        } else {
            throw InvalidRoverPositionException(currentPossition)
        }
    }

    fun getMoveInstruction(instructions: String): List<Moves> {
        val instructionsParams = instructions.toCharArray();
        return try {
            val moves: MutableList<Moves> = ArrayList()
            for (instruction in instructionsParams) moves.add(Moves.valueOf(instruction.toString()))
            moves
        } catch (e: Exception) {
            throw InvalidRoverPositionException(instructions)
        }
    }
}