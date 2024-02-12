"""
ex)
A > B = 5
B > A = 3
-> B가 A에게 줘야함

선물 지수 -> 받은 선물 - 준 선물
    0   1   2   3
0   -   0   2   0
1   3   -   0   0
2   1   1   -   0
3   1   0   0   -

muzi : 2, 5, -3
frodo : 2, 2, 0
ryan : 3, 1, 2
neo : 1, 0, 1

checked[b][a], checked[a][b] == False ?
-> gift_table[b][a] < gift_table[a][b] ? a += 1
-> gift_table[b][a] > gift_table[a][b] ? b += 1
-> indices[a] > indices[b] ? a += 1
-> indices[a] < indices[b] ? b += 1

muzi <- frodo
ryan <- muzi, neo(지수가 더 높음)
frodo <- ryan
neo <- muzi, frodo
"""


def solution(friends, gifts):
    l = len(friends)

    name_to_idx = {n: i for i, n in enumerate(friends)}
    gift_table = [[0 for j in range(l)] for i in range(l)]
    checked = [[False for _ in range(l)] for _ in range(l)]

    indices = [0] * l
    gift_counts = [0] * l

    for a_to_b in gifts:
        a, b = map(name_to_idx.get, a_to_b.split(' '))

        gift_table[a][b] += 1
        indices[a] += 1
        indices[b] -= 1

    for i in range(l):
        for j in range(l):
            if i != j and not checked[i][j]:
                checked[i][j] = True
                checked[j][i] = True

                if gift_table[i][j] > gift_table[j][i]:
                    gift_counts[i] += 1
                elif gift_table[i][j] < gift_table[j][i]:
                    gift_counts[j] += 1
                elif indices[i] > indices[j]:
                    gift_counts[i] += 1
                elif indices[j] > indices[i]:
                    gift_counts[j] += 1

    return max(gift_counts)


print(solution(["muzi", "ryan", "frodo", "neo"],
               ["muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan",
                "neo muzi"]))
