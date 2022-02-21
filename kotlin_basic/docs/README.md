# Kotlin 

- https://kotlinlang.org/docs/getting-started.html#create-your-powerful-application-with-kotlin

### Kotlin Basic 

##### Kotlin의 기본 사항 

 - 문장의 마지막에 정의하는 마침표, 세미 콜론 불필요함. 

### 코드 샘플

##### **Package definition / imports**  

- Package 의 정의는 반드시 소스 상단에 정의되어야 한다.

##### **Program entry point**  

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

##### **표준 출력**   

```kotlin
package bong.lines.basic.standard_output

fun main(){
    standardOutputPrint()
}
```

```kotlin
package bong.lines.basic.standard_output

fun standardOutputPrint() {
    print("Hello ")
    print("World! ")
}
```

##### **Functions**  

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

- Default Argument 

코틀린에서 함수는 파타미터의 기본 값을 가져갈 수 있음. 

```kotlin

fun defaultFunction() {
    val value = function() 
    println("값 = $value") 
}

fun function(x: Int = 10): Int {
    return x * 2
}

```

- Named arguments 

함수의 파라미터 내에 파라미터 변수 명을 지정하여 사용할 수 있다. 

```kotlin

fun namedArguments() {
    val value = arguments(y = 2, x = 5) // double(5, 2) 와 동일
    println("값 = $value") // 결과 : 값 = 10
}

fun arguments(x: Int = 10, y: Int): Int {
    return x * y
}

```

- Single Expression

함수의 본문이 바로 return 값을 가질 때 이를 단일 표현식으로 표현할 수 있다. 

```kotlin

fun singleExpression(){
    var value = express(5, 2)
}

fun express(x: Int = 10, y:Int):Int = x * y

```

- Trailling Comma
  - 소스 비교 명확히 가능 - git 등을 사용하여 코드를 비교할 때 , 는 변화로 잡지 않기 때문에 값의 변화에 집중할 수 있습니다.
  - 순서 재정렬이 편함 - 함수, enum 등에서 재정렬할때 , 를 신경쓰지 않아도 됩니다.
  - 코드 자동생성 만들 시 편함 - 마지막 파라미터일 때는 ,를 뺀다라는 로직이 필요없으므로 코드 자동생성을 만들때 좋습니다.

```kotlin

fun traillingComma(
        x: Int = 10,
        y: Int,
    ): Int {
        return x * y
    }

```

##### **Variables**  

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

Properties에서 사용될 때,    

Kotlin의 클래스에서 프로퍼티는 Mutable(변경가능 - var) 또는 Read-Only(읽기전용 - val)로 사용 가능하다.  

```kotlin

class Address {
    var name: String = "Holmes, Sherlock"
    var street: String = "Baker"
    var city: String = "London"
    var state: String? = null
    var zip: String = "123456"
}

fun copyAddress(address: Address): Address {
    val result = Address() // there's no 'new' keyword in Kotlin
    result.name = address.name // accessors are called
    result.street = address.street
    // ...
    return result
}

```

##### **Classes**  

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

- class 생성시, 

```kotlin

class Sample2(firstName: String){
    val firstProperty = "First property: $firstName".also(::println)

    init {
        println("First initializer block that prints $firstName")
    }

    val secondProperty = "Second property: ${firstName.length}".also(::println)

    init {
        println("Second initializer block that prints ${firstName.length}")
    }
}

```

- class에서 다중 supertype을 지정하고, 할당받는 변수의 타입에 따라 특정 supertype에 맞춰 호출할 수 있음

```kotlin

open class A(x: Int) {
    public open val y: Int = x
}

interface B {
    fun calculate() : Int
}

val ab: B = object : A(1), B {
    override val y = 15

    override fun calculate(): Int = y * 400
}

```

##### **String Templates** 과 문자열 처리

- 문자열 템플릿의 경우, "" 내에서 달러 표시 및 {} 의해서 코틀린 문법 및 변수를 매핑할 수 있다. 
- 문자열 템플릿이 자바에 비해 직관적으로 바인딩 및 표시가 가능하다. 

```kotlin

fun main() {
    StringTemplate()

    forLoopForEachStringCharacter()

    applyUppercase()

    stringLiteral()

    trimMargin()

    displayPrice()
}

private fun StringTemplate() {
    var a = "1"

    var s1 = "a is $a"

    a = "2"

    val s2 = "${s1.replace("is", "was")}, but now is $a"

    println(s2)
}

fun forLoopForEachStringCharacter(){
    val str = "abcd 123"

    for (c in str) {
        println(c)
    }
}

fun applyUppercase(){
    val str = "abcd"
    println(str.uppercase()) // Create and print a new String object
    println(str) // the original string remains the same
}

fun stringLiteral(){
    val text = """
    for (c in "foo")
        print(c)
"""

    println(text)
}

fun trimMargin(){
    val text = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()

    println(text)
}

fun displayPrice(){
    val price = """
${'$'}_9.99
"""

    println(price)
}
```

##### **Conditional Expression**

- 함수를 정의하는 시점에 if-else 내에 추가적인 처리 없이 하나의 값을 반환할 때는 {} 없이 선언 및 사용이 가능하다. 

```kotlin
fun main() {
    println(maxOf1(10, 20))

    println(maxOf2(10, 20))

    println(maxOf3(30,40))
}

fun maxOf1(a: Int, b:Int) = if ( a > b ) a else b

fun maxOf2(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun maxOf3(a: Int, b: Int): Int {
    val max = if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }

    return max
}
```

##### **For Loop**

 - for loop를 사용하는 방식 
   - downTo, step, until 

```kotlin

fun main() {
    forLoopLogic()

    forLoopLogic2()

    forLoopLogic3()
    
    println()

    forLoopLogic4()

    println()

    forLoopLogic5()
}

fun forLoopLogic(){
    val items = listOf("apple", "banana", "kiwifruit")

    for (item in items) {
        println(item)
    }
}

fun forLoopLogic2(){
    val items = listOf("apple", "banana", "kiwifruit")
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

fun forLoopLogic3(){
    var index = 30
    for ( i in 1..index)
        print(i)
}

fun forLoopLogic4(){
    var index = 30
    for ( i in 1..index step 3)
        print(i)
}

fun forLoopLogic5(){
    var index = 30
    for ( i in index downTo 1 step 2)
        print(i)
}

```

##### **While Loop**

```kotlin

fun main() {
    whileLoopLogic()
}

fun whileLoopLogic(){
    val items = listOf("apple", "banana", "kiwifruit")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

```

##### **When Expression**

```kotlin

fun main() {
    println(describe(1))

    println(describe("1"))
}

// Object로 파라미터를 받아 when 절에서 타입과 값에 따라 체크가 가능함.
fun describe(obj: Any): String =
    when (obj) {
        1          -> "One"
        "1"        -> "StringOne"
        "Hello"    -> "Greeting"
        is Long    -> "Long"
        !is String -> "Not a string"
        else       -> "Unknown"
    }

```

##### **Ranges**  

```kotlin

fun main() {
    rangeLogic()

    rangeLogic2()

    rangeWithIterator()

    rangeWithProgression()

    println()

    rangeWithClass()
}

fun rangeLogic(){
    val x = 9
    var y = 10

    if(x in 1..y+1){
        println("fits in range")
    }

}

fun rangeLogic2(){
    val list = listOf("a", "b", "c")

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }
}

fun rangeWithIterator(){
    for (x in 1..5) {
        print(x)
    }
}

fun rangeWithProgression(){
    for (x in 1..10 step 2) {
        print(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
}

fun rangeWithClass(){
    val versionRange = Version(1, 11)..Version(1, 30)
    println(Version(0, 9) in versionRange)
    println(Version(1, 20) in versionRange)
}

class Version(val major: Int, val minor: Int): Comparable<Version> {
    override fun compareTo(other: Version): Int {
        if (this.major != other.major) {
            return this.major - other.major
        }
        return this.minor - other.minor
    }
}

```

##### **Collections**

```kotlin

fun main() {
    collectionsWithForIn()

    collectionWithIn()

    collectionWithFilterMapLoop()
}

fun collectionsWithForIn(){
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }
}

fun collectionWithIn(){
    val items = setOf("apple", "banana", "kiwifruit")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
}


fun collectionWithFilterMapLoop(){
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }
}

```

##### **Null Value/Check**   

```kotlin

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct1(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // ...
    if (x == null) {
        println("Wrong number format in arg1: '$arg1'")
        return
    }
    if (y == null) {
        println("Wrong number format in arg2: '$arg2'")
        return
    }

    // x and y are automatically cast to non-nullable after null check
    println(x * y)
}


fun printProduct2(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // Using `x * y` yields error because they may hold nulls.
    if (x != null && y != null) {
        // x and y are automatically cast to non-nullable after null check
        println(x * y)
    }
    else {
        println("'$arg1' or '$arg2' is not a number")
    }
}

fun main() {
    printProduct1("6", "7")
    printProduct1("99", "b")
    printProduct1("a", "7")


    printProduct2("6", "7")
    printProduct2("99", "b")
    printProduct2("a", "7")
}

```

##### **Type Check**      

```kotlin

fun getStringLength1(obj: Any): Int? {
    if (obj is String) {
        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }

    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}

fun getStringLength2(obj: Any): Int? {
    // `obj` is automatically cast to `String` on the right-hand side of `&&`
    if (obj is String && obj.length > 0) {
        return obj.length
    }

    return null
}

fun main() {
    fun printLength(obj: Any) {
        println("Getting the length of '$obj'. Result: ${getStringLength1(obj) ?: "Error: The object is not a string"} ")
    }

    printLength("Incomprehensibilities")
    printLength(1000)
    printLength(listOf(Any()))

    fun printLength2(obj: Any) {
        println("Getting the length of '$obj'. Result: ${getStringLength2(obj) ?: "Error: The object is not a string"} ")
    }

    printLength2("Incomprehensibilities")
    printLength2(1000)
    printLength2(listOf(Any()))
}

```

# Idioms

**POJOs/POCOs**

```kotlin

// auto making getter for variables in data class, It is better than lombok of java
// val -> get
// var -> get, set
data class Sample(val name : String, var age : Int){

    var testValue : Int = 0;
}

data class Data1(val name : String)
data class Data2(var name : String)

fun main() {
    val sample = Sample("Hong Gil Dong", 50)

    sample.testValue = 20

    println(sample.testValue)

    val data = Data1("GilDong")

    // we cannot reassign variables with "val"
    println(data.name)
    println(data.toString())

    // copy object from data with new assigned value
    var data1 = data.copy("Gil dong1")

    println(data.hashCode())
    println(data.toString())
    println(data1.hashCode())
    println(data1.toString())

    // TODO - when copy data from dataVar1, I thought it is deep copy, because hashcode between two objects was different. but it not sure. need to check it more
    val dataVar1 = Data1("A")
    var dataVar2 = dataVar1.copy("B")

    println(dataVar1.hashCode())
    println(dataVar1.toString())

    println(dataVar2.hashCode())
    println(dataVar2.toString())

    // Destructuring Value
    // 변수를 data class 에서 가져올 때, 해당 객채에서 각각의 변수를 구조 분해 할당 방식으로 아래 코드와 같이 가져올 수 있다. 우리나라 말로는 좀 어려운 뜻으로 느껴지네..
    val ( a, b ) = sample
    println(a)
    println(b)
}

// HashCode 
// 객체 해시 코드란 객체를 식별할 하나의 정수 값을 말한다.
// Object는 클래스의 최상위 타입이고 Object의 hashCode() 메서드는 객체의 메모리 번지를 이용해서 해시 코드를
// 만들어 리턴하기 때문에 객체마다 다른 값을 가지게 된다.

```

**Default Value**  


```kotlin

package bong.lines.idioms

fun main() {
    println(foo( b = "1241243"))
}

fun foo(a : Int = 10, b: String = ""):String{
    return "$a is $b";
}

``` 

**Filter** 

```kotlin

val valueList = listOf(1,2,3,4,5,6,7,8,9,10)

val filteredList = valueList.filter { x -> x > 5 }

println("$filteredList is a List")

val filteredListValues = valueList.filter { it > 5 }

println("$filteredListValues is a List")

```

**Check Presence of en element in a collection**

```kotlin

fun main() {
    val valueList = listOf("value@gmail.com", "john@example.com", "bong@gmail.com")

    if("bong@gmail.com" in valueList){
        println(valueList)
    }

    if("bongvalue@gmail.com" in valueList){
        println(valueList)
    }
}

```

**String Interpolation**

```kotlin

fun main() {
    val name = "Bong!"

    println("Name $name")
}

```

**Instance Checks**

```kotlin

fun main() {
    val x: String = "Foo"

    var value: XValue = XValue();

    when (value){
        is XValue -> println("Print value is $x ${value.testValue()}")
    }

}

class XValue {
    fun testValue() :String {

        println("Test!!")

        return "String Value"
    }
}

```

**Read-only DataStructure** 

```kotlin

val list = listOf("a", "b", "c")

val map = mapOf("a" to 1, "b" to 2, "c" to 3)

```

**Access Map Entry**

```kotlin

println(map["key"])
map["key"] = value

```

**Traverse a map or a list of pairs**

```kotlin

for ((k, v) in map) {
    println("$k -> $v")
}

```

**Iterate over a range**

```kotlin

fun main(){
    for (i in 1..100) {
        println(i)
    }  // closed range: includes 100

    for (i in 1 until 100) {
        println(i)
    } // half-open range: does not include 100

    for (x in 2..10 step 2) {
        println(x)
    }

    for (x in 10 downTo 1) {
        println(x)
    }

    (1..10).forEach {
        run {
            println(it)
        }
    }
}

```

**Lazy Property**

```kotlin

fun main() {
    /*

    1. lazy()는 람다를 전달받아 저장한 Lazy<T> 인스턴스를 반환합니다.
    2. 최초 getter 실행은 lazy()에 넘겨진 람다를 실행하고, 결과를 기록합니다.
    3. 이후 getter 실행은 기록된 값을 반환합니다.

    즉, lazy는 프로퍼티의 값에 접근하는 최초 시점에 초기화를 수행하고 이 결과를 저장한 뒤 기록된 값을 재반환하는 인스턴스를 생성하는 함수입니다.

    Link : https://medium.com/til-kotlin-ko/kotlin-delegated-property-by-lazy%EB%8A%94-%EC%96%B4%EB%96%BB%EA%B2%8C-%EB%8F%99%EC%9E%91%ED%95%98%EB%8A%94%EA%B0%80-74912d3e9c56

     */
    val p: String by lazy {
        "Value"
    }

    print(p)
}

```

**Extension functions**

```kotlin

fun String.spaceToCamelCase() { ... }

"Convert this to camelcase".spaceToCamelCase()

```

**Create a Singleton**

```kotlin

package bong.lines.idioms

// 선언은 object로 사용은 별도의 생성자 없이 사용한다. 
object Resource{
    val name = "Name"
}

// 생성자를 통해 요소를 주입하고 싶을때 사용할 수 있다. 
class Singleton private constructor() {

   companion object {
      @Volatile private var instance: Singleton? = null

      @JvmStatic fun getInstance(): Singleton =
         instance ?: synchronized(this) {
            instance ?: Singleton().also {
               instance = it
            }
         }
   }
}

fun main() {
    print(Resource.name)
}

```

**Instantiate an abstract class**

```kotlin

abstract class MyAbstractClass {
    abstract fun doSomething()
    abstract fun sleep()
}

fun main() {
    val myObject = object : MyAbstractClass() {
        override fun doSomething() {
            // ...
        }

        override fun sleep() { // ...
        }
    }
    myObject.doSomething()
}
```

**If-not-null shorthand**

```kotlin
package bong.lines.idioms

import java.io.File

fun main() {
    val files = File("C:\\Users\\shjeong-PC\\Downloads").listFiles();

    println(files?.size)
}
```

**If-not-null-else shorthand**

```kotlin
package bong.lines.idioms

import java.io.File

fun main() {
    val files = File("C:\\Users\\shjeong-PC\\Downloads").listFiles();

    println(files?.size ?: "empty")
}
```

**Execute a statement if null**

```kotlin

package bong.lines.idioms

fun main() {
    val values: MutableMap<String, String> = mutableMapOf();
    val email = values["email"] ?: throw IllegalStateException("Email is missing!")

    println(email)
}

```

**Execute if not null**

```kotlin
package bong.lines.idioms

fun main() {
    val value: String = "value"

    value?.let { it ->
        println(it)
    }
}
```

**Map nullable value if not null**

```kotlin
package bong.lines.idioms

fun main() {
    var value:String? = "value"

    value = null

    val mapped = value?.let {  } ?: "hahahahhaha"

    println("Good ${mapped} " )
}
```

**Return on when statement**

```kotlin
package bong.lines.idioms

fun transform(color: String): Int {
    return when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }
}

fun main() {
    println(transform("Red"))
}
```

**try-catch expression**

```kotlin
package bong.lines.idioms

fun main() {
    val result = try {
        count()
    } catch (e : Exception){
        throw Exception(e)
    }

    println(result)
}

fun count(): Int {
    return 1000
}
```

**if expression**

```kotlin
package bong.lines.idioms

fun main() {

    val x : Int = 1

    val y = if ( x == 1) {
        "ONE"
    } else if ( x == 2) {
        "TWO"
    } else {
        "OTHER"
    }

    println(y)
}
```

**Builder-style usage of methods that return Unit**

```kotlin
package bong.lines.idioms

fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply { fill(-1) }
}

fun main() {
    println(arrayOfMinusOnes(100))
}
```

**Single-expression functions**

```kotlin
package bong.lines.idioms

fun theAnswer() = 42

fun main() {
    println(theAnswer())
}
```

**Call multiple methods on an object instance (with)**

```kotlin
package bong.lines.idioms

class Turtle {
    fun penDown(){
        println("pen Down")
    }
    fun penUp(){
        println("pen Up")
    }
    fun turn(degrees: Double){
        println(degrees)
    }
    fun forward(pixels: Double){
        println(pixels)
    }
}

fun main() {
    val myTurtle = Turtle()
    with(myTurtle) { //draw a 100 pix square
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }
}
```

**Configure properties of an object (apply)**

```kotlin
package bong.lines.idioms

class Rectangle {
    var length: Int? = null
    var breadth: Int? = null
    var color: Int? = null
}

// TODO 이거 공부하자 - https://medium.com/@limgyumin/%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%9D%98-apply-with-let-also-run-%EC%9D%80-%EC%96%B8%EC%A0%9C-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94%EA%B0%80-4a517292df29

/*
    - 수신 객체
    - 수신 객체 지정 람다

    also

        T 의 확장함수로 수신 객체가 암시적으로 제공됩니다.
        수신 객체 지정 람다 에 매개변수 T 로 코드 블록 내에 명시적으로 전달 됩니다.
        코드 블록 내에 전달된 수신객체를 그대로 다시 반환 합니다.

    with

       수신 객체가 매개 변수 T 로 제공됩니다. 이를 명시적으로 제공된 수신 객체 라고 합니다.
       수신 객체 지정 람다 가 T 의 확장함수 형태로 코드 블록 내에 수신 객체가 암시적으로 전달 됩니다.
       람다를 실행한 결과를 반환 합니다.
 */
val myRectangle = Rectangle().apply {
    length = 4
    breadth = 5
    color = 0xFAFAFA
}

class PersonA(val nameValue: String, var ageValue:Int = 50) {
    var name: String? = nameValue
    var age: Int? = ageValue
}

fun main() {

    myRectangle.breadth

    val personA: PersonA = PersonA("SHJeong");
    with(personA){
        println(name)
        println(age)
    }
}

/*

apply 사용 규칙
수신 객체 람다 내부에서 수신 객체의 함수를 사용하지 않고 수신 객체 자신을 다시 반환 하려는 경우에 apply 를 사용합니다.
수신 객체 의 프로퍼티 만을 사용하는 대표적인 경우가 객체의 초기화 이며, 이곳에 apply 를 사용합니다.
val peter = Person().apply {
    // apply 의 블록 에서는 오직 프로퍼티 만 사용합니다!
    name = "Peter"
    age = 18
}

also 사용 규칙
수신 객체 람다가 전달된 수신 객체를 전혀 사용 하지 않거나 수신 객체의 속성을 변경하지 않고 사용하는 경우 also 를 사용합니다.
also 는 apply 와 마찬가지로 수신 객체를 반환 하므로 블록 함수가 다른 값을 반환 해야하는 경우에는 also 를 사용할수 없습니다.
예를 들자면, 객체의 사이드 이팩트를 확인하거나 수신 객체의 프로퍼티에 데이터를 할당하기 전에 해당 데이터의 유효성을 검사 할 때 매우 유용합니다.
class Book(author: Person) {
    val author = author.also {
      requireNotNull(it.age)
      print(it.name)
    }
}

let 사용 규칙
다음과 같은 경우에 let 을 사용합니다.
지정된 값이 null 이 아닌 경우에 코드를 실행해야 하는 경우.
Nullable 객체를 다른 Nullable 객체로 변환하는 경우.
단일 지역 변수의 범위를 제한 하는 경우.
getNullablePerson()?.let {
    // null 이 아닐때만 실행됩니다.
    promote(it)
}
val driversLicence: Licence? = getNullablePerson()?.let {
    // nullable personal객체를 nullable driversLicence 객체로 변경합니다.
    licenceService.getDriversLicence(it)
}
val person: Person = getPerson()
getPersonDao().let { dao ->
    // 변수 dao 의 범위는 이 블록 안 으로 제한 됩니다.
    dao.insert(person)
}

with 사용 규칙
Non-nullable (Null 이 될수 없는) 수신 객체 이고 결과가 필요하지 않은 경우에만 with 를 사용합니다.
val person: Person = getPerson()
with(person) {
    print(name)
    print(age)
}

run 사용 규칙
어떤 값을 계산할 필요가 있거나 여러개의 지역 변수의 범위를 제한하려면 run 을 사용합니다.
매개 변수로 전달된 명시적 수신객체 를 암시적 수신 객체로 변환 할때 run ()을 사용할수 있습니다.
val inserted: Boolean = run {
    // person 과 personDao 의 범위를 제한 합니다.
    val person: Person = getPerson()
    val personDao: PersonDao = getPersonDao()
    // 수행 결과를 반환 합니다.
    personDao.insert(person)
}
fun printAge(person: Person) = person.run {
    // person 을 수신객체로 변환하여 age 값을 사용합니다.
    print(age)
}
 */
```

**Java 7's try-with-resources**

```kotlin
package bong.lines.idioms

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val stream = Files.newInputStream(Paths.get("D:\\Users\\dream\\test\\logs\\s_starter\\logback.log"))
    stream.buffered().reader().use { reader ->
        println(reader.readText())
    }
}
```

**Nullable Boolean**

```kotlin
package bong.lines.idioms

fun main() {
    val b: Boolean? = null
    if (b == true) {
        println("not null")
    } else {
        println("null")
    }
}
```

**Swap two variables**

```kotlin
package bong.lines.idioms

fun main() {
    var a = 1
    var b = 2
    a = b.also { b = a }

    println("Answer is ${a}")
}
```

**Mark code as incomplete (TODO)**

```kotlin
package bong.lines.idioms

import java.math.BigDecimal

fun calcTaxes(): BigDecimal = TODO("Waiting for feedback from accounting")

fun main() {
    calcTaxes()
}
```

