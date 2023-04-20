
#입력
a = int(input())
for i in range(a):
    top = 0
    str = input()
    for chr in str:
        if chr=='(':
            top+=1
        else:
            top-=1
    if top == 0:
        print('YES')
    else:
        print('NO')
