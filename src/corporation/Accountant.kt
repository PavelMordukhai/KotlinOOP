package corporation

import java.io.File

class Accountant(
    name: String,
    age: Int = 0,
) : Worker(name = name, age = age) {

//    val items = mutableListOf<ProductCard>()
    val file = File("product_cards.txt")

    override fun work() {
        val operationCodes = OperationCode.entries

        while (true) {
            print("Enter the operation code.")
            for ((index, code) in operationCodes.withIndex()) {
                print(" $index - ${code.title},")
            }
            print("\b: ")

            val operationIndex = readln().toInt()
            val operationCode = operationCodes[operationIndex]
            when (operationCode) {
                OperationCode.EXIT -> break
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
            }
        }
    }

    fun removeProductCard() {
        val cards = loadAllCards()
        print("Enter name of card of removing: ")
        val name = readln()

        for (card in cards) {
            if (card.name == name) {
                cards.remove(card)
                break
            }
        }
        file.writeText("")
        for (card in cards) {
            saveProductCardToFile(card)
        }
    }

    fun loadAllCards(): MutableList<ProductCard> {
        val cards = mutableListOf<ProductCard>()

        val content = file.readText().trim()
        val cardsAsString = content.split("\n")
        for (card in cardsAsString) {
            val properties = card.split("|")

            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()

            val type = properties.last()
            val productType = ProductType.valueOf(type)

            val productCard = when (productType) {
                ProductType.FOOD -> {
                    val caloric = properties[3].toInt()
                    FoodCard(name, brand, price, caloric)
                }

                ProductType.APPLIANCE -> {
                    val wattage = properties[3].toInt()
                    ApplianceCard(name, brand, price, wattage)
                }

                ProductType.SHOE -> {
                    val size = properties[3].toFloat()
                    ShoeCard(name, brand, price, size)
                }
            }
            cards.add(productCard)
        }
        return cards
    }

    fun showAllItems() {
        val cards = mutableListOf<ProductCard>()

        val content = file.readText().trim()
        val cardsAsString = content.split("\n")
        for (card in cardsAsString) {
            val properties = card.split("|")

            val name = properties[0]
            val brand = properties[1]
            val price = properties[2].toInt()

            val type = properties.last()
            val productType = ProductType.valueOf(type)

            val productCard = when (productType) {
                ProductType.FOOD -> {
                    val caloric = properties[3].toInt()
                    FoodCard(name, brand, price, caloric)
                }

                ProductType.APPLIANCE -> {
                    val wattage = properties[3].toInt()
                    ApplianceCard(name, brand, price, wattage)
                }

                ProductType.SHOE -> {
                    val size = properties[3].toFloat()
                    ShoeCard(name, brand, price, size)
                }
            }
            productCard.printInfo()
        }
    }

    fun saveProductCardToFile(productCard: ProductCard) {
        file.appendText("${productCard.name}|")
        file.appendText("${productCard.brand}|")
        file.appendText("${productCard.price}|")

        when (productCard) {
            is FoodCard -> {
                val caloric = productCard.caloric
                file.appendText("$caloric|${ProductType.FOOD}\n")
            }

            is ShoeCard -> {
                val size = productCard.size
                file.appendText("$size|${ProductType.SHOE}\n")
            }

            is ApplianceCard -> {
                val wattage = productCard.wattage
                file.appendText("$wattage|${ProductType.APPLIANCE}\n")
            }
        }
    }

    fun registerNewItem() {
        val productTypes = ProductType.entries

        print("Enter the product type.")
        for ((index, type) in productTypes.withIndex()) {
            print(" $index - ${type.title},")
        }
        print("\b: ")

        val productTypeIndex = readln().toInt()
        val productType: ProductType = productTypes[productTypeIndex]

        print("Enter the product name: ")
        val productName = readln()
        file.appendText("$productName|")

        print("Enter the product brand: ")
        val productBrand = readln()
        file.appendText("$productBrand|")

        print("Enter the product price: ")
        val productPrice = readln().toInt()
        file.appendText("$productPrice|")

        when (productType) {

            ProductType.FOOD -> {
                print("Enter the caloric: ")
                val caloric = readln().toInt()
                file.appendText("$caloric|")
            }

            ProductType.APPLIANCE -> {
                print("Enter the wattage: ")
                val wattage = readln().toInt()
                file.appendText("$wattage|")
            }

            ProductType.SHOE -> {
                print("Enter the size: ")
                val size = readln().toFloat()
                file.appendText("$size|")
            }
        }

        file.appendText("$productType\n")
    }
}
