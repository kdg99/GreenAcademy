"""
날짜 : 2023/01/11
이름 : 김동근
내용 : Python 클래스 실습하기
"""
#Car 파일 안의 Car클래스
from sub1.Car import Car
from sub1.Account import Account

bmw = Car('BMW', '검정색', 5000)
bmw.speedUp()
bmw.speedUp()
bmw.speedDown()
bmw.show()

sonata = Car('소나타', '흰색', 3000)
sonata.speedUp()
sonata.speedUp()
sonata.speedDown()
sonata.show()


wr = Account('우리은행', 10101, '김동근')
ku = Account('기업은행', 30101, '김동근')

wr.deposit(10000)
wr.withdraw(4000)
wr.show()


ku.deposit(20000)
ku.withdraw(4500)
ku.show()
