import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.net.Socket

/*
Author：星辰玄光
Tips：此类仅适用于客户端
 */

class Connect {
    //普通数据交互接口
    private val sc: Socket? = null

//    //图片交互接口
//    private val ImageSocket: Socket? = null

    //普通交互流
    private var dout: OutputStream? = null
    private var din: InputStreamReader? = null

//    //图片交互流
//    private val imageInputStream: InputStream? = null
//    private val imageFileOutputSteam: DataOutputStream? = null

    //已连接标记
    var isConnect = false
//    var ImageConncet = false




    /**
     * 初始化普通交互连接
     */
    fun InitConnect(){
        try {
            val sc:Socket = Socket(ip, port) //通过socket连接服务器
            val din = InputStreamReader(sc.getInputStream(), "gb2312")  //获取输入流并转换为StreamReader，约定编码格式
            val dout =OutputStreamWriter(sc.getOutputStream())    //获取输出流
            sc.setSoTimeout(10000)  //设置连接超时限制
            if (sc != null && din != null && dout != null) {    //判断一下是否都连上，避免NullPointException
                isConnect = true
                System.out.println("connect server successful")
            } else {
                System.out.println("connect server failed,now retry...")
                InitConnect()
            }
        } catch (e: IOException) {      //获取输入输出流是可能报IOException的，所以必须try-catch
            e.printStackTrace()
        }
    }
    
    /**
     * 发送数据至服务器
     * @param message 要发送至服务器的字符串
     */
    fun sendMessage(message: String?) {
        var message = message
        try {
            if (isConnect) {
                if (dout != null && message != null) {        //判断输出流或者消息是否为空，为空的话会产生nullpoint错误
                    message = """
                        $message

                        """.trimIndent() //末尾加上换行让服务器端有消息返回
                    val me = message.toByteArray()
                    dout!!.write(me)
                    dout!!.flush()
                } else {
                    System.out.println("The message to be sent is empty or have no connect")
                }
                System.out.println("send message successful")
            } else {
                System.out.println("no connect to send message")
            }
        } catch (e: IOException) {
            System.out.println("send message to cilent failed")
            e.printStackTrace()
        }
    }

    fun receiveMessage(): String? {
        var message: String? = ""
        try {
            if (isConnect) {
                System.out.println("开始接收服务端信息")
                val inMessage = CharArray(1024)     //设置接受缓冲，避免接受数据过长占用过多内存
                val a = din!!.read(inMessage) //a存储返回消息的长度
                if (a <= -1) {
                    return null
                }
                System.out.println("reply length:$a")
                message = String(inMessage, 0, a) //必须要用new string来转换
                System.out.println(message)
            } else {
                System.out.println("no connect to receive message")
            }
        } catch (e: IOException) {
            System.out.println("receive message failed")
            e.printStackTrace()
        }
        return message
    }

    /**
     * 关闭连接
     */
    public fun CloseConnect() {
        try {
            if (din != null) {
                din!!.close()
            }
            if (dout != null) {
                dout!!.close()
            }
            if (sc != null) {
                sc!!.close()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        isConnect = false
        System.out.println("关闭连接")
    }

    companion object {
        //服务端地址及接口
        private const val ip = "127.0.0.1"  //本地服务端地址
        private const val port = 2333
    }
}