import matplotlib.pyplot as plt
import pandas as pd
from sklearn.linear_model import LinearRegression

df = pd.read_csv("ROOM_RATE_YEARLY_BY_ACCOUNT.csv")
print(df.head())
print(df.info())

df_cleaned = df.dropna(how='all')

X = df_cleaned["RANK"]
y = df_cleaned["ROOM_FEE"]

line_fitter = LinearRegression()
line_fitter.fit(X.values.reshape(-1,1), y)

predictVal = line_fitter.predict([[250]])
print(predictVal)

plt.plot(X, y, 'o')
plt.plot(X,line_fitter.predict(X.values.reshape(-1,1)))
plt.show()