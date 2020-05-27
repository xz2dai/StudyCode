fun main(args:Array<String>) {
    Test().just()
}

class Test {
    //var变量  val常量

    val items = setOf("apple", "banana", "kiwi")

    var a:String? = "123"
    var aa:String? = """
        第一行
        第二行
        第三行
    """.trimIndent()
    var b:Int = a!!.toInt()+1;

    val max = if(a!!.toInt() < b) a else b



    fun sun(a:Int,b:Int) = a + b


    fun just(){
        for(i in 0 until 100){
            print(i);
        }
    }

    fun many(vararg v:Int){     //可变长参数函数
        for(vt in v){
            print(vt)
        }
    }

    fun ez(){
        if(max in 100..200){
            print("ciallo")
        }

        when(max){
            123 -> println("yep123")
            124 -> println("yep124")
            0,1 -> println("0 or 1")
            in 10..100 -> println("in 10..100")
            a is String,"apple" in items -> println("magic!")
            else ->{
                print("nope")
            }
        }

        for (item in items) println(item)

        val items = listOf("apple", "banana", "kiwi")
        for (index in items.indices) println("item in $index is ${items[index]}")
    }

    val SunLambda : (Int,Int) -> Int = {x,y -> x+y}  //lambda匿名函数
}

class Hello(val name:String){

    fun hello(){

        println("hello!$name")
    }
}