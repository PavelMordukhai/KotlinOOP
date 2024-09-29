package profile

class Person(
    val name: String,
    val lastName: String,
    val height: Int,
    val weight: Int
) {

    val fullName: String
        get() = "$name $lastName"

    var age: Int = 0
        set(value) {
            if (value > field)
                field = value
            else println("The new age must be bigger than the old one")
        }
        get() {
            println("It is indecent to ask a person his age")
            return field
        }

    fun printInfo() {
        println("Name: $name\nAge: $age\nHeight: $height\nWeight: $weight")
    }

    fun sayHello() {
        println("Hello! My name is $name")
    }

    fun run() {
        println("Running...")
    }

    fun copy(
        name: String = this.name,
        lastName: String = this.lastName,
        height: Int = this.height,
        weight: Int = this.weight,
    ) = Person(name, lastName, height, weight)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Person) return false

        if (name != other.name) return false
        if (lastName != other.lastName) return false
        if (height != other.height) return false
        if (weight != other.weight) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + height
        result = 31 * result + weight
        return result
    }

    override fun toString(): String {
        return "Person(name='$name', lastName='$lastName', height=$height, weight=$weight, fullName='$fullName', age=$age)"
    }
}
