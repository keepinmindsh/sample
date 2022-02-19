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


# 참고 링크 

> [Elegant Code](https://www.youtube.com/watch?v=i0yRFecYk9k)