"""
날짜 : 2023/01/10
이름 : 김동근
내용 : Python 상속 실습하기
"""

from sub2.StockAccount import StockAccount

kb = StockAccount('KB증권', '101-2-2-2', '김동근', '삼성전자', 10, 60000)
kb.deposit(1000000)
kb.sell(5, 70000)
kb.show()