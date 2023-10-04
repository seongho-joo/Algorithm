#include <string>
#include <vector>
#include <stack>

using namespace std;

stack<int> bosket;

bool isSame(int n) {
    return bosket.top() == n;
}

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    int N = (int)board.size();

    for (int i = 0; i < moves.size(); i += 1) {
        int number = moves[i] - 1;

        for (int j = 0; j < N; j += 1) {
            int doll = board[j][number];
            if (doll != 0) {
                board[j][number] = 0;
                if (!bosket.empty()) {
                    if (isSame(doll)) {
                        answer += 2;
                        bosket.pop();
                        break;
                    }
                }
                bosket.push(doll);
                break;
            }
        }
    }
    return answer;
}