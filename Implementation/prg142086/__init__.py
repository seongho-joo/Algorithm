def solution(s):
    answer = []
    dic = {}
    for i, ch in enumerate(s):
        if ch not in dic:
            answer.append(-1)
        else:
            answer.append(i - dic[ch])
        dic[ch] = i

    return answer
