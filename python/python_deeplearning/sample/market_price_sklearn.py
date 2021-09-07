import matplotlib.pyplot as plt
import pandas as pd
from sklearn.linear_model import LinearRegression

file_path = 'market-price.csv'
bitcoin_df = pd.read_csv(file_path, names = ['day', 'price'])

bitcoin_df['day'] = pd.to_datetime(bitcoin_df['day'])

bitcoin_df.index = bitcoin_df['day']

bitcoin_df.set_index('day', inplace=True)

#bitcoin_df.plot()
#plt.show()

print(bitcoin_df.index)

X = bitcoin_df.index
y = bitcoin_df["price"]

line_fitter = LinearRegression()
line_fitter.fit(X.values.reshape(-1,1), y)

plt.plot(X, y, 'o')
plt.plot(X,line_fitter.predict(X.values.reshape(-1,1)))
plt.show()