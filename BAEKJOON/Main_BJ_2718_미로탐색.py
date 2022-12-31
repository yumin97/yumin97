import sys
from collections import deque
input = sys.stdin.readline

dr = [0,0,-1,1]
dc = [-1,1,0,0]

N,M = map(int,input().split())
board = [list(map(int,input().rstrip())) for i in range(N)]
#visited = [[False for i in range(M)] for i in range(N)]

def bfs(r,c):
    que = deque()
    que.append((r,c))

    while que:
        r, c = que.popleft()
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if nr >= N or nr < 0 or nc >= M or nc < 0:
                continue
            if board[nr][nc] == 0:
                continue
            if board[nr][nc] == 1:
                board[nr][nc] = board[r][c] + 1
                que.append((nr,nc))

    return board[N-1][M-1]

print(bfs(0,0))