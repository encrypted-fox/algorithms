fun insertionSort(array: Array<Int>, descendingOrder: Boolean = false): Array<Int> {
    for (i in 1..array.size - 1) {
        val key = array[i]
        var j = i - 1
        if (descendingOrder) {
            while (j >= 0 && array[j] < key) {
                array[j + 1] = array[j]
                j = j - 1
            }
            array[j + 1] = key
        } else {
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j]
                j = j - 1
            }
            array[j + 1] = key
        }
    }

    return array
}

fun customToString(array: Array<Int>): String {
    var string = ""
    for (i in array) {
        if (string == "") {
            string += i
        } else {
            string += ", " + i
        }
    }
    return string
}

var array = arrayOf(5, 3, 4, 2, 1, 2, 3, 5, 2)

println(customToString(insertionSort(array)))