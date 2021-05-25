from sklearn.linear_model import LinearRegression
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

df = pd.read_csv("ROOM_RATE 3.csv")
print(df.head())


df_cleaned = df.dropna(how='all')
df_typecasting =  df_cleaned.astype({"LODG_DATE":'int64'})

print(df_typecasting.info())

X = df_typecasting["LODG_DATE"][:50]
y = df_typecasting["ROOM_FEE"][:50]
#plt.plot(X, y, 'o')
#plt.show()

line_fitter = LinearRegression()
line_fitter.fit(X.values.reshape(-1,1), y)

print(line_fitter.predict([[20120429]]))

plt.figure(figsize=(20, 5))
plt.plot(X, y, 'o')
plt.plot(X,line_fitter.predict(X.values.reshape(-1,1)))
plt.show()