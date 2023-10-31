def get_divisor_cnt():
    divisor = [0 for _ in range(100001)]

    for n in range(1, 100001):
        for i in range(1, int(n ** (1 / 2)) + 1):
            if n % i == 0:
                divisor[n] += 1
                if i != n // i:
                    divisor[n] += 1
    return divisor


def solution(number, limit, power):
    measures = get_divisor_cnt()
    return sum(power if m > limit else m for m in measures[1:number + 1])
