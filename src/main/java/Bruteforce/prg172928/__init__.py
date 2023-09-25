# 내 풀이
def get_start_point(park):
    for i in range(len(park)):
        for j in range(len(park[i])):
            if park[i][j] == 'S':
                return i, j


def solution(park, routes):
    y, x = get_start_point(park)

    for route in routes:
        direction, mv = route.split(' ')
        mv = int(mv)
        flag = False

        if direction == 'E':
            if x + int(mv) >= len(park[y]):
                continue
            for i in range(1, int(mv) + 1):
                if park[y][x + i] == 'X':
                    flag = True
                    break
            if flag:
                continue
            x += int(mv)
        elif direction == 'W':
            if x - int(mv) < 0:
                continue
            for i in range(1, int(mv) + 1):
                if park[y][x - i] == 'X':
                    flag = True
                    break
            if flag:
                continue
            x -= int(mv)
        elif direction == 'S':
            if y + int(mv) >= len(park):
                continue
            for i in range(1, int(mv) + 1):
                if park[y + i][x] == 'X':
                    flag = True
                    break
            if flag:
                continue
            y += int(mv)
        else:
            if y - int(mv) < 0:
                continue
            for i in range(1, int(mv) + 1):
                if park[y - i][x] == 'X':
                    flag = True
                    break
            if flag:
                continue
            y -= int(mv)
        flag = False

    return [y, x]


"""
# 다른 사람 풀이를 보고 적용한 코드
    dy = {'N': -1, 'S': 1, 'E': 0, 'W': 0}
    dx = {'N': 0, 'S': 0, 'E': 1, 'W': -1}
    y, x = get_start_point(park)

    for route in routes:
        direction, mv = route.split(' ')
        mv = int(mv)

        ny = y + dy[direction] * mv
        nx = x + dx[direction] * mv

        if ny < 0 or nx < 0 or ny >= len(park) or nx >= len(park[0]):
            continue

        for i in range(1, mv + 1):
            ny = y + dy[direction] * i
            nx = x + dx[direction] * i
            if park[ny][nx] == 'X':
                break
        else:
            y, x = ny, nx
"""
