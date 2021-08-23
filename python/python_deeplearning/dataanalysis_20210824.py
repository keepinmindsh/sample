import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

df = pd.read_csv("ROOM_RATE.csv")
print(df.head())
print(df.info())

df_cleaned = df.dropna(how='all')

X = df_cleaned["INDEX"][:500]
y = df_cleaned["ROOM_FEE"][:500]
plt.plot(X, y, 'o')
plt.show()

#sns.jointplot(x='INDEX', y='ROOM_FEE', data=df_cleaned)
#plt.show()