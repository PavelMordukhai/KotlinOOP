class Rectangle(
    val width: Int,
    val height: Int
) {
    constructor(size: Int): this(size, size)

    constructor(): this(1)

    fun draw() {
        repeat(height) {
            repeat(width) {
                print(" * ")
            }
            println()
        }
    }
}
