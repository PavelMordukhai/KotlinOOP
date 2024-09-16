class ProductCard {

    var name : String = ""
    var brand : String = ""
    var size : Float = 0f
    var price : Int = 0

    fun printInfo() {
        println("Name: ${this.name}\nBrand: ${this.brand}" +
                "\nSize: ${this.size}\nPrice: ${this.price}")
    }
}
