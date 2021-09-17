import numpy as np


import numpy as np

a = [1,2,3,4,5,6]
b = np.reshape(a,(2,3))
c = np.reshape(a,(3,2))
print(b)
print('\n')
print(c)

print('\n')
a1 = np.arange(1,9)
b1 = a1.reshape(2,2,2)
print(a1)
print(b1)

print('\n')
x = np.arange(12)

print(x.reshape(-1,1))
print(x.reshape(-1,2))
