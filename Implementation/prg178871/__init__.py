'''
Incorrect solution
- 제한사항을 보지않고 swap을 이용해서 문제를 풂 -> 시간 초과 발생
- 제한사항이 최대 1,000,000 * 50,000 = 500억 이므로 O(N^2)의 시간복잡도를 가지는 알고리즘은 사용할 수 없음
'''
# def solution(players, callings):
#     answer = []
#     for calling in callings:
#         index = players.index(calling)
#         players[index - 1], players[index] = players[index], players[index - 1]
#
#     answer = players
#     return answer


'''
Correct solution
- player의 순위를 dictionary에 저장하여 O(N)의 시간복잡도로 문제를 해결
'''
def solution(players, callings):
    rank =  {key : i for i, key in enumerate(players)}

    for calling in callings:
        index = rank[calling]
        rank[calling] -= 1 # 추월한 선수
        rank[players[index - 1]] += 1 # 추월당한 선수
        players[index - 1], players[index] = players[index], players[index - 1]

    return players