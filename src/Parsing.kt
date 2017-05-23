import java.util.*

fun Parsing(list: List<String>): List<String> {
    var file =""
    var from = ""
    var to = ""

    val result = ArrayList<String>()
    var parts = list[list.size - 1].split(Regex("""\d+"""))   //разбиваем фром и ту, если цифры нет, по пустое
    if (parts.size == 3 && parts.get(0) == "" && parts.get(1) == "-" && parts.get(2) == "") {// если есть 2 цифры, то можем делать сплит по -
        parts = list[list.size.minus(1)].split(Regex("""-"""))
        from = parts.get(0)
        to = parts.get(1)
    }
    if (parts.size == 2 && parts.get(0) == "" && parts.get(1) == "-"){// если есть только начало диапазона
        parts = list[list.size.minus(1)].split(Regex("""-"""))
        from = parts.get(0)
        to = "-1"
    }
    if (list.size == 2) file = list.get(0) //если 2, то первый элемент точно название файла
    result.add(0, file) //формируем строчку
    result.add(1, from)
    result.add(2, to)

    return result
}
