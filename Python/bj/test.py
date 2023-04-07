#입력
a, b, c = int(input()), int(input()), int(input())
n = a*b*c

#변환
n_list = list(str(n))


#카운트
r_list = [0 for i in range(10)]

#비교후 증가
for i in range(10):
    for n in n_list:
        if i == int(n):
            r_list[i] += 1

for r in r_list:
    print(r)
