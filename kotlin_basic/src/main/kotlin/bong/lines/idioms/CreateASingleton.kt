package bong.lines.idioms

object Resource{
    val name = "Name"
}

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

    val singleton = Singleton.getInstance()

}