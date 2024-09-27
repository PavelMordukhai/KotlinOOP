package gui

fun main() {

    val rectangle1 = Rectangle(8, 5)
    rectangle1.draw()
    println(rectangle1.area)
    rectangle1.height = 9
    println(rectangle1.area)
    println()

    val rectangle2 = Rectangle(4)
    rectangle2.draw()
    println(rectangle2.area)
    println()

    val rectangle3 = Rectangle()
    rectangle3.draw()
    println(rectangle3.area)
    println()
}
