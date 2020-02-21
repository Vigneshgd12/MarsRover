package com.snooper.exception

class InvalidRoverPositionException : RuntimeException {
    constructor(position: String) : super("Invalid Rover Position $position") {}
    internal constructor() : super() {}
}