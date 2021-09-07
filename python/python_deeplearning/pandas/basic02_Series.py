from pandas import Series

data = [ 1, 2, 3]

s = Series(data)

print(s)

print(s*10)

data1 = [ 1000, 2000, 3000 ]
index = ["산" , "물" , "바람"]

s1 = Series(data=data1, index=index)
print(s1)


close = [42500, 42550, 41800, 42550, 42650]
date = ["2019-05-31", "2019-05-30", "2019-05-29", "2019-05-28", "2019-05-27"]
s2 = Series(data=close, index=date)
print(s2)