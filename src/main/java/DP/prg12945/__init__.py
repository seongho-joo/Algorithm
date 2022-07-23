MOD = 1234567


def solution(n):
    global MOD

    fibo = [0] * (n + 1)
    fibo[1] = 1

    for i in range(2, n + 1):
        fibo[i] = (fibo[i - 2] + fibo[i - 1]) % MOD

    return fibo[n]
