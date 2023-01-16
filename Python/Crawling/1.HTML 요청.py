"""
날짜 : 2023/01/16
이름 : 김동근
내용 : Python HTML 요청 실습하기
"""
import requests as req

url = 'https://www.naver.com'

html = req.get(url).text
print(html)