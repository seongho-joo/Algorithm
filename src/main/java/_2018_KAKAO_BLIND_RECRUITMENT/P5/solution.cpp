// STL
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool isAlphabet(char c) {
    if ('a' <= c && c <= 'z') return true;
    return false;
}

vector<string> cutOffString(string str) {
    vector<string> ret;
    for (int i = 0; i < str.size(); i++) {
        if (isAlphabet(str[i]) && isAlphabet(str[i + 1]))
            ret.push_back(str.substr(i, 2));
    }
    return ret;
}

void upperCaseTolowerCase(string& str1, string& str2) {
    for (char& c : str1) {
        if (isupper(c))
            c = tolower(c);
    }

    for (char& c : str2) {
        if (isupper(c))
            c = tolower(c);
    }
}

int solution(string str1, string str2) {
    vector<string> set1, set2, intersection, Union;
    int totalLength = 0;
    double jaccardCoefficient = 0;

    upperCaseTolowerCase(str1, str2);

    set1 = cutOffString(str1);
    set2 = cutOffString(str2);
    sort(set1.begin(), set1.end());
    sort(set2.begin(), set2.end());

    if (set1.empty() && set2.empty())
        return 65536;

    totalLength = set1.size() + set2.size();
    intersection.resize(totalLength);
    Union.resize(totalLength);

    auto iter = set_intersection(set1.begin(), set1.end(), set2.begin(), set2.end(), intersection.begin());
    intersection.erase(iter, intersection.end());

    iter = set_union(set1.begin(), set1.end(), set2.begin(), set2.end(), Union.begin());
    Union.erase(iter, Union.end());

    jaccardCoefficient = (double)intersection.size() / (double)Union.size();
    return jaccardCoefficient * 65536;
}

// 직접 구현

#include <string>
#include <vector>

using namespace std;

bool isAlphabet(char c) {
    if ('a' <= c && c <= 'z') return true;
    return false;
}

vector<string> cutOffString(string str) {
    vector<string> ret;
    for (int i = 0; i < str.size(); i++) {
        if (isAlphabet(str[i]) && isAlphabet(str[i + 1]))
            ret.push_back(str.substr(i, 2));
    }
    return ret;
}

void upperCaseTolowerCase(string& str1, string& str2) {
    for (char& c : str1) {
        if (isupper(c))
            c = tolower(c);
    }

    for (char& c : str2) {
        if (isupper(c))
            c = tolower(c);
    }
}

int solution(string str1, string str2) {
    vector<string> set1, set2;
    int intersectionCount = 0, unionCount = 0;
    double jaccardCoefficient = 0;

    upperCaseTolowerCase(str1, str2);

    set1 = cutOffString(str1);
    set2 = cutOffString(str2);

    if (set1.empty() && set2.empty())
        return 65536;

    for (int i = 0; i < set1.size(); i++) {
        for (int j = 0; j < set2.size(); j++) {
            if (set1[i] == set2[j]) {
                intersectionCount += 1;
                set2[j] = "";
                break;
            }
        }
    }

    unionCount = set1.size()+set2.size() - intersectionCount;


    jaccardCoefficient = (double)intersectionCount / (double)unionCount;
    return jaccardCoefficient * 65536;
}