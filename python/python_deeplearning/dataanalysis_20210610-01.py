import pandas as pd
from statsmodels.tsa.arima_model import ARIMA
import statsmodels.api as sm
import matplotlib.pyplot as plt

file_path = 'RoomRate_RBS.csv'

roomRateDf = pd.read_csv(file_path,  names = ['LODG_DATE', 'ROOM_FEE'])

roomRateDf = roomRateDf.dropna(how='all')

print(roomRateDf)

roomRateDf['LODG_DATE'] = pd.to_datetime(roomRateDf['LODG_DATE'])

roomRateDf.index = roomRateDf['LODG_DATE']
roomRateDf.set_index('LODG_DATE', inplace=True)

# (AR=2, 차분=1, MA=2) 파라미터로 ARIMA 모델을 학습합니다.
model = ARIMA(roomRateDf.ROOM_FEE.values, order=(2,1,2))

#trend : constant를 가지고 있는지, c - constant / nc - no constant
#disp : 수렴 정보를 나타냄
model_fit = model.fit(trend='c', full_output=True, disp=True)

fig = model_fit.plot_predict()

residuals = pd.DataFrame(model_fit.resid)
residuals.plot()
plt.show()