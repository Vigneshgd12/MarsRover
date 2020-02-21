package com.snooper.roverposition

import com.snooper.helper.RoverPositionHelper
import com.snooper.model.Direction
import com.snooper.model.Moves
import com.snooper.model.PlateauCoordinates
import com.snooper.model.RoverPosition

object RoverPositionCalculator {
    fun calculateRoverPosition(topRightPosition: String, currentPosition: String, instructions: String): RoverPosition? {
        val plateauCoordinates = RoverPositionHelper.getPlateauCoordinates(topRightPosition)
        val roverPosition = RoverPositionHelper.getCurrentPosition(currentPosition)
        val moves = RoverPositionHelper.getMoveInstruction(instructions)
        moves!!.stream().forEach { move: Moves? -> if (move == Moves.L) turnLeft(roverPosition!!) else if (move == Moves.R) turnRight(roverPosition) else if (move == Moves.M) moveForward(roverPosition, plateauCoordinates) }
        return roverPosition
    }

    private fun turnLeft(currentPosition: RoverPosition): RoverPosition {
        if (currentPosition.direction == Direction.N) {
            currentPosition.direction = Direction.W
        } else if (currentPosition.direction == Direction.S) {
            currentPosition.direction = Direction.E
        } else if (currentPosition.direction == Direction.E) {
            currentPosition.direction = Direction.N
        } else if (currentPosition.direction == Direction.W) {
            currentPosition.direction = Direction.S
        }
        return currentPosition
    }

    private fun turnRight(currentPosition: RoverPosition): RoverPosition {
        if (currentPosition.direction == Direction.N) {
            currentPosition.direction = Direction.E
        } else if (currentPosition.direction == Direction.S) {
            currentPosition.direction = Direction.W
        } else if (currentPosition.direction == Direction.E) {
            currentPosition.direction = Direction.S
        } else if (currentPosition.direction == Direction.W) {
            currentPosition.direction = Direction.N
        }
        return currentPosition
    }

    private fun moveForward(currentPosition: RoverPosition, plateauCoordinates: PlateauCoordinates): RoverPosition {
        if (currentPosition.direction == Direction.N) {
            if (plateauCoordinates.topRightY >= currentPosition.posY + 1) ++currentPosition.posY
        } else if (currentPosition.direction == Direction.S) {
            if (currentPosition.posY - 1 >= plateauCoordinates.bottomLeftY) --currentPosition.posY
        } else if (currentPosition.direction == Direction.E) {
            if (plateauCoordinates.topRightX >= currentPosition.posX + 1) ++currentPosition.posX
        } else if (currentPosition.direction == Direction.W) {
            if (currentPosition.posX - 1 >= plateauCoordinates.bottomLeftX) --currentPosition.posX
        }
        return currentPosition
    }
}