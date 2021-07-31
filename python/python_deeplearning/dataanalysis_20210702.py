# 시계열 데이터 분석 1차

import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

# ARIMA 모형이 인식할 수 있는 series 데이터 형태로 호출해야함.
data_ARIMA = pd.read_csv('/Users/dream/GIT/fork/time-series-analysis/time-series-analysis/data/passengers.csv', sep=';', header=0, parse_dates=True)
data_ARIMA.head(5)

print(data_ARIMA.head(10))

data_ARIMA['month'] = pd.to_datetime(data_ARIMA['month'])


# Indexing 처리
data_ARIMA_cut = data_ARIMA.iloc[0:132, ]

print(data_ARIMA_cut.tail())

data_ARIMA_cut_float = data_ARIMA_cut[:].astype(np.float64)
data_ARIMA_cut_float.tail()

data_ARIMA_cut_float.plot()
plt.show()