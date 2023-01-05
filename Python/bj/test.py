import math

test = int(input())

for i in range(test):
    x1,y1,r1,x2,y2,r2 = map(int, input().split())
    farx = math.sqrt((x1-x2)**2+(y1-y2)**2)
      