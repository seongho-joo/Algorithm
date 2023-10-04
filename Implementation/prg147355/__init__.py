def solution(t, p):
    answer = 0

    index = len(p)
    for i in range(len(t) - index + 1):
        if t[i:i + index] <= p:
            answer += 1

    return answer
