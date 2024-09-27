package gui

class Rectangle(
    var width: Int = 0,
    var height: Int = 0,
) {

    val area
        get() = width * height

    constructor(size: Int): this(size, size)

    fun draw() {
        repeat(height) {
            repeat(width) {
                print(" * ")
            }
            println()
        }
    }
}
