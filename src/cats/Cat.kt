package cats

class Cat(
    val name: String,
) : CatsFamily() {

    override fun eat() {
        println("I'm eating whiskas")
    }

    fun playWithMouse() {
        println("I'm playing with mouse")
    }
}
