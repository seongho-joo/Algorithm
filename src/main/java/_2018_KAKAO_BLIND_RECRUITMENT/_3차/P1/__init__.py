def convert(num, base):
    code = "0123456789ABCDEF"
    ret = ''

    while True:
        if num < base:
            ret += str(code[num])
            break
        num, mod = divmod(num, base)
        ret += code[mod]

    return ret[::-1]


def solution(n, t, m, p):
    answer = ''
    game = ''

    for i in range(m * t):
        game += convert(i, n)

    while not len(answer) == t:
        answer += game[p - 1]
        p += m

    return answer
