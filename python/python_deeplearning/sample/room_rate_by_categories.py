import warnings
warnings.filterwarnings('ignore')
import pandas as pd
import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt

df = pd.read_csv("ROOM_RATE.csv")
print(df.head())
print(df.info())

print(df.shape)
print(df.describe())

print(df.dtypes)

#sns.pairplot(df,hue='ROOM_TYPE_CODE')

sns.pairplot(df,x_vars=['STD_ROOM_FEE','ROOM_FEE'],y_vars=['LODG_DATE'],hue='ROOM_TYPE_CODE')