from sklearn.linear_model import LinearRegression
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import datetime

df = pd.read_csv("ROOM_RATE 4.csv")
print(df.head())


df_cleaned = df.dropna(how='all')
#df_typecasting =  df_cleaned.astype({"LODG_DATE":'int64'})

#df_cleaned = df_cleaned.set_index('LODG_DATE', append=False)
#df_cleaned = df_cleaned.index.to_julian_date()
#print(pd.to_datetime(df_cleaned.LODG_DATE, errors='coerce', format='%m%d%Y'))
#$df_cleaned['LODG_DATE'] = pd.to_datetime(df_cleaned.LODG_DATE, format='%m%d%Y')
#df_cleaned['LODG_DATE'] = df_cleaned['LODG_DATE'].map(datetime.datetime.toordinal)

#df_cleaned = df_cleaned.astype({'LODG_DATE': 'int32'})

print(pd.to_datetime(df_cleaned['LODG_DATE'], format='%Y-%m-%d'))
print(pd.to_datetime(df_cleaned['LODG_DATE'], format='%Y-%m-%d'))

#print(df_cleaned.LODG_DATE.values.astype(np.int64))

#print(df_cleaned.info())
#print(df_cleaned.head())

X = df_cleaned["LODG_DATE"][:50]
y = df_cleaned["ROOM_FEE"][:50]
#plt.plot(X, y, 'o')
#plt.show()

line_fitter = LinearRegression()
line_fitter.fit(X.values.reshape(-1,1), y)

print(line_fitter.predict([[20120429]]))

#plt.figure(figsize=(20, 5))
plt.plot(X, y, 'o')
plt.plot(X,line_fitter.predict(X.values.reshape(-1,1)))
plt.show()