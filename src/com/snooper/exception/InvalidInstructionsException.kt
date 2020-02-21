package com.snooper.exception

class InvalidInstructionsException : RuntimeException {
    constructor(instructions: String) : super("Invalid instructions $instructions") {}
    internal constructor() : super() {}
}