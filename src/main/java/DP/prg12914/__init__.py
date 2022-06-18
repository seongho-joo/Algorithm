MOD = 1234567


def solution(n):
    a, b = 0, 1

    for _ in range(n):
        a, b = b, (a + b) % MOD

    return b
