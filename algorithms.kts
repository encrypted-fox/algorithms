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

fun selectionSort(array: Array<Int>, descending_order: Boolean = false): Array<Int> {
    for (i in 0..array.size - 1) {
        var m = i
        var j = i + 1
        if (descending_order) {
            while (j < array.size) {
                if (array[j] > array[m]) {
                    m = j
                }
                j = j + 1
            }
        } else {
            while (j < array.size) {
                if (array[j] < array[m]) {
                    m = j
                }
                j = j + 1
            }
        }
        val buffer = array[i]
        array[i] = array[m]
        array[m] = buffer
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

var firstTestArray = arrayOf(5, 3, 4, 2, 1, 2, 3, 5, 2)
var secondTestArray = arrayOf(1, 2, 4, 2, 2, 1, 5, 6, 6, 9)

println("Testing insertion sort")
println("______________________")
println(customToString(insertionSort(firstTestArray, true)))
println(customToString(insertionSort(firstTestArray)))
println("______________________")

println("Testing selection sort")
println("______________________")
println(customToString(selectionSort(firstTestArray, true)))
println(customToString(selectionSort(firstTestArray)))
println("______________________")
