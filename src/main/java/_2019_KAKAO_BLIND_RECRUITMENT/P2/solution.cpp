#include <string>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

bool compare(const pair<int, double>& a, const pair<int, double>& b) {
    if(a.second == b.second) {
        return a.first < b.first;
    }
    return a.second > b.second;
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<pair<int, double> > failureRate;

    map<int, int> m;

    sort(stages.begin(), stages.end());
    int totalNumber = (int)stages.size();

    for(int i = 1; i <= N; i++) {
        m.insert(make_pair(i, 0));
    }

    for(int n : stages) {
        m[n] += 1;
    }

    for(auto n : m) {
        double rate = 0;
        if(n.second != 0)  {
            rate = (double)n.second / (double)totalNumber;
        }
        failureRate.push_back(make_pair(n.first, rate));
        totalNumber -= n.second;
    }

    sort(failureRate.begin(), failureRate.end(), compare);

    for(auto a : failureRate) {
        if(a.first <= N) answer.push_back(a.first);
    }

    return answer;
}