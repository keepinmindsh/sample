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


