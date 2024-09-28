package corporation

import java.io.File

object ProductCardsRepository {

    private val fileProductCards = File("product_cards.txt")
    private val _productCards = loadAllCards()
    val productCards
        get() = _productCards.toList()

    fun saveChanges() {
        val content = StringBuilder()
        for (productCard in _productCards) {
            content.append("${productCard.name}|${productCard.brand}|${productCard.price}|")

            when (productCard) {
                is FoodCard -> content.append("${productCard.caloric}|")
                is ShoeCard -> content.append("${productCard.size}|")
                is ApplianceCard -> content.append("${productCard.wattage}|")
            }
            content.append("${productCard.productType}\n")
        }
        fileProductCards.writeText(content.toString())
    }

    fun registerNewItem(productCard: ProductCard) {
        _productCards.add(productCard)
    }

    private fun loadAllCards(): MutableList<ProductCard> {
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
        for (card in _productCards) {
            if (card.name == name) {
                _productCards.remove(card)
                break
            }
        }
    }
}
