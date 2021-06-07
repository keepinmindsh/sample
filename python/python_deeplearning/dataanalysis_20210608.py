from sklearn.linear_model import LinearRegression
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import datetime

file_path = 'RoomRate_Only.csv'

roomRateDf = pd.read_csv(file_path,  names = ['LODG_DATE', 'ROOM_FEE'])

print(roomRateDf)

roomRateDf['LODG_DATE'] = pd.to_datetime(roomRateDf['LODG_DATE'])

roomRateDf.index = roomRateDf['LODG_DATE']
roomRateDf.set_index('LODG_DATE', inplace=True)

roomRateDf.plot()
plt.show()