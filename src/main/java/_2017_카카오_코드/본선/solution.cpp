#include <bits/stdc++.h>

using namespace std;

int solution(int n, vector<string> data) {
  string friends = "ACFJMNRT";
  int answer = 0;

  do {
    bool flag = true;
    for (int i = 0; i < n; i += 1) {
      int first_idx = 0, second_idx = 0, gap = 0;
      int firtst_friend = data[i][0], second_friend = data[i][2];
      char op = data[i][3];
      int interval = data[i][4] - '0';

      for (int j = 0; j < friends.length(); j++) {
        if (friends[j] == firtst_friend) first_idx = j;
        if (friends[j] == second_friend) second_idx = j;
      }
      gap = abs(first_idx - second_idx) - 1;

      switch (op) {
        case '=':
          if (interval != gap) {
            flag = false;
            break;
          }
          break;
        case '>':
          if (gap <= interval) {
            flag = false;
            break;
          }
          break;
        default:
          if (gap >= interval) {
            flag = false;
            break;
          }
          break;
      }
    }
    if (flag) answer += 1;
  } while (next_permutation(friends.begin(), friends.end()));

  return answer;
}