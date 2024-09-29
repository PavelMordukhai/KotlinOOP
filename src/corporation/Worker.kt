package corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val salary: Int = 15000,
    val position: Position
) {

    abstract fun copy(salary: Int = this.salary, age: Int = this.age): Worker

    abstract fun work()

    override fun equals(other: Any?): Boolean {
        if (other !is Worker) return false
        return id == other.id
                && name == other.name
                && age == other.age
                && salary == other.salary
                && position == other.position
    }

    override fun toString(): String {
        return "ID: $id Name: $name Age: $age Position: $position Salary: $salary"
    }

    fun printInfo() {
        println(this)
    }
}
