def solution(keymap, targets):
    answer = []

    for target in targets:
        count = 0
        for t in target:
            flag = False
            min_value = 987654321
            for i in range(len(keymap)):
                if t in keymap[i]:
                    flag = True
                    min_value = min(min_value, keymap[i].index(t))
            if not flag:
                count = -1
                break
            count += min_value + 1

        answer.append(count)

    return answer
