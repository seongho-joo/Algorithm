def solution(board, h, w):
    dy = [0, 1, 0, -1]
    dx = [1, 0, -1, 0]
    answer = 0
    cur_color = board[h][w]
    h_len, w_len = len(board), len(board[0])

    for i in range(4):
        ny, nx = h + dy[i], w + dx[i]
        if 0 <= ny < h_len and 0 <= nx < w_len:
            if board[ny][nx] == cur_color:
                answer += 1

    return answer
