def solution(name, yearning, photo):
    answer = []
    dic = {}
    # 추억 점수 저장 O(N)
    for i in range(len(name)):
        dic[name[i]] = yearning[i]

    # 사진에 있는 사람들의 점수 계산 O(N^2) 10,000
    for row in photo:
        score = 0
        for n in row:
            if n in dic:
                score += dic[n]
        answer.append(score)

    return answer