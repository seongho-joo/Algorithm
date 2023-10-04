class File:
    def __init__(self, filename, head, number, tail):
        self.filename = filename
        self.head = head
        self.number = number
        self.tail = tail


def solution(files):
    file = []

    for f in files:
        number, tail, head = getFileSection(f)
        file.append(File(f, head, number, tail))

    file.sort(key=lambda x: (x.head, x.number))

    return [''.join(i.filename) for i in file]


def getFileSection(file):
    file = file.lower()
    head, number, tail = '', '', ''

    for i in range(len(file)):
        if file[i].isdigit():
            head = file[:i]
            number = file[i:]

            for j in range(len(number)):
                if not number[j].isdigit():
                    number = number[:j]
                    tail = number[j:]
                    break
            break

    return int(number), tail, head
