#include <bits/stdc++.h>

using namespace std;

typedef pair<int, int> pii;

const int dy[] = {-1, 1, 0, 0};
const int dx[] = {0, 0, -1, 1};

void bfs(vector<vector<int>> picture, vector<vector<bool> > &visited, int &max_size_of_one_area, pii s, int m, int n, int num) {
    queue<pii> q;
    int cnt = 0;
    q.push(s);

    while (!q.empty()) {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (-1 < ny && ny < m && -1 < nx && nx < n && picture[ny][nx] == num) {
                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.push({ny, nx});
                    cnt += 1;
                }
            }
        }
    }
    max_size_of_one_area = max(max_size_of_one_area, cnt + 1);
}

vector<int> solution(int m, int n, vector<vector<int>> picture) {
    int number_of_area = 0;
    int max_size_of_one_area = 0;
    vector<vector<bool> > visited(m, vector<bool>(n, false));

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (!visited[i][j] && picture[i][j] != 0) {
                visited[i][j] = true;
                number_of_area += 1;
                bfs(picture, visited, max_size_of_one_area, {i, j}, m, n, picture[i][j]);
            }
        }
    }

    vector<int> answer(2);
    answer[0] = number_of_area;
    answer[1] = max_size_of_one_area;
    return answer;
}