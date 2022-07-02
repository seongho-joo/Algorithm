from math import ceil

LAST_EXIT_TIME = 1439


def hourToMinutes(time):
    h, m = map(int, time.split(':'))
    return h * 60 + m


def solution(fees, records):
    answer = []
    car = {}
    dt, df, ut, uf = fees

    for r in records:
        time, number, op = r.split()

        if number in car:
            car[number].append((hourToMinutes(time), op))
        else:
            car[number] = [(hourToMinutes(time), op)]

    car_list = list(car.items())
    car_list.sort(key=lambda x: x[0])

    for cars in car_list:
        time = 0
        stack = []

        for car in cars[1]:
            if car[1] == 'IN':
                stack.append(car[0])
            else:
                time += car[0] - stack.pop()

        if len(stack) != 0:
            time += LAST_EXIT_TIME - stack.pop()

        if time <= dt:
            answer.append(df)
        else:
            answer.append(df + ceil((time - dt) / ut) * uf)

    return answer
