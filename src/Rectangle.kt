class Rectangle {

    val width: Int
    val height: Int

    constructor(width: Int, height: Int) {
        this.width = width
        this.height = height
    }

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
