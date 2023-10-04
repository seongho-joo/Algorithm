#include <string>
#include <cmath>
#include <cstdlib>
#include <vector>

using namespace std;

int solution(string dartResult) {
    int answer = 0;
    vector<int> score;

    for(int i = 0, j = 0; i < dartResult.size(); i++) {
        char c = dartResult[i];
        if('0' <= c && c <= '9') {
            string num;
            num.push_back(c);

            if('0' <= dartResult[i + 1] && dartResult[i + 1] <= '9') {
                num += dartResult[i + 1];
                i += 1;
            }
            score.push_back(stoi(num));
        } else if(c == 'S') {
            j += 1;
        } else if(c == 'D') {
            score[j] = pow(score[j], 2);
            j += 1;
        } else if(c == 'T') {
            score[j] = pow(score[j], 3);
        } else if(c == '*') {
            auto temp = score.end() - 1;
            *temp *= 2;
            *(temp - 1) *= 2;
        } else if(c == '#') {
            score[j - 1] *= -1;
        }
    }
    for(int n : score) {
        answer += n;
    }
    return answer;
}