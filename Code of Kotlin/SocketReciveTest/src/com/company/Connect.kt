package com.company

import java.io.*
import java.net.Socket

/*
Author：YQ
Tips：此类仅适用于服务端
 */

class Connect
/**
 * 构造函数
 */
public constructor(socket: Socket) {
    //普通数据交互接口
    private var sc: Socket? = socket

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
    public fun InitConnect() {
        try {
            //sc = Socket(ip, port) //通过socket连接服务器
            din = InputStreamReader(sc!!.getInputStream(), "gb2312")
            dout = sc!!.getOutputStream()
            sc!!.soTimeout = 10000
            if (sc != null && din != null && dout != null) {
                isConnect = true
                println("connect cilent successful")
            } else {
                println("connect cilent failed,now retry...")
                InitConnect()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

//        /**
//         * 初始化图片上传接口
//         */
//        public void InitImageIO(){
//            try {
//                ImageSocket = new Socket(ip,imageUploadPort);
//                if(ImageSocket.isConnected()){      //判断是否已连接
//                    imageFileOutputSteam = new DataOutputStream(ImageSocket.getOutputStream());
//                    if(imageFileOutputSteam != null){
//                        imageInputStream = ImageSocket.getInputStream();
//                        if(imageInputStream!=null){
//                            ImageConncet = true;
//                            System.out.println("ImageIO Ready");
//                        }
//                    }else{
//                        System.out.println("imageOutputStream is null");
//                    }
//                }else{
//                    System.out.println("image socket init failed");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public void CloseImageIO(){
//            if(ImageSocket.isConnected()){
//                try {
//                    ImageSocket.close();
//                    if(imageFileOutputSteam != null)
//                        imageFileOutputSteam.close();
//                    if(imageInputStream != null)
//                        imageInputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(ImageSocket.isClosed()){
//                ImageConncet = false;
//                System.out.println("ImageUpLoad Close");
//            }
//        }
//
//
//        /**
//         * 上传图片
//         * 上传图片前必须传输用户信息，必须包含有name
//         */
//        public boolean UploadImage(Bitmap image_toSend){
//            try {
//                InitImageIO();      //收发图片接口用完即关
//                if(ImageConncet){
//                    System.out.println("start send image");
//                    image_toSend.compress(Bitmap.CompressFormat.PNG, 100, imageFileOutputSteam);        //把图片按参数压缩后压入输出流
//                    imageFileOutputSteam.flush();
//                    Thread.sleep(1000);             //休眠一下线程等待传输完成
//                    System.out.println("send image successful");
//                    CloseImageIO();
//                    return true;
//                }else{
//                    System.out.println("Init imageIO failed");
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            System.out.println("send image failed");
//            return false;
//        }
//
//        /**
//         * 图片输入
//         * @return 返回收到的bitmap图片
//         */
//        public Bitmap ReceiveImage(){
//            Bitmap image_receive = null;
//            try{
//                InitImageIO();
//                if(ImageConncet){
//                    try {
//                        Thread.sleep(2000);     //发送获取头像申请后要等待客户端上传图片
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                    System.out.println("start receive image message");
//                    image_receive = BitmapFactory.decodeStream(imageInputStream);       //从流中获取图片
//                    if(image_receive!=null)
//                        System.out.println("receive image successful");
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//            CloseImageIO();
//            return image_receive;
//        }
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
                    println("The message to be sent is empty or have no connect")
                }
                println("send message successful")
            } else {
                println("no connect to send message")
            }
        } catch (e: IOException) {
            println("send message to cilent failed")
            e.printStackTrace()
        }
    }

    fun receiveMessage(): String? {
        var message: String? = ""
        try {
            if (isConnect) {
                println("开始接收客户端信息")
                val inMessage = CharArray(1024)
                val a = din!!.read(inMessage) //a存储返回消息的长度
                if (a <= -1) {
                    return null
                }
                println("reply length:$a")
                message = String(inMessage, 0, a) //必须要用new string来转换
                println(message)
            } else {
                println("no connect to receive message")
            }
        } catch (e: IOException) {
            println("receive message failed")
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
        println("关闭连接")
    }

    companion object {
        //客户端地址及接口
        //    private String ip = "120.79.87.21";
        //    private int imageUploadPort = 5423; //图片交互接口
        //    private int port = 5422;    //普通交互接口
        private const val ip = "127.0.0.1"
        private const val port = 2333
    }
}