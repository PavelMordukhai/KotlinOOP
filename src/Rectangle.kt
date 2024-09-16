class Rectangle {

    val width: Int
    val height: Int

    constructor(width: Int, height: Int) {
        this.width = width
        this.height = height
    }

    constructor(size: Int) {
        this.width = size
        this.height = size
    }

    constructor() {
        this.width = 1
        this.height = 1
    }

    fun draw() {
        repeat(height) {
            repeat(width) {
                print(" * ")
            }
            println()
        }
    }
}
