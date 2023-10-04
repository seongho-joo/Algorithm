def solution(cards1, cards2, goal):
    answer = []

    for i in range(len(goal)):
        if len(cards1) > 0 and cards1[0] == goal[i]:
            answer.append(cards1.pop(0))
        elif len(cards2) > 0 and cards2[0] == goal[i]:
            answer.append(cards2.pop(0))

        if goal == answer:
            return 'Yes'

    return 'No'
