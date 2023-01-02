import sys
input = sys.stdin.readline

N, M = map(int,input().split())
answer = []

for _ in range(N):
    P, L = map(int, input().split())
    subject = list(map(int, input().split(" ")))
    subject.sort()
    if P >= L:
        answer.append(subject[P-L])
    else:
        answer.append(1)

answer.sort()
a = 0
cnt = 0
for i in answer:
    M -= i
    if M < 0:
        break
    cnt += 1

print(cnt)
    