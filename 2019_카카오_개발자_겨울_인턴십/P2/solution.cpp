#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

map<int, int> m;

bool cmp (pair<int, int> &a, pair<int, int> &b) {
    return a.second > b.second;
}

void countingNumber(string s) {
    string temp = "";
    for (char c : s) {
        if (isdigit(c)) {
            temp += c;
        } else {
            if (!temp.empty())
                m[stoi(temp)] += 1;
            temp = "";
        }
    }
}

vector<int> solution(string s) {
    vector<int> answer;
    vector<pair<int, int> > tuple;

    countingNumber(s);

    for (auto it : m) {
        tuple.emplace_back(it);
    }
    sort(tuple.begin(), tuple.end(), cmp);

    for (auto it : tuple) {
        answer.push_back(it.first);
    }

    return answer;
}