"""
날짜 : 2023/01/02
이름 : 김동근
내용 : Python 연산자 실습하기
"""



#대입연산자
a = 1
b = c = d = 0
e,f,g = 7, True, 'Apple'

print('a :', a)
print('b :', b)
print('c :', c)
print('d :', d)
print('e :', e)
print('f :', f)
print('g :', g)

#산술연산자
num1 = 1
num2 = 2
num3, num4 = 3, 4

r1 = num1 + num2
r2 = num1 - num2
r3 = num1 * num2
r4 = num1 / num2
r5 = num1 // num2
r6 = num1 % num2
r7 = num1 ** num2

print('r1 :', r1)
print('r2 :', r2)
print('r3 :', r3)
print('r4 :', r4)
print('r5 :', r5)
print('r6 :', r6)
print('r7 :', r7)

#복합대입연산자
num5 = 5
num5 += 1
num6 -= 2
num7 *= 3
num8 /= 4 
print('num5 :', num5)
print('num6 :', num6)
print('num7 :', num7)
print('num8 :', num8)

#비교연산자
rs1 = var1 > var2
rs2 = var1 < var2
rs3 = var1 >= var2
rs4 = var1 >= var2
rs5 = var1 == var2
rs6 = var1 != var2
print('rs1 :', rs1)
print('rs2 :', rs2)
print('rs3 :', rs3)
print('rs4 :', rs4)
print('rs5 :', rs5)
print('rs6 :', rs6)


#논리연산자
var3 = 3
var4 = 4

res1 = var3 > 2 and var4 > 3
res1 = var3 > 2 and var4 > 4
