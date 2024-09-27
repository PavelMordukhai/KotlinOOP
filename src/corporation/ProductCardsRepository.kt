package corporation

import java.io.File

class ProductCardsRepository {

    private val fileProductCards = File("product_cards.txt")

    private fun saveProductCardToFile(productCard: ProductCard) {
        fileProductCards.appendText("${productCard.name}|${productCard.brand}|${productCard.price}|")

        when (productCard) {
            is FoodCard -> fileProductCards.appendText("${productCard.caloric}|")
            is ShoeCard -> fileProductCards.appendText("${productCard.size}|")
            is ApplianceCard -> fileProductCards.appendText("${productCard.wattage}|")
        }
        fileProductCards.appendText("${productCard.productType}\n")
    }

    fun registerNewItem(productCard: ProductCard) {
        saveProductCardToFile(productCard)
    }

    fun loadAllCards(): MutableList<ProductCard> {
        val cards = mutableListOf<ProductCard>()

        if (!fileProductCards.exists()) fileProductCards.createNewFile()
        val content = fileProductCards.readText().trim()
        if (content.isEmpty()) return cards

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

    fun removeProductCard(name: String) {
        val cards = loadAllCards()
        for (card in cards)
            if (card.name == name) {
                cards.remove(card)
                break
            }
        fileProductCards.writeText("")
        for (card in cards)
            saveProductCardToFile(card)
    }
}
