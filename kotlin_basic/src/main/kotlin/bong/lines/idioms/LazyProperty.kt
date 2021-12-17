package bong.lines.idioms

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