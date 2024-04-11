# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

from collections import deque


def move(x, y, dx, dy):
    count = 0
    while arr[x + dx][y + dy] != '#' and arr[x][y] != 'O':
        x += dx
        y += dy
        count += 1
    return x, y, count


def bfs():
    q = deque()
    q.append((R_i, R_j, B_i, B_j, 1))  # 5는 아무것도 아닌방향
    visited.append((R_i, R_j, B_i, B_j))

    while q:
        ri, rj, bi, bj, result = q.popleft()

        if result > 10:
            break

        for k in range(4):
            ai, aj, acount = move(ri, rj, dx[k], dy[k])
            ci, cj, ccount = move(bi, bj, dx[k], dy[k])

            if arr[ci][cj] == 'O':
                continue

            if arr[ai][aj] == 'O':
                print(result)
                return

            if ai == ci and aj == cj:
                if acount > ccount:
                    ai -= dx[k]
                    aj -= dy[k]
                else:
                    ci -= dx[k]
                    cj -= dy[k]

            if (ai, aj, ci, cj) not in visited:
                visited.append((ai, aj, ci, cj))
                q.append((ai, aj, ci, cj, result + 1))

    print(-1)
    return


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    n, m = map(int, input().split())
    arr = [list(input().rstrip()) for _ in range(n)]
    dx = [-1, 0, 1, 0]  # 서북동남
    dy = [0, -1, 0, 1]
    visited = []
    R_i, R_j = 0, 0
    for i in range(n):
        for j in range(m):
            if arr[i][j] == 'B':
                B_i, B_j = i, j
            if arr[i][j] == 'R':
                R_i, R_j = i, j
    bfs()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/

# 패인 포인트
# 문제를 잘못이해함.
# 한 방향으로 기울이면 구슬이 끝까지 가야하는데, 내가 구현했던 형식은 한칸씩 가는 로직이었음.
# 또한, 큐인데도 불구하고 q.pop()을 써서 LIFO를 사용했음
# 큐이기 때문에 q.popleft()를 사용해야 함.
# 마지막에 visited[]를 써주는 이유는, 내가 방문했던 곳을 안감으로써 무한루프를 방지하고자 함.
