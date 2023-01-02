import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split(" ")))
arr.sort()
arr.insert(0,1)
answer = []

for i in range(1,N+1):
    answer.append(arr[i] + arr[i*-1])

#print(answer)
print(min(answer))