import sys
input = sys.stdin.readline

N = int(input())
T = int(input())
arr = list(map(int, input().split(" ")))

frame = dict()

for i in range(T) :
    if arr[i] in frame:
        frame[arr[i]][0] += 1
    else :
        if len(frame) < N :
            frame[arr[i]] = [1,i]
        else :
            del_list = sorted(frame.items(), key = lambda x : (x[1][0], x[1][1]))
            del_key = del_list[0][0]
            del(frame[del_key])
            frame[arr[i]] = [1,i];

ans_list = list(sorted(frame.keys()))
answer = str(ans_list[0])
for i in ans_list[1: ]:
    answer += " " + str(i)
print(answer)    
