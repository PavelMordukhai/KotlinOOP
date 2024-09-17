package corporation

open class Worker(
    val name: String,
    val age: Int = 0,
) {

    fun work() {
        println("I'm working now...")
    }
}

