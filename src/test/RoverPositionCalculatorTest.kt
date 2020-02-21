package test

import com.snooper.model.Direction
import com.snooper.model.RoverPosition
import com.snooper.roverposition.RoverPositionCalculator

class RoverPositionCalculatorTest {
    fun roverPositionCalculatorTest() {
        val roverPositionTest1Actual = RoverPositionCalculator.calculateRoverPosition("5,5", "1,2,N", "LMLMLMLMM")
        val roverPositionTest1Expected = RoverPosition(1, 3, Direction.N)
        val roverPositionTest2 = RoverPositionCalculator.calculateRoverPosition("5,5", "3,3,E", "MMRMMRMRRM")
        val roverPositionTest2Expected = RoverPosition(5, 1, Direction.E)
    }
}