"""
일 수 계산
(year - 1) * 336 + (month - 1) * 28 + day

"2022.05.19"	["A 6", "B 12", "C 3"]	["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]	[1, 3]

today = 679,187
a = 168 / 678,834
b = 336 / 678,889
c = 84 / 679,103
c = 84 / 679,104

dueDate <= today -> remove
"""


def get_day(year, month, day):
    return (year - 1) * 336 + (month - 1) * 28 + day


def solution(today, terms, privacies):
    answer = []

    today = get_day(*map(int, today.split('.')))
    dic = {}

    for term in terms:
        name, expiration = term.split(' ')
        dic[name] = int(expiration) * 28

    for i in range(len(privacies)):
        date, name = privacies[i].split(' ')
        date = get_day(*map(int, date.split('.')))
        if date + dic[name] <= today:
            answer.append(i + 1)

    return answer
