import kotlin.random.Random

class Monster {

    val pawsCount: Int
    val eyesCount: Int
    val fangsCount: Int
    val clawsCount: Int
    val tentaclesCount: Int

    constructor(
        pawsCount: Int,
        eyesCount: Int,
        fangsCount: Int,
        clawsCount: Int,
        tentaclesCount: Int,
    ) {
        this.pawsCount = pawsCount
        this.eyesCount = eyesCount
        this.fangsCount = fangsCount
        this.clawsCount = clawsCount
        this.tentaclesCount = tentaclesCount
    }

    constructor(size: Int) : this(
        size,
        size,
        size,
        size,
        size
    )

    constructor() : this(Random.nextInt(1, 10))

    fun printInfo() {
        println(
            """
            Кол-во лап: $pawsCount
            Кол-во глаз: $eyesCount
            Кол-во клыков: $fangsCount
            Кол-во когтей: $clawsCount
            Кол-во щупалец: $tentaclesCount
        """.trimIndent()
        )
    }
}

fun main() {
    val d = readln().split(" ").map { it.toInt() }
    val monster = Monster(
        d[0],
        d[1],
        d[2],
        d[3],
        d[4]
    )
    monster.printInfo()
}
