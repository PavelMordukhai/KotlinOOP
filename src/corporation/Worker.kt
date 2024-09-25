package corporation

open class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val position: Position
) {

    open fun work() {
        println("I'm working now...")
    }

    fun printInfo() {
        println("ID: $id Name: $name Age: $age Position: $position")
    }
}
