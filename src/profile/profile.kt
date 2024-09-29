package profile

fun main() {

    val person1 = Person("qwe", "ads", 180, 80)
    person1.age = 30
    val person2 = Person("qwe", "ads", 180, 80)
    person2.age = 35
    val person3 = person1.copy(name = "vbn")

    val people = setOf(person1, person2, person3)

    for (person in people) {
        println(person)
    }
}
