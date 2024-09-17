class DeliveryObject(
    val length: Int,
    val width: Int,
    val height: Int,
    val weight: Double,
)

class Pack(
    val length: Int,
    val width: Int,
    val height: Int,
    val type: String = "Картонная коробка",
    val weight: Double,
)

class Cargo(
    val length: Int,
    val width: Int,
    val height: Int,
    val typePackaging: String,
    val netWeight: Double,
    val grossWeight: Double,
) {
    fun printInfo() {
        println(
            """
            Длина: $length
            Ширина: $width
            Высота: $height
            Тип упаковки: $typePackaging
            Вес нетто: $netWeight
            Вес брутто: $grossWeight
        """.trimIndent()
        )
    }
}

class Warehouse() {

    private fun getPack(deliveryObject: DeliveryObject): Pack {
        return Pack(
            length = deliveryObject.length + 1,
            width = deliveryObject.width + 1,
            height = deliveryObject.height + 1,
            weight = 0.3,
        )
    }

    fun packCargo(deliveryObject: DeliveryObject): Cargo {
        val pack = getPack(deliveryObject)
        return Cargo(
            length = pack.length,
            width = pack.width,
            height = pack.height,
            typePackaging = pack.type,
            netWeight = deliveryObject.weight,
            grossWeight = deliveryObject.weight + pack.weight
        )
    }
}


fun main() {

    val d = readln().split(" ")
    val deliveryObject = DeliveryObject(
        d[0].toInt(),
        d[1].toInt(),
        d[2].toInt(),
        d[3].toDouble()
    )
    val pack = Warehouse().packCargo(deliveryObject)

    pack.printInfo()
}
