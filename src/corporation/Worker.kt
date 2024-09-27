package corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    private var salary: Int = 15000,
    val position: Position
) {

    fun getSalary(): Int = this.salary

    fun setSalary(salary: Int) {
        if (salary < this.salary)
            println("The new salary is to small...")
        else this.salary = salary
    }

    abstract fun work()

    override fun toString(): String {
        return "ID: $id Name: $name Age: $age Position: $position Salary: $salary"
    }

    fun printInfo() {
        println(this)
    }
}
