def solution(s, skip, index):
    answer = ''
    s = [ord(i) - ord('a') for i in s]
    skip = [ord(i) - ord('a') for i in skip]
    for c in s:
        count = 0
        i = 1
        while True:
            if (c + i) % 26 not in skip:
                count += 1
            if count == index:
                answer += chr(((c + i) % 26) + ord('a'))
                break
            i += 1

    return answer
