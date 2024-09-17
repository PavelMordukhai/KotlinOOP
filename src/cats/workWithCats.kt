package cats

fun main() {

    val cat = Cat("Sam")
    println(cat.legsCount)
    println(cat.name)
    cat.playWithMouse()
    println()

    val lion = Lion(countInPride = 25)
    println(lion.countInPride)
    println(lion.legsCount)
}
