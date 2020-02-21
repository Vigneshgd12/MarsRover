package com.snooper.model

class RoverPosition {
    var posX = 0
    var posY = 0
    var direction: Direction = Direction.N

    constructor(posX: Int, posY: Int, direction: Direction) {
        this.posX = posX
        this.posY = posY
        this.direction = direction
    }

    constructor() {}

    override fun toString(): String {
        return "Mars Rover is currently in the position " +
                "X:" + posX +
                ", Y:" + posY +
                ", and facing " + direction +
                " direction."
    }
}