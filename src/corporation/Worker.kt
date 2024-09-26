package corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val position: Position
) {

    private var salary: Int = 15000

    fun setSalary(salary: Int) {
        if (salary < this.salary)
            println("The new salary is to small...")
        else this.salary = salary
    }

    fun getSalary(): Int {
        return this.salary
    }

    abstract fun work()

    override fun toString(): String {
        return "ID: $id Name: $name Age: $age Position: $position Salary: $salary"
    }

    fun printInfo() {
        println(this)
    }
}
