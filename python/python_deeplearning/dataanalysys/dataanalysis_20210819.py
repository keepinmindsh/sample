import pandas as pd
import datetime

# TODO - 회귀분석을 위한 x, y의 좌표값을 구하려면 일자에 대해서는 index로 변환하여 계산 필요 . 해당 부분에 대해서 명쾌하기 정리 안됨.

file_path = 'date.csv'

roomRateDf = pd.read_csv(file_path, names = [ 'date'])

roomRateDf = roomRateDf.dropna(how='all')

print(roomRateDf)


roomRateDf.set_index('date', inplace=True)

print(roomRateDf)