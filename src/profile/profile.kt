package profile

fun main() {

    val person1 = Person("qwe", "ads", 180, 80)
    val person2 = Person("qwe", "ads", 180, 80)
    val person3 = person1.copy(name = "vbn")

    val people = setOf(person1, person2, person3)

    for (person in people) {
        println(person)
    }
}
