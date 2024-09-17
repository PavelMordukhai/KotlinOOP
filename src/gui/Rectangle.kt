package gui

class Rectangle(
    val width: Int = 1,
    val height: Int = 1,
) {
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
