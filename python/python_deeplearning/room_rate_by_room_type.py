from sklearn.linear_model import LinearRegression
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

df = pd.read_csv("ROOM_RATE 3.csv")
print(df.head())
print(df.info())

df_cleaned = df.dropna(how='all')


X = df_cleaned["LODG_DATE"][:50]
y = df_cleaned["ROOM_FEE"][:50]
#plt.plot(X, y, 'o')
#plt.show()

sns.jointplot(x='LODG_DATE', y='ROOM_FEE', data=df_cleaned)
plt.show()