from sklearn.linear_model import LinearRegression
import numpy as np

# X는 훈련데이터의 특징이고, 여기서는 피자의 지름이다.
# scikit-learn은 특징 벡터 이름을 X로 사용한다.
# 대문자는 행렬을 의미하고 소문자는 벡터를 의미한다.
X = np.array([[6], [8], [10], [14], [18]]).reshape(-1, 1)
y = [ 7, 9, 13, 17.5, 18 ] # y 피자가격을 나타내는 벡터이다.

model = LinearRegression() # 예측기 생성 - 선형회귀
model.fit(X, y)            # 훈련 데이터에 모델 적합화

# 임의의 변수를 입력하여 계산된 선형 그래프 상에서 피자의 가격을 예측
test_pizza = np.array([[12]])
predicted_price = model.predict(test_pizza)[0]
print('A 12" pizza should code : $%.2f' % predicted_price)

print('Residual sume of squares : %.2f' % np.mean((model.predict(X) - y) ** 2))