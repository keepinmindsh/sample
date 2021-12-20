package bong.lines.basic.generics

class MutableStack<E>(vararg items: E) {              // 1

    private val elements = items.toMutableList()

    fun push(element: E) = elements.add(element)        // 2

    fun peek(): E = elements.last()                     // 3

    fun pop(): E = elements.removeAt(elements.size - 1)

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    override fun toString() = "MutableStack(${elements.joinToString()})"
}

fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

fun <T> singletonList(item: T): List<T> {
    // ...
    return ArrayList<T>()
}

fun <T> T.basicToString(): String { // extension function
    // ...

    return "test"
}


fun main() {

    // 예제 1

    val mutableStack:MutableStack<Double> = MutableStack(0.62, 3.14, 2.7, 9.87)

    println(mutableStack.peek())

    println(mutableStack.pop())

    println(mutableStack.pop())

    println(mutableStack.pop())

    println(mutableStack.pop())

    // 예제 2

    val stack = mutableStackOf(0.62, 3.14, 2.7)
    println(stack)

    // 예제 3

    val l1 = singletonList<Int>(1)

    l1.basicToString()

    val l2 = singletonList(1)
}