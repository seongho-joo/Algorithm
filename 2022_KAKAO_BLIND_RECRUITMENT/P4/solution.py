import copy

maxScoreDiff = 0
answer = []


def calc_score_diff(ryans, apeachs):
    ryan = 0
    apeach = 0

    for i in range(11):
        if (ryans[i], apeachs[i]) == (0, 0):
            continue
        if ryans[i] > apeachs[i]:
            ryan += 10 - i
        else:
            apeach += 10 - i

    return ryan - apeach


def dfs(info, shots, n, i):
    global maxScoreDiff, answer
    if i == 11:
        if n != 0:
            shots[10] = n
        score_diff = calc_score_diff(shots, info)
        if score_diff <= 0:
            return
        res = copy.deepcopy(shots)
        if maxScoreDiff < score_diff:
            maxScoreDiff = score_diff
            answer = [res]
            return
        if maxScoreDiff == score_diff:
            answer.append(res)
        return

    if info[i] < n:
        shots.append(info[i] + 1)
        dfs(info, shots, n - info[i] - 1, i + 1)
        shots.pop()

    shots.append(0)
    dfs(info, shots, n, i + 1)
    shots.pop()


def solution(n, info):
    global answer

    dfs(info, [], n, 0)

    if not answer:
        return [-1]

    answer.sort(key=lambda x: x[::-1], reverse=True)

    return answer[0]
