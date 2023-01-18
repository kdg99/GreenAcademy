global a
global b
a = 0
b = 0

def fibonacci(n):
    if n==0:
        global a
        a += 1
        return 0
    elif n==1:
        global b
        b += 1
        return 1
    else:
        return (fibonacci(n-1) + fibonacci(n-2))

test = int(input())
for i in range(test):
    num = int(input())
    fibonacci(num)
    print(a, ' ', b)

#https://www.acmicpc.net/board/view/24540