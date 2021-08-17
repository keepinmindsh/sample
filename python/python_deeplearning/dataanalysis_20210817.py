import numpy as np
from matplotlib import pyplot as plt

data = np.array([[100, 20],
        [150, 24],
        [300, 36],
        [400, 47],
        [130, 22],
        [240, 32],
        [350, 47],
        [200, 42],
        [100, 21],
        [110, 21],
        [190, 30],
        [120, 25],
        [130, 18],
        [270, 38],
        [255, 28]])

plt.scatter(data[:, 0], data[:, 1])
plt.title("Time / Distance")
plt.xlabel("Delivery Distance (meter)")
plt.ylabel("Time Consumed (minute)")
plt.axis([0, 420, 0, 50])
plt.show()


# 데이터 패턴을 비슷하게 따라가는 선을 그을 수는 있지만 모든 점 위를 지나가는 하나의 선은 그을 수 없습니다. 따라서 예측값과 실제 값 사이에서 차이가 발생하게 됩니다.
# 이 오차의 합을 최소한으로 줄이는 선을 찾는다면 예측을 가장 실제와 가깝게 하는 모델이라고도 할 수 있을 것입니다.

# 선과 점들의 거리의 합을 최소하 하는 것을 위해서 +, - 가 있는 오차의 합보다는 오차 제곱의 합을 구하는 것이 더 바람직함.
# 이말인 즉슨, 선을 기준으로 위아래의 거리의 합은 + , - 값으로 인하여 합산이 작아질 수 있으므로 오차 제곱을 이용하여 + 계수로 모두 만들어서
# 실제 거리의 값을 계산한다. <https://en.wikipedia.org/wiki/Linear_least_squares>

# for the next - https://techblog.woowahan.com/2582/

# A-1) Orthogonal Matrix (직교행렬) 공부중