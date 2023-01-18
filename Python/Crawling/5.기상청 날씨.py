"""
날짜 : 2023/01/16
이름 : 김동근
내용 : Python 기상청 날씨 실습하기
"""

from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
import pymysql

#DB 접속
conn = pymysql.connect(host='127.0.0.1',
                user='root',
                password='1234',
                db='java1db',
                charset='UTF8')

#SQL 실행객체
cur = conn.cursor()

#가상브라우저 실행
chrome_options = Options()
chrome_options.add_experimental_option("detach", True)
browser = webdriver.Chrome('./chromedriver.exe', options=chrome_options)

#네이버 이동
browser.get('https://www.weather.go.kr/w/obs-climate/land/city-obs.do')

#전국 지역명 출력
trs = browser.find_elements(By.CSS_SELECTOR, '#weather_table > tbody > tr')

for tr in trs:
    tds = tr.find_elements(By.CSS_SELECTOR, 'td')
    
    # SQL 실행
    var = []
    for j in tds:
        if j.text == ' ':
            var.append(None)
        else:
            var.append(j.text)
        sql = "insert into `weather` values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s, NOW())"
    cur.execute(sql, var)
    conn.commit()

#DB 종료
conn.close()
print('Insert 완료...')

#가상 브라우저 종료
browser.close()
print('프로그램 종료...')

