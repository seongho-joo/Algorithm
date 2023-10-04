#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string DecimalToBinary(int num, int n) {
    string ret = "";

    while(num != 0) {
        char temp;
        if (num % 2 == 0) temp = ' ';
        else temp = '#';
        ret.push_back(temp);
        num /= 2;
    }

    while(ret.size() != n) {
        ret.push_back(' ');
    }

    reverse(ret.begin(), ret.end());
    return ret;
}

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;

    for(int i = 0; i < n; i++) {
        string a, b, c;
        a = DecimalToBinary(arr1[i], n);
        b = DecimalToBinary(arr2[i], n);

        for(int i = 0; i < n ; i++) {
            if(a[i] == '#' || b[i] == '#') c += '#';
            else c += ' ';
        }

        answer.push_back(c);
    }

    return answer;
}