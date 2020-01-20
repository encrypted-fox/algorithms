function insertionSort(array, descendingOrder = false) {
    for (let i = 1; i < array.length; i++) {
        let key = array[i];
        let j = i - 1;
        if (descendingOrder) {
            while (j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j = j - 1
            }
            array[j + 1] = key
        } else {
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1
            }
            array[j + 1] = key
        }
    }

    return array;
}

function selectionSort(array, descendingOrder = false) {
    for (let i = 0; i < array.length - 1; i++) {
        let m = i;
        let j = i + 1;
        if (descendingOrder) {
            while (j < array.length) {
                if (array[j] > array[m]) {
                    m = j
                }
                j = j + 1
            }
        } else {
            while (j < array.length) {
                if (array[j] < array[m]) {
                    m = j
                }
                j = j + 1
            }
        }
        let buffer = array[i];
        array[i] = array[m];
        array[m] = buffer;
    }
    return array;
}

console.log("Testing insertion sort");
console.log("______________________");
console.log(insertionSort([5, 3, 4, 2, 1, 2, 3, 5, 2], true));
console.log(insertionSort([1, 2, 4, 2, 2, 1, 5, 6, 6, 9]));
console.log(insertionSort(["a", "b", "d", "a", "h", "a"]));
console.log("______________________");

console.log("Testing selection sort");
console.log("______________________");
console.log(selectionSort([5, 3, 4, 2, 1, 2, 3, 5, 2], true));
console.log(selectionSort([1, 2, 4, 2, 2, 1, 5, 6, 6, 9]));
console.log(selectionSort(["a", "b", "d", "a", "h", "a"]));
console.log("______________________");
