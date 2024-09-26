package corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val position: Position
) {

    var salary: Int = 15000
        set(value) {
            if (value < field)
                println("The new salary is to small...")
            else field = value
        }

    abstract fun work()

    override fun toString(): String {
        return "ID: $id Name: $name Age: $age Position: $position Salary: $salary"
    }

    fun printInfo() {
        println(this)
    }
}
