# Kotlin 

## https://kotlinlang.org/docs/getting-started.html#create-your-powerful-application-with-kotlin


## https://kotlinlang.org/docs/basic-syntax.html

### Kotlin Basic 

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

