import matplotlib.pyplot as plt
import pandas as pd

file_path = 'market-price.csv'
bitcoin_df = pd.read_csv(file_path, names = ['day', 'price'])

bitcoin_df['day'] = pd.to_datetime(bitcoin_df['day'])

bitcoin_df.index = bitcoin_df['day']

bitcoin_df.set_index('day', inplace=True)

bitcoin_df.plot()

plt.show()