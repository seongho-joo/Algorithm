def solution(data, ext, val_ext, sort_by):
    cmd = {'code': 0, 'date': 1, 'maximum': 2, 'remain': 3}

    answer = list(filter(lambda x: x[cmd[ext]] <= val_ext, data))
    answer.sort(key=lambda x: x[cmd[sort_by]])

    return answer
