import java.io.Console
import kotlin.math.cbrt
import kotlin.math.roundToInt

fun main() {
    var com: Int = 1
    while (com != 0) {
        println()
        println("Задача 1.\n" +
                "Создать программу, выполняющую следующий функционал:\n" +
                "- запрашивается количество строк и столбцов для двумерного массива\n" +
                "- вводится необходимое количество трехзначных чисел (числа могут повторяться)\n" +
                "- подсчитывается количество различных цифр в полученном массиве\n" +
                "- на консоль выводится двумерный массив из введенных чисел и количество различных цифр используемых в данном массиве\n\n"+

                "Задача 2.\n" +
                "Имеется массив целых чисел из 5-и строк и 5-и столбцов. Выяснить, симметричен ли он относительно главной диагонали.\n" +
                "То есть - элемент 1,2 равен элементу 2,1. Элемент 1,3 равен элементу 3,1 и т.д. \n\n" +

                "Задача 3.\n" +
                "Имеется массив из символов русского алфавита (все 33 символа, могут быть не по порядку). Символы алфавита\n" +
                "нумеруются от 1 до 33. Каждое число используется только один раз.  Сообщение шифруется с помощью ключевого слова,\n" +
                "задаваемого пользователем. Номер символа ключевого слова показывает, на сколько нужно сдвинуться по массиву из\n" +
                "символов русского алфавита. Составить программу шифровки и дешифровки строкового выражения (то есть программа\n" +
                "спрашивает - зашифровать или расшифровать текст и ключевое слово). Первый массив считать закольцованным. Регистр букв не имеет значения. \n\n" +

                "Задача 4.\n" +
                "Создать приложение, в котором пользователь дает на вход два числовых массива, числа в массиве могут повторяться.\n" +
                "На выходе приложение выдает пересечение этих массивов.\n\n" +

                "Задача 5.\n" +
                "Создать приложение, в котором пользователь вводит массив из различных слов. На выходе приложение должно показать" +
                "слова сгруппированные по признаку \"состоят из одинаковых букв\".\n")
        println("Введите номер задания(1-5):")
        com = checkCom(1,5)
        when (com) {
            1 -> {
                task1()
            }

            2 -> {
                task2()
            }

            3 -> {
                task3()
            }

            4 -> {
                task4()
            }

            5 -> {
                task5()
            }
        }
    }
}

fun  checkCom( first:Int,second:Int): Int{
    var numString = readln();
    var num=0
    var flagStr = false
    var flag3 = false
    while (!flagStr && !flag3) {
        if (numString.toIntOrNull() != null) {
            num = numString.toInt()
            flagStr = true
            if (num > second || num < first) {
                println("Введите корректное значение")
                numString = readln()
                flagStr = false
                flag3 = false
            }
            else
                flag3=true
        } else {
            println("Введите корректное значение")
            numString = readln()
            flagStr = false
            flag3 = false
        }
    }
    return num
}

/*
fun  checkCom(): Int{
    var numString = readln();
    var num=0
    var flagStr = false
    var flag3 = false
    while (!flagStr && !flag3) {
        if (numString.toIntOrNull() != null) {
            num = numString.toInt()
            flagStr = true
            if (num > 2 || num < 1) {
                println("Введите корректное значение")
                numString = readln()
                flagStr = false
                flag3 = false
            }
            else
                flag3=true
        } else {
            println("Введите корректное значение")
            numString = readln()
            flagStr = false
            flag3 = false
        }
    }
    return num
}
 */

fun task1(){
    println("запрашивается количество строк и столбцов для двумерного массива\n" +
            "- вводится необходимое количество трехзначных чисел (числа могут повторяться)\n" +
            "- подсчитывается количество различных цифр в полученном массиве\n" +
            "- на консоль выводится двумерный массив из введенных чисел и количество различных цифр используемых в данном массиве\n");
    println("Введите количество строк: ")
    var rowsString = readln()

    while (rowsString.toIntOrNull() == null)
    {
        println("Введите корректное значение")
        rowsString = readln()
    }
    var rows = rowsString.toInt()
    println("Введите количество столбцов: ")


    var colsString = readln()
    while (colsString.toIntOrNull() == null)
    {
        println("Введите корректное значение")
        colsString = readln()
    }
    var cols = colsString.toInt()


    println("Как заполнить массив(1 - рандомно, 2 - с клавиатуры):")
    var com = checkCom(1,2)


    val matrix = Array(rows){ IntArray(cols) }
    println();
    when (com){
        1 -> {
            for (i in 0 until  rows)
                for (j in 0 until cols)
                    matrix[i][j] = (100..999).random()
        }
        2 -> {
            for (i in 0 until rows)
                for (j in 0 until cols) {
                    println("Введите [$i][$j] элемент: ")
                    var check = checkCom(100, 999)
                    matrix[i][j] = check

                }
        }
    }
    var uniq = ""
    for (i in 0 until  rows)
    {
        for (j in 0 until cols)
        {
            print(matrix[i][j].toString() + "\t");
            uniq+=matrix[i][j]
        }
        println();
    }

    var uniqSet = uniq.toCharArray().toSet();
    println("В массиве использовано ${uniqSet.size} различных цифр")
    println("\n\nдля продолжениея нажмите Enter")
    readln()
}

fun task2() {
    println("Имеется массив целых чисел из 5-и строк и 5-и столбцов. Выяснить, симметричен ли он относительно главной диагонали.\n" +
            "То есть - элемент 1,2 равен элементу 2,1. Элемент 1,3 равен элементу 3,1 и т.д.");
    val matrix: Array<Array<Int>> = arrayOf(
        arrayOf(5, 9, 6, 7, 2),
        arrayOf(9, 8, 4, 5, 3),
        arrayOf(6, 4, 3 ,8, 7),
        arrayOf(7, 5, 8, 4, 8),
        arrayOf(2, 3, 7, 8, 1)
    )
    println("Как заполнить массив(1 - рандомно, 2 - с клавиатуры, 3 - заготовленный симитричный массив):")
    var com = checkCom(1,3)
    when (com){
        1 -> {
            for (i in 0 until  5)
                for (j in 0 until 5)
                    matrix[i][j] = (0..255).random()
        }
        2 -> {
            for (i in 0 until  5)
                for (j in 0 until 5)
                {
                    println("Введите [$i][$j] элемент: ")
                    matrix[i][j] = readln().toInt()
                }
        }
        else -> {

        }

    }

    for (i in 0 until  5)
    {
        for (j in 0 until 5)
        {
            print(matrix[i][j].toString() + "\t");
        }
        println();
    }


    var flag = true;
    for (i in 0 until 5)
    {
        for (j in 0 until 5)
        {
            if (matrix[i][j] != matrix[j][i])
            {
                flag = false
                break
            }
        }
    }
    if (flag)
        println("\nМассив является симметричным относительно главной диагонали")
    else
        println("Массив не является симметричным относительно главной диагонали")
    println("\n\nдля продолжениея нажмите Enter")
    readln()
}


fun task3() {

    val letterToNumber = mapOf(
        'А' to 21, 'Б' to 13, 'В' to 4, 'Г' to 20,
        'Д' to 22, 'Е' to 1, 'Ё' to 25, 'Ж' to 12,
        'З' to 24, 'И' to 14, 'Й' to 2, 'К' to 28,
        'Л' to 9, 'М' to 23, 'Н' to 3, 'О' to 29,
        'П' to 6, 'Р' to 16, 'С' to 15, 'Т' to 11,
        'У' to 26, 'Ф' to 5, 'Х' to 30, 'Ц' to 27,
        'Ч' to 8, 'Ш' to 18, 'Щ' to 10, 'Ь' to 33,
        'Ы' to 31, 'Ъ' to 32, 'Э' to 19, 'Ю' to 7,
        'Я' to 17
    )

    println("Что вы хотите сделать(1 - зашифровать слово; 2 - расшифровать слово):")
    var com: Int = checkCom(1,2)

    println("Введите ключевое слово: ")
    var keyWord = readln().uppercase().toCharArray()

    println("Введите слово, которое хотите (за)расшифровать: ")
    var word = readln().uppercase().toCharArray()
    var keyWordArr = CharArray(word.size)
    var counter = 0
    var result = ""

    for (i in 0 until word.size) {
        keyWordArr[i] = keyWord[counter]
        counter++
        if (counter == keyWord.size) {
            counter = 0
        }
    }


    when (com) {
        1 -> {

            for (i in 0 until word.size) {
                var resWordKey = letterToNumber.get(word[i])?.plus(letterToNumber.get(keyWordArr[i]) ?: 0)
                if (resWordKey != null && resWordKey > 33)
                    resWordKey = resWordKey?.minus(33)
                result += letterToNumber.entries.find { it.value == resWordKey }?.key ?: '?'
            }

            println("Зашифрованное слово: $result \n\n")


        }

        2 -> {

            for (i in 0 until word.size) {
                var resWordKey = letterToNumber.get(word[i])?.minus(letterToNumber.get(keyWordArr[i]) ?: 0)
                if (resWordKey != null && resWordKey < 1)
                    resWordKey = resWordKey?.plus(33)
                result += letterToNumber.entries.find { it.value == resWordKey }?.key ?: '?'
            }

            println("Зашифрованное слово: $result \n\n")


        }

    }
    println("\n\nдля продолжениея нажмите Enter")
    readln()
}


fun task4(){

    println("пользователь дает на вход два числовых массива, числа в массиве могут повторяться.\n" +
            "На выходе приложение выдает пересечение этих массивов. Например, на входе [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2, 2]. \n" +
            "На выходе должны получить [1, 2, 2, 3]. То есть учитывается количество повторений чисел в массиве. Число 2 в одном массиве повторялось два раза, в другом - три. \n" +
            "Значит в итоговом массиве число два должно быть два раза\n")

    println("Введите массив 1 посимвольно через пробел:")

    val list1 = readln().trim().split(" ").map { it.toInt() }.toMutableList()
    println("Введите массив 2 посимвольно через пробел:")
    val list2 = readln().trim().split(" ").map { it.toInt() }.toMutableList()

    var res = mutableListOf<Int>()

    for (i in 0 until list1.size)
    {
        for (j in 0 until list2.size)
        {
            if (list1[i] == list2[j])
            {
                res.add(list1[i])
                list2.removeAt(j)
                break
            }
        }
    }

    println("результат = $res")
    println("\n\nдля продолжениея нажмите Enter")
    readln()
}

fun task5(){

    println("пользователь вводит массив из различных слов. На выходе приложение должно показать слова сгруппированные по признаку \"состоят из одинаковых букв\".\n" +
            "Например, на входе [\"eat\", \"tea\", \"tan\", \"ate\", \"nat\", \"bat\"].\n" +
            "Получаем группы:\n" +
            "\"ate\", \"eat\", \"tea\"\n" +
            "\"nat\", \"tan\"\n" +
            "\"bat\" \n")
    println("Введите массив слов через пробел")
    val list = readln().trim().split(" ").map { it.toString() }.toMutableList()

    val groups = list.groupBy { list -> list.lowercase().toCharArray().sorted().joinToString ("") }
    println("Результат:")
    for ((key, group) in groups)
    {
        println("${group.joinToString(", ")}")

    }

    println("\n\nдля продолжениея нажмите Enter")
    readln()
}
