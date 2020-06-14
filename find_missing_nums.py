class Solution(object):
    def find_missing_nums(arr, start, end):

        current = start
        for i in range(len(arr)):
            if current < end:
                if arr[i] == current:
                    current += 1
                elif arr[i] > current:
                    print(current, end="")
                    if arr[i] - current > 1:
                        print("-", min(arr[i] - 1, end), end="", sep="")
                    current = arr[i] + 1
                    if current < end:
                        print(",", end=" ")

        if current < end:
            print(current, end="")
            if end - current >= 1:
                print("-", end, end="", sep="")
        print()

    arr = [1,3,5,7,8,9,13]
    find_missing_nums(arr, 5, 12)
    find_missing_nums(arr, 1, 5)
    find_missing_nums(arr, 10, 13)

    arr = [-5,-2,1,3,5,7,8,9,13]
    find_missing_nums(arr, 5, 15)
    find_missing_nums(arr, -6, 5)
    find_missing_nums(arr, 10, 12)
    find_missing_nums(arr, 4, 15)
