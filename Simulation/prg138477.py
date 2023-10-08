"""
[0, 300, 40, 300, 20, 70, 150, 50, 500, 1000]
0 -> 0
300 0 -> 0
300 40 0 -> 0
300 300 40 0 -> 0
300 300 40 20 -> 20
300 300 70 40 -> 40
300 300 150 70 -> 70
300 300 150 70 -> 70
500 300 300 150 -> 150
1000 500 300 300 -> 300
"""


def solution(k, score):
    answer = []
    arr = []

    for s in score:
        if len(arr) == k:
            if arr[-1] < s:
                arr.pop()
                arr.append(s)
        else:
            arr.append(s)

        arr.sort(reverse=True)
        answer.append(arr[-1])

    return answer


solution(4, [0, 300, 40, 300, 20, 70, 150, 50, 500, 1000])
