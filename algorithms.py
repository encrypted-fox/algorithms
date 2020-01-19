def insertion_sort(array, descending_order=False):
    for i in range(1, len(array)):
        key = array[i]
        j = i - 1
        if descending_order:
            while j >= 0 and array[j] < key:
                array[j + 1] = array[j]
                j = j - 1
            array[j + 1] = key
        else:
            while j >= 0 and array[j] > key:
                array[j + 1] = array[j]
                j = j - 1
            array[j + 1] = key
    return array


print(insertion_sort([5, 3, 4, 2, 1, 2, 3, 5, 2], True))
print(insertion_sort([1, 2, 4, 2, 2, 1, 5, 6, 6, 9]))
print(insertion_sort(["a", "b", "d", "a", "h", "a"]))
