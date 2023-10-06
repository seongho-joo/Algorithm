def solution(s):
    answer = 0
    word = ''
    for i, ch in enumerate(s):
        word += ch
        count = word.count(word[0])
        other_count = len(word) - count

        if count == other_count:
            word = ''
            answer += 1

    return answer if len(word) == 0 else answer + 1
