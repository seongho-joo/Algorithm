def solution(wallpaper):
    ly, lx, ry, rx = 51, 51, -1, --1

    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == '#':
                ly = min(ly, i)
                lx = min(lx, j)
                ry = max(ry, i)
                rx = max(rx, j)

    print(ly, lx, ry, rx)

    return [ly, lx, ry + 1, rx + 1]
