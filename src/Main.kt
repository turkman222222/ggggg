import kotlin.random.Random

fun main() {
    val options = listOf("Камень", "Ножницы", "Бумага")
    var start = true;
    while (start) {
        val a = geta(options)
        val b = getb(options)

        println("Компьютер выбрал: ${options[b]}")
        println("Вы выбрали: ${options[a]}")

        start = Winner(a, b)
    }
}

fun geta(options: List<String>): Int{
    while (true) {
        println("Выберите: 1 - Камень, 2 - Ножницы, 3 - Бумага")
        val c = readLine()

        when (c) {
            "1" -> return 0
            "2" -> return 1
            "3" -> return 2
            else -> println("Неверный ввод. Пожалуйста, выберите 1, 2 или 3.")
        }
    }
}

fun getb(options: List<String>): Int {
    return Random.nextInt(0, options.size)
}

fun Winner(a: Int, b: Int): Boolean {
    return when {
        a == b -> {
            println("Ничья! Переиграем.")
            true
        }
        (a == 0 && b == 1) ||
                (a == 1 && b == 2) ||
                (a == 2 && b == 0) -> {
            println("Вы победили!")
            false
        }
        else -> {
            println("Компь     ютер победил!")
            false
        }
    }
}
