year = 2019
month = 10
day = 29

# Format Method
print("Today is {}, {}th {}.".format(month, day, year))

date_string = "Today is {}, {}th {}.";

print(date_string.format(year, month, day + 1))

# Format Mapping with Index
print("Today is {1}, {0}th {2}.".format(month, day, year))

num_1 = 1
num_2 = 3
print("{0} 나누기는 {1}은 {2:.4f}입니다.".format(num_1, num_2, num_1 / num_2))

# 파이썬 버전 3.6부터 새롭게 나온 방식입니다. 아직 완전히 대중화되지는 않았지만 좋은 평을 받고 있기 때문에,
# 곧 f-string을 더 많이 사용하는 추세로 갈 수 있습니다.
name = "최지웅"
age = 32

print(f"제 이름은 {name}이고 {age}살입니다.")