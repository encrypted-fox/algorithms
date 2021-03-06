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

fun selectionSort(array: Array<Int>, descendingOrder: Boolean = false): Array<Int> {
    for (i in 0..array.size - 1) {
        var m = i
        var j = i + 1
        if (descendingOrder) {
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

fun mergeSort(list: List<Int>): List<Int> {
    fun merge(left: List<Int>, right: List<Int>): List<Int> {
        var indexLeft = 0
        var indexRight = 0
        val newList: MutableList<Int> = mutableListOf()

        while (indexLeft < left.count() && indexRight < right.count()) {
            if (left[indexLeft] <= right[indexRight]) {
                newList.add(left[indexLeft])
                indexLeft++
            } else {
                newList.add(right[indexRight])
                indexRight++
            }
        }

        while (indexLeft < left.size) {
            newList.add(left[indexLeft])
            indexLeft++
        }

        while (indexRight < right.size) {
            newList.add(right[indexRight])
            indexRight++
        }

        return newList
    }

    if (list.size <= 1) {
        return list
    }

    val middle = list.size / 2
    val left = list.subList(0, middle)
    val right = list.subList(middle, list.size)

    return merge(mergeSort(left), mergeSort(right))
}

fun bubbleSort(array: Array<Int>, descendingOrder: Boolean = false): Array<Int> {
    for (i in 0..array.size - 2) {
        for (j in 0..(array.size - i - 2)) {
            if (descendingOrder) {
                if (array[j] < array[j + 1]) {
                    val buffer = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = buffer
                }
            } else {
                if (array[j] > array[j + 1]) {
                    val buffer = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = buffer
                }
            }
        }
    }
    return array
}

fun findMaxSubarray(array: Array<Int>): Int {
    var best_sum = 0
    var current_sum = 0

    for (element in array) {
        current_sum = maxOf(0, current_sum + element)
        best_sum = maxOf(best_sum, current_sum)
    }

    return best_sum
}

fun test() {
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

    val firstTestArray = arrayOf(5, 3, 4, 2, 1, 2, 3, 5, 2)
    val secondTestArray = arrayOf(1, 2, 4, 2, 2, 1, 5, 6, 6, 9)
    val firstTestList = mutableListOf(5, 3, 4, 2, 1, 2, 3, 5, 2)
    val secondTestList = mutableListOf(1, 2, 4, 2, 2, 1, 5, 6, 6, 9)
    val firstArrayForMaxSubarrTest = arrayOf(5, 3, -4, 2, 1, -2, 3, 5, 2)
    val secondArrayForMaxSubarrTest = arrayOf(1, 2, -4, 2, 2, -1, 5, 6, 6, 9)

    println("Testing insertion sort")
    println("______________________")
    println(customToString(insertionSort(firstTestArray, true)))
    println(customToString(insertionSort(secondTestArray)))
    println("______________________")

    println("Testing selection sort")
    println("______________________")
    println(customToString(selectionSort(firstTestArray, true)))
    println(customToString(selectionSort(secondTestArray)))
    println("______________________")

    println("Testing merge sort")
    println("______________________")
    println(mergeSort(firstTestList))
    println(mergeSort(secondTestList))
    println("______________________")

    println("Testing bubble sort")
    println("______________________")
    println(customToString(bubbleSort(firstTestArray, true)))
    println(customToString(bubbleSort(secondTestArray)))
    println("______________________")

    println("Testing find maximum subarray")
    println("______________________")
    println(findMaxSubarray(firstArrayForMaxSubarrTest))
    println(findMaxSubarray(secondArrayForMaxSubarrTest))
    println("______________________")
}

test()