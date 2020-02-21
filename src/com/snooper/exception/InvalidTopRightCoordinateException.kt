package com.snooper.exception

class InvalidTopRightCoordinateException : RuntimeException {
    constructor(coordinates: String) : super("Invalid top right co-ordinates $coordinates") {}
    internal constructor() : super() {}
}