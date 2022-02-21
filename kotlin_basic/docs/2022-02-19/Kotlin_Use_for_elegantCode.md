# Kotlin를 활용한 우아한 코드 만들기 

### Elegant Code
  - 쉽고 편하다. 
  - 간결하다. 
  - 명확하다. 
  - 효율적이다. 
  - 안전하다. 
  - 유연하다. 
  - 확장 가능하다. 


### Simple Code 

```java

// Java
view.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View view){
        play();    
    }   
})

```


```java

// Java Lambda 
view.setOnClickListener(v -> play());

```

```kotlin

// kotlin
view.setOnClickListener { play() }

```

OnClick Listener와 동일하게 사용 가능함. infix는 파라미터가 하나여야 하는 제약사항은 존재함. 

```kotlin

// Kotlin infix, Extension Functions 
infix fun View?.click(block : (View) -> Unit) = 
        this?.setOnClickListener(block)

```

```kotlin

// Kotlin
view click { play() }

```

```java

// Java
view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view){
            play();
        }
})

```

DSL를 활용함. 

```kotlin

// kotlin infix, Extensions Functions
infix fun View?.click(block: (View) -> BaseRequest<*>?){
    this?.setOnClickListener {
        block(it)?.let {
            rest(it) {
                start { this@click.isEnabled = false }
                finish { this@click.isEnabled = true }
            }
        }
    }
}

```

Array List 활용 및 예외 처리 

```java

// Java - 아래의 코드는 indexOutOfBound에러가 발생가능함. 
trackList.get(index).play();

// Java 예외 처리 
if ( index >= 0 && index < trackList.size() ) {
    trackList.get(index).play();
}

```

```kotlin

// Kotlin 
if( index in 0 unitil trackList.size){
    trackList[index].play()
}


```

```kotlin

// Kotlin Extensions Functions, Function literals with receiver 
fun <T> List<T>.valid(index: Int, block: T.() -> Unit){
    if (index in 0 until size){
        block(get(index))
    }
}


// 위의 함수를 실제 사용하는 방식 
trackList.valid(index) { play() }

```

RecyclerView에 대한 활용 방식 정의 

```java

public void update(){
    adapter.notifyDataSetChanged()
    Toast.makeText(context, "업데이트.", Toast.LENGTH_SHORT).show();        
}


// 계산 중일 때 아래와 같이 코드에 대하 에외 처리를 한다. 
if(recyclerView.isComputingLayout()) {
    recyclerView.post(() -> update());
}else {
    update();
}

```

RecyclerView에 대한 점검 방식을 Kotlin으로 변환 

```kotlin

infix fun RecyclerView.safe(block: () -> Unit){
    if( isComputingLayout ) { // this는 생략 가능 
        post { block() }
    } else {
        block()
    }
}

recylerView safe {
    adapter.notifyDataSetChanged()
    toast { "업데이트. " }
}

```

```kotlin

// infix, Extensions Functions, Function literals with receiver
infix fun < T : View >  T.access(block: T.() -> Unit) = block()

recyclerView access {
    toast { "업데이트 완료." }
    safe { adapter.notifyDataSetChanged() }    
}

```

커링을 활용한 예제 

```java

// Java
FirebaseLog.getInstance().sendEvent(
        FirebaseEvent.CATEGORY.메인플레이어.get(), 
        FirebaseEvent.ACTION.like.get(),
        FirebaseEvent.LABEL.on.get()
        );

```

Kotlin 변환 

```kotlin

// Kotlin infix, Extensions Functions
infix fun CATEGORY.and(action: ACTION): (LABEL) -> Unit {
    return { label -> FirebaseLog.sendEvent(this, action, label ) }
}

infix fun((LABEL) -> Unit).and(label: LABEL) = this(label)


CATEGORY.메인플레이어 and ACTION.like and LABEL.on 

```

Supplier 활용 

```kotlin
private var context: (() -> Context)? = null

fun supplyContext ( block: () -> Context) {
    context = block 
}


infix fun <T> (() -> t)?.action(block: T.() -> Unit) {
    this?.invoke()?.run{ block(this) }
}


context?.invoke()?.run {
    startActivity(Intent(this, MainActivity::class.java))
}

context action {
    startActivityIntent(this, MainActivity::class.java )
}

```


Valid 변형 및 확장 

```kotlin

infix fun <T> List<T>.valid(index: Int): ( () -> T)? = if( index in 0 until size) {
    { get(index)}
} else null 

trackList.valid( index ) { play() }

// 명시적인 함수 호출 방식 - Valid #2 
trackList valid index action { play() }

```

```kotlin

view find { RecyclerView::class.java } isVisible { true } action { scrollToPostition(0) }

fun dismiss() = popup action { dismiss() }

binding action {
    context action {
        root.startAnimation(animation(this, R.anim,slide))
    }
}

```

Observable 사용 사례 

```java

private Observable.OnPropertyChangedCallback trackCallback = new Observable.OnPropertyChangedCallback() {
    @Override
    public void onPropertyChanged(Observable sender, int id) {
        update();
    }
}

```

```kotlin

private val trackCallBack = object : OnPropertyChangedCallback() {
    override fun onPropertyChanged(sender : Observable, id: Int) {
        udpate()
    }
}

```

Kotlin Delegate 활용 

```kotlin

class CallbackHolder(var callback: OnPropertyChangedCallback) {
    operator fun getValue(ref: Any?, prop:KProperty<*>) = callback
}

fun callback(block : (Int) -> Unit) 
    = CallbackHolder(object : OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender : Observable? , id: Int){
            block(id)
        }
    })

// delegate를 활용한 방식 
private val trackCallback by callback { update() }

```

Kotlin Supplier 활용하기 

- inline reified 의 활용 

```kotlin

class SupplyHolder<T> {
    private var value: (() -> T?)? = null
    fun invoke() = value?.invoke()
    fun setValue(block: () -> T?) {
        value = block 
    }
}

class SupplyDelegate<T>(val holder: SupplyHolder<T>,
                        val type: Class<T> 
                        ) {
    operator fun getValue(ref: Any?, prop: KProperty<*>) = holder
}

// Kotlin inline, Reified type parameters
inline fun <reified T> supply()
    = SupplyDelegate(SupplyHolder(), T::class.java)


// Kotlin infix, Extentions Functions, Function literals with receiver 
infix fun <T> SupplyHolder<T>.action(block: T.() -> Unit)
    = invoke()?.let{ block(it) }

context action {
    startAcitivity(Intent(this, MainActivity::class.java ))
}

inline infix fun <reified T> Any.link(noinline block: () -> T): Any {
    this::class.java.declaredFields.forEach { 
        if(it.type == SupplyDelegate::class.java){
            it.isAccessible = true
            val delegate = it.get(this) as SupplyDelegate<T>
            if(delegate.type == T::class.java){
                delegate.value.setValue(block)
                return this
            }
        }
    }
}


model link { context } link { binding }

```

DSL Pattern 

```kotlin

class KoRest<T>( val request: BaseRequest<T>)

fun <T> KoRest<T>.success(block: (T) -> Unit) = request.onDataReceived(block)

fun <T> KoRest<T>.start(block: () -> Unit) = request.onStart(block)

fun <T> KoRest<T>.finish(block: () -> Unit) = request.onFinish(block)

    ...

fun <T> rest(request: BaseRequest<T>, block: KoRest<T>.() -> Unit) {
    block(KoRest(request))
    request.call()
}

SignManager.login() {
    success {
        save(it)
        showHome()
    }
    
    errors {
        wrongPassword {}
        notFoundId {}
        etc {}
    }
    
    start {}
    finish {}
}

merge {
    rest(UserManager.getMember()) {
        success { updateMember(it) }
        error { error put true }
    }
    
    rest(PassManager.getPass()) {
        success { updatePass(it) }
        map { it.currentPass }
    }
    
    end<MemberDto, PassDto> {
        member, pass -> 
            dismissProgress()
            User.set(member, pass)
    }
}

```


Consumer, Runnable, Supplier, Delegate, Reflection, Generic, HighOrder Function등에 대한 활용 

# 참고 링크 

> [Kotlin을 활용한 우아한 코드 만들기](https://www.youtube.com/watch?v=i0yRFecYk9k)