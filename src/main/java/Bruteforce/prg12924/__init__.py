def recursion(n, i, num):
    if n == num:
        return True

    if n > num:
        return False
    n += i

    return recursion(n, i + 1, num)


def solution(n):
    answer = 0

    for i in range(1,  n + 1):
        if recursion(i, i + 1, n):
            answer += 1

    return answer


print(solution(15))
