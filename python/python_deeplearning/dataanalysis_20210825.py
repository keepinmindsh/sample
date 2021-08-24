import pandas as pd
from sklearn.linear_model import LinearRegression
import matplotlib.pyplot as plt
import seaborn as sns

df = pd.read_csv("ROOM_RATE.csv")
print(df.head())
print(df.info())

df_cleaned = df.dropna(how='all')

X = df_cleaned["INDEX"][:500]
y = df_cleaned["ROOM_FEE"][:500]

line_fitter = LinearRegression()
line_fitter.fit(X.values.reshape(-1,1), y)

predictVal = line_fitter.predict([[250]])
print(predictVal)

plt.plot(X, y, 'o')
plt.plot(X,line_fitter.predict(X.values.reshape(-1,1)))
plt.show()