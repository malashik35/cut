//если ц
fun forChar(from: Int, to: Int, line: String): String{
    val result = StringBuilder()

    if (line.length < from) return ""
    else {
        if (to == -1){
            (from..line.length).forEach { i -> result.append(line[i - 1]) }
        }
        else (from..Math.min(to, line.length)).forEach { i -> result.append(line[i - 1]) }
    }
    return result.toString()
}
//если в
fun forWord(from: Int, to: Int, line: String): String{
    val result = StringBuilder()
    val parts = line.split(Regex("""\s+"""))

    if (from > parts.size) return ""
    else {
        if(to == -1){
            (from..parts.size).forEach { i -> result.append(parts[i - 1] + " ") }
        }
        else (from..Math.min(to, parts.size)).forEach { i -> result.append(parts[i - 1] + " ") }
    }
    result.deleteCharAt(result.length - 1) //удаляем последний пробел из цикла
    return result.toString()
}