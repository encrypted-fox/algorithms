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


def selection_sort(array, descending_order=False):
    for i in range(len(array) - 1):
        m = i
        j = i + 1
        if descending_order:
            while j < len(array):
                if array[j] > array[m]:
                    m = j
                j = j + 1
        else:
            while j < len(array):
                if array[j] < array[m]:
                    m = j
                j = j + 1
        array[i], array[m] = array[m], array[i]
    return array


def merge_sort(array, descending_order=False):
    if len(array) > 1:
        mid = len(array) // 2
        left_array = array[:mid]
        right_array = array[mid:]

        merge_sort(left_array)
        merge_sort(right_array)

        i = j = k = 0

        while i < len(left_array) and j < len(right_array):
            if left_array[i] < right_array[j]:
                array[k] = left_array[i]
                i += 1
            else:
                array[k] = right_array[j]
                j += 1
            k += 1

        while i < len(left_array):
            array[k] = left_array[i]
            i += 1
            k += 1

        while j < len(right_array):
            array[k] = right_array[j]
            j += 1
            k += 1
    if descending_order:
        return list(reversed(array))
    else:
        return array


def bubble_sort(array, descending_order=False):
    for i in range(len(array) - 1):
        for j in range(len(array) - i - 1):
            if descending_order:
                if array[j] < array[j + 1]:
                    array[j], array[j + 1] = array[j + 1], array[j]
            else:
                if array[j] > array[j + 1]:
                    array[j], array[j + 1] = array[j + 1], array[j]
    return array


def find_max_subarray(array):
    best_sum = 0
    best_start = best_end = 0
    current_sum = 0

    for current_end, x in enumerate(array):
        if current_sum <= 0:
            current_start = current_end
            current_sum = x
        else:
            current_sum += x

        if current_sum > best_sum:
            best_sum = current_sum
            best_start = current_start
            best_end = current_end + 1

    return best_sum, best_start, best_end


def test():
    print("Testing insertion sort")
    print("______________________")
    print(insertion_sort([5, 3, 4, 2, 1, 2, 3, 5, 2], True))
    print(insertion_sort([1, 2, 4, 2, 2, 1, 5, 6, 6, 9]))
    print(insertion_sort(["a", "b", "d", "a", "h", "a"]))
    print(insertion_sort(["a", "b", "d", "a", "h", "a"], True))
    print("______________________")

    print("Testing selection sort")
    print("______________________")
    print(selection_sort([5, 3, 4, 2, 1, 2, 3, 5, 2], True))
    print(selection_sort([1, 2, 4, 2, 2, 1, 5, 6, 6, 9]))
    print(selection_sort(["a", "b", "d", "a", "h", "a"]))
    print(selection_sort(["a", "b", "d", "a", "h", "a"], True))
    print("______________________")

    print("Testing merge sort")
    print("______________________")
    print(merge_sort([5, 3, 4, 2, 1, 2, 3, 5, 2], True))
    print(merge_sort([1, 2, 4, 2, 2, 1, 5, 6, 6, 9]))
    print(merge_sort(["a", "b", "d", "a", "h", "a"]))
    print(merge_sort(["a", "b", "d", "a", "h", "a"], True))
    print("______________________")

    print("Testing bubble sort")
    print("______________________")
    print(bubble_sort([5, 3, 4, 2, 1, 2, 3, 5, 2], True))
    print(bubble_sort([1, 2, 4, 2, 2, 1, 5, 6, 6, 9]))
    print(bubble_sort(["a", "b", "d", "a", "h", "a"]))
    print(bubble_sort(["a", "b", "d", "a", "h", "a"], True))
    print("______________________")

    print("Testing find maximum subarray")
    print("______________________")
    print(find_max_subarray([5, 3, -4, 2, 1, -2, 3, 5, 2]))
    print(find_max_subarray([1, 2, -4, 2, 2, -1, 5, 6, 6, 9]))
    print("______________________")


test()
