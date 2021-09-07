from sklearn.linear_model import LinearRegression
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import datetime

file_path = 'RoomRate_Only.csv'

roomRateDf = pd.read_csv(file_path,  names = ['LODG_DATE', 'ROOM_FEE'])

roomRateDf = roomRateDf.dropna(how='all')

print(roomRateDf)

roomRateDf['LODG_DATE'] = pd.to_datetime(roomRateDf['LODG_DATE'])

roomRateDf.index = roomRateDf['LODG_DATE']
roomRateDf.set_index('LODG_DATE', inplace=True)

dates_input = roomRateDf.LODG_DATE.astype('datetime64[D]')
y = roomRateDf["ROOM_FEE"]


line_fitter = LinearRegression()
line_fitter.fit(dates_input.values.reshape(-1,1), y)

plt.plot(dates_input, y, 'o')
plt.plot(dates_input,line_fitter.predict(dates_input.values.reshape(-1,1)))
plt.show()