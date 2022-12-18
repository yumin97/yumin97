import sys
input = sys.stdin.readline

inputs = []
arr = []

l = int(input())
for _ in range(l):
    inputs.append(input())

for i in range(1,l):
    for j in range(0,len(inputs[i])):
        if(inputs[0][j] != inputs[i][j]):
            arr.append(j)

result = list(set(arr))
result.sort()

first_word = list(inputs[0])

for i in result:
    first_word[i] = '?'

print(''.join(first_word))