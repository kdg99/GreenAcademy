#입력
a = int(input())
for i in range(a):
    #스택초기화
    top = 0
    str = input()
    
    for chr in str:
        #underflow시 탈출
        if top < 0:
            break
        # (면 up, )면down
        elif chr=='(':
            top+=1
        else:
            top-=1
    if top == 0:
        print('YES')
    else:
        print('NO')