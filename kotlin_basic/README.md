# Kotlin 

## https://kotlinlang.org/docs/getting-started.html#create-your-powerful-application-with-kotlin


## https://kotlinlang.org/docs/basic-syntax.html

### Kotlin Basic 

##### Kotlin의 기본 사항 

 - 문장의 마지막에 정의하는 마침표, 세미 콜론 불필요함. 

##### 코드 샘플

**Package definition / imports**  

- Package 의 정의는 반드시 소스 상단에 정의되어야 한다.

**Program entry point**  

- Kotlin의 메인 진입점은 main 함수로 정의되고, 정의 방식은 아래와 같다.

```kotlin
fun main() {
    println("Hello world!")
}
```

```kotlin
fun main(args: Array<String>) {
    println(args.contentToString())
}
```

```kotlin
suspend fun main() = coroutineScope {
    for (i in 0 until  10) {
        launch {
            delay(1000L - i * 10)
            print("$i ")
        }
    }
}
```

**표준 출력**   

```kotlin
package bong.lines.standard_output

fun main(){
    standardOutputPrint()
}
```

```kotlin
package bong.lines.standard_output

fun standardOutputPrint() {
    print("Hello ")
    print("World! ")
}
```

**Functions**  

```kotlin

fun main() {
    print(sum(100, 100));

    print(printSum(100, 100));
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

```

**Variables**  

- val : read-only 의 로컬 변수, 오직 단 한번만 값에 대해서 할당이 가능하다.  
- var : 재할당이 가능한 로컬 변수 

```kotlin

fun main() {
    val a: Int = 1  // immediate assignment
    val b = 2   // `Int` type is inferred
    val c: Int  // Type required when no initializer is provided
    c = 3       // deferred assignment

    print(a)
    print(b)
    print(c)

    incrementX()
}

// 변수가 함수보다 위쪽에 선언되어 사용될 수 있음 

val PI = 3.14
var x = 0

fun incrementX() {
    x += 1
}

```

**Classes**  

- 클래스가 정의되는 시점에 파라미터를 Class와 함께 정의가 가능하다.

```kotlin

fun main() {

    var rectangle = Rectangle(5.0, 10.0);

    println("The parameter is ${rectangle.perimeter}")
}

class Rectangle (var height: Double, var length: Double) {
    var perimeter = (height + length) * 2
}

```

- 상속은 : 의해서 정의할 수 있다. 
- 기본적으로 class는 final 로 인식되기 때문에 상속할 수 없는데, 외부 공개를 위해서 open을 정의해야 한다. 

```kotlin

open class Shape

class Rectangle (var height: Double, var length: Double) : Shape() {
    var perimeter = (height + length) * 2
}

```

**String Templates** 

- 문자열 템플릿의 경우, "" 내에서 달러 표시 및 {} 의해서 코틀린 문법 및 변수를 매핑할 수 있다. 
- 문자열 템플릿이 자바에 비해 직관적으로 바인딩 및 표시가 가능하다. 

```kotlin

fun main() {
    var a = "1"

    var s1 = "a is $a"

    a = "2"

    val s2 = "${s1.replace("is", "was")}, but now is $a"

    println(s2)
}

```
