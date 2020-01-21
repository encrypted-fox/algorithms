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

function mergeSort(array, descending_order = false) {
    if (array.length > 1) {
        let mid = array.length / 2;
        let left_array = array.slice(0, mid);
        let right_array = array.slice(mid);

        mergeSort(left_array);
        mergeSort(right_array);

        let i = 0;
        let j = 0;
        let k = 0;

        while (i < left_array.length && j < right_array.length) {
            if (left_array[i] < right_array[j]) {
                array[k] = left_array[i];
                i += 1;
            } else {
                array[k] = right_array[j];
                j += 1;
            }
            k += 1;
        }

        while (i < left_array.length) {
            array[k] = left_array[i];
            i += 1;
            k += 1;
        }

        while (j < right_array.length) {
            array[k] = right_array[j];
            j += 1;
            k += 1;
        }
    }
    if (descending_order) {
        return array.reverse();
    } else {
        return array
    }
}

console.log("Testing insertion sort");
console.log("______________________");
console.log(insertionSort([5, 3, 4, 2, 1, 2, 3, 5, 2], true));
console.log(insertionSort([1, 2, 4, 2, 2, 1, 5, 6, 6, 9]));
console.log(insertionSort(["a", "b", "d", "a", "h", "a"]));
console.log(insertionSort(["a", "b", "d", "a", "h", "a"], true));
console.log("______________________");

console.log("Testing selection sort");
console.log("______________________");
console.log(selectionSort([5, 3, 4, 2, 1, 2, 3, 5, 2], true));
console.log(selectionSort([1, 2, 4, 2, 2, 1, 5, 6, 6, 9]));
console.log(selectionSort(["a", "b", "d", "a", "h", "a"]));
console.log(selectionSort(["a", "b", "d", "a", "h", "a"]), true);
console.log("______________________");

console.log("Testing merge sort");
console.log("______________________");
console.log(mergeSort([5, 3, 4, 2, 1, 2, 3, 5, 2], true));
console.log(mergeSort([1, 2, 4, 2, 2, 1, 5, 6, 6, 9]));
console.log(mergeSort(["a", "b", "d", "a", "h", "a"]));
console.log(mergeSort(["a", "b", "d", "a", "h", "a"], true));
console.log("______________________");
