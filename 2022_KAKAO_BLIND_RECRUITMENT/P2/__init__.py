def convert(num, base):
    if base == 10:
        return str(num)

    code = "0123456789"
    ret = ''

    while True:
        if num < base:
            ret += str(code[num])
            break
        num, mod = divmod(num, base)
        ret += code[mod]

    return ret[::-1]


def isPrimeNumber(n):
    if n == 1:
        return False

    size = int(n ** 0.5)
    for i in range(2, size + 1):
        if n % i == 0:
            return False
    return True


def solution(n, k):
    answer = 0

    split = convert(n, k).split('0')

    for num in split:
        if num == '':
            continue
        if isPrimeNumber(int(num)):
            answer += 1

    return answer
