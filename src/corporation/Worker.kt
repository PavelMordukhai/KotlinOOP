package corporation

abstract class Worker(
    open val id: Int,
    open val name: String,
    open val age: Int = 0,
    open val salary: Int = 15000,
    val position: Position
) {

    abstract fun copy(
        id: Int = this.id,
        name: String = this.name,
        salary: Int = this.salary,
        age: Int = this.age,
        position: Position = this.position
    ): Worker

    abstract fun work()

    fun printInfo() {
        println(this)
    }
}
