package com.snooper.model

class PlateauCoordinates {
    var bottomLeftX: Int
        private set
    var bottomLeftY: Int
        private set
    var topRightX = 0
    var topRightY = 0

    constructor(topRightX: Int, topRightY: Int) {
        bottomLeftX = 0
        bottomLeftY = 0
        this.topRightX = topRightX
        this.topRightY = topRightY
    }

    constructor() {
        bottomLeftX = 0
        bottomLeftY = 0
    }

}