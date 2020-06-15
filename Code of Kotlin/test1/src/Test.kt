fun main(args:Array<String>) {
    //Test().just()
    doLog.newLog()
    doLog.addLog("test test test","info")
}

class Test {
    //var变量  val常量

    val items = setOf("apple", "banana", "kiwi")

    var a:String? = "123"
    var aa:String? = """
        第一行
        第二行
        第三行
    """.trimIndent()        //多行字符串，后面的方法去掉空格
    var b:Int = a!!.toInt()+1;

    val max = if(a!!.toInt() < b) a else b



    fun sun(a:Int,b:Int) = a + b


    fun just(){     //有上界循环
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

        //判断

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

        //循环

        for (item in items) println(item)

        val items = listOf("apple", "banana", "kiwi")       //列表
        for (index in items.indices) println("item in $index is ${items[index]}")   //foreach
    }

    //lambda使用

    val SunLambda : (Int,Int) -> Int = {x,y -> x+y}  //lambda匿名函数
}

//类构造

class Hello(val name:String){

    fun hello(){

        println("hello!$name")
    }
}

//接口

interface people{
    fun foo();
    fun bar(){
        print("ciallo!")
    }
}

interface hape{
    fun bar(){
        print("hello!")
    }
}

class man:people,hape{
    override fun foo() {
        super<hape>.bar();
        super<people>.bar()
        this.bar()
    }

    override fun bar() {
        super<people>.bar()
        print("konijiwa")
    }
}

//泛型

class box<T>(i:T){
    var value = i
}

fun <T> boxvalue(value:T) = box(value)

fun test2(){
    var box0 = box<Int>(1)
    var boxint = box(1);
    var boxstring = box("a")
    print(boxint.value)
    print(boxstring.value)

    val box1 = boxvalue(1)
    val box2 = boxvalue("a")
}

//枚举类
enum class fruit{
    apple,banana,peach
}

//对象声明
object SITE{
    var name:String = "fk"
    var adress:String = "no1"
}

fun useobject(){        //对象声明可以用于单例模式，接下来的程序输出s1和s2的name是一样的
    var s1 = SITE
    var s2 = SITE
    s1.name = "edo"
    print(s1.name)
    print(s2.name)
}