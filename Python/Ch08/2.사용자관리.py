"""
날짜 : 2023/01/13
이름 : 김동근
내용 : Python 데이터베이스 실습하기
"""
import pymysql

#DB 접속
conn = pymysql.connect(host='127.0.0.1',
                user='root',
                password='1234',
                db='java1db',
                charset='UTF8')
cur = conn.cursor()

while True:
    print('0:종료, 1:등록, 2:조회, 3:검색, 4:삭제\n')
    answer = 0
    try:
        answer = int(input('선택 :'))
    except Exception as e:
        print('다시 입력하세요.' + e)
        continue

    if answer == 0:
        break
    elif answer == 1:
        data = list(input('아이디 비번 이름 휴대폰 나이 입력 :').split())
        sql = "insert into `user1` values ('%s', '%s', '%s', '%s', %s)"
        cur.execute(sql % (data[0], data[1], data[2], data[3], data[4]))
        conn.commit()
        print('입력 완료...')

    elif answer == 2:
        sql = "select * from `user1`"
        cur.execute(sql)
        conn.commit()
        print('|아이디|비번|이름|휴대폰|나이|')
        for row in cur.fetchall():
            print('|%s|%s|%s|%s|%s|'% (row[0], row[1], row[2], row[3], row[4])) 
        print('조회 완료...')

    elif answer == 3:
        keyword = input('검색할 id를 입력해주세요 :')
        sql = "select * from `user1` where `uid`='{}'".format(keyword)
        cur.execute(sql)
        conn.commit()
        print('|아이디|비번|이름|휴대폰|나이|')
        for row in cur.fetchall():
            print('|%s|%s|%s|%s|%s|' % (row[0], row[1], row[2], row[3], row[4])) 
        print('검색 완료...')

    elif answer == 4:
        uid = input('삭제할 id를 입력해주세요 :')
        sql = "delete from `user1` where `uid`='{}'".format(uid)
        cur.execute(sql)
        conn.commit()
        print('삭제 완료...')

    else:
        print('0 ~ 4 중에 입력하세요')
