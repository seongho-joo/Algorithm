# [2019 KAKAO BLIND RECRUITMENT - 1] 오픈채팅방

![](https://user-images.githubusercontent.com/45463495/162581135-e4a4afd9-fc4a-4ee7-89c9-99a3fb5739e8.png)

## 💡 풀이
카카오에서 자주 나오는 문자열 구현 문제이다.

uid는 고정값이고 닉네임은 가변 값이기 때문에 `HashMap` 자료구조를 이용한다.

**설계**
- "Leave", "Enter"일 때 메시지를 출력하기 때문에 len 변수를 선언해서 카운트하고 출력한다.
- `HashMap` 자료구조는 기존에 key 값이 존재하면 key 값의 value 값만 변경되기 때문에 "Enter", "Change"일 때 `HashMap`에 저장한다.