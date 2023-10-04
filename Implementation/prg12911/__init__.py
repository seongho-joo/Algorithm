def solution(n):
    count = bin(n).count('1')

    i = n + 1
    while True:
        if count == bin(i).count('1'):
            return i
        i += 1


print(solution(78))
