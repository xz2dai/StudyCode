package com.xz2dai;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xz2dai.bean.NewMessage;
import com.xz2dai.bean.UserOrdinary;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/*
Authot:YQ
Tips:此类仅适用于客户端
 */

public class Connect {

    //服务端地址及接口
//    private String ip = "120.79.87.21";
//    private int imageUploadPort = 5423; //图片交互接口
//    private int port = 5422;    //普通交互接口

    private final static String ip = "127.0.0.1";
    private final static int port = 2333;

    public static final String TAG = "Connect";     //网络连接调试TAG
    

    //普通数据交互接口
    private Socket sc = null;
    //图片交互接口
    private Socket ImageSocket = null;

    //普通交互流
    private OutputStream dout = null;
    private InputStreamReader din = null;

    //图片交互流
    private InputStream imageInputStream = null;
    private DataOutputStream imageFileOutputSteam = null;
    
    //已连接标记
    public boolean isConnect = false;
    public boolean ImageConncet = false;




    private static Connect ct = new Connect();      //单例模式，装载类时强制初始化


    /**
     * 构造函数
     */
    private Connect(){          //私有化构造函数

    }

    /**
     * 初始化普通交互连接
     */
    private void InitConnect(){
        try {
            sc = new Socket(ip,port);       //通过socket连接服务器
            din = new InputStreamReader(sc.getInputStream(),"gb2312");
            dout = sc.getOutputStream();
            sc.setSoTimeout(10000);
            if(sc!=null && din != null && dout != null){
                isConnect = true;
                System.out.println("connect server successful");
            }else{
                System.out.println("connect server failed,now retry...");
                InitConnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connect getConncet(){
        return ct;
    }       //单例模式获取对象


//    /**
//     * 初始化图片上传接口
//     */
//    public void InitImageIO(){
//        try {
//            ImageSocket = new Socket(ip,imageUploadPort);
//            if(ImageSocket.isConnected()){      //判断是否已连接
//                imageFileOutputSteam = new DataOutputStream(ImageSocket.getOutputStream());
//                if(imageFileOutputSteam != null){
//                    imageInputStream = ImageSocket.getInputStream();
//                    if(imageInputStream!=null){
//                        ImageConncet = true;
//                        System.out.println("ImageIO Ready");
//                    }
//                }else{
//                    System.out.println("imageOutputStream is null");
//                }
//            }else{
//                System.out.println("image socket init failed");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void CloseImageIO(){
//        if(ImageSocket.isConnected()){
//            try {
//                ImageSocket.close();
//                if(imageFileOutputSteam != null)
//                    imageFileOutputSteam.close();
//                if(imageInputStream != null)
//                    imageInputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        if(ImageSocket.isClosed()){
//            ImageConncet = false;
//            System.out.println("ImageUpLoad Close");
//        }
//    }
//
//
//    /**
//     * 上传图片
//     * 上传图片前必须传输用户信息，必须包含有name
//     */
//    public boolean UploadImage(Bitmap image_toSend){
//        try {
//            InitImageIO();      //收发图片接口用完即关
//            if(ImageConncet){
//                System.out.println("start send image");
//                image_toSend.compress(Bitmap.CompressFormat.PNG, 100, imageFileOutputSteam);        //把图片按参数压缩后压入输出流
//                imageFileOutputSteam.flush();
//                Thread.sleep(1000);             //休眠一下线程等待传输完成
//                System.out.println("send image successful");
//                CloseImageIO();
//                return true;
//            }else{
//                System.out.println("Init imageIO failed");
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println("send image failed");
//        return false;
//    }
//
//    /**
//     * 图片输入
//     * @return 返回收到的bitmap图片
//     */
//    public Bitmap ReceiveImage(){
//        Bitmap image_receive = null;
//        try{
//            InitImageIO();
//            if(ImageConncet){
//                try {
//                    Thread.sleep(2000);     //发送获取头像申请后要等待服务端上传图片
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//                System.out.println("start receive image message");
//                image_receive = BitmapFactory.decodeStream(imageInputStream);       //从流中获取图片
//                if(image_receive!=null)
//                    System.out.println("receive image successful");
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        CloseImageIO();
//        return image_receive;
//    }

    /**
     * 发送数据至服务器
     * @param message 要发送至服务器的字符串
     */
    public void sendMessage(String message){
        InitConnect();      //发消息的时候连接服务器，收到消息后关闭
        try {
            if(isConnect){
                if(dout != null && message != null ){        //判断输出流或者消息是否为空，为空的话会产生nullpoint错误
                    message = message + "\n";       //末尾加上换行让服务器端有消息返回
                    byte[] me = message.getBytes();
                    dout.write(me);
                    dout.flush();
                }else{
                    System.out.println("The message to be sent is empty or have no connect");
                }
                System.out.println("send message successful");
            }else{
                System.out.println("no connect to send message");
            }
        } catch (IOException e) {
            System.out.println("send message to server failed");
            e.printStackTrace();
        }
    }

    public String receiveMessage(){
        String message = "";
        try {
            if(isConnect){
                System.out.println("开始接收服务端信息");
                char[] inMessage = new char[1024];
                int a = din.read(inMessage);     //a存储返回消息的长度
                if(a<=-1){
                    return null;
                }
                System.out.println("reply length:"+a);
                message = new String(inMessage,0,a);        //必须要用new string来转换
                System.out.println(message);
            }else{
                System.out.println("no connect to receive message");
            }
        } catch (IOException e) {
            System.out.println("receive message failed");
            e.printStackTrace();
        }
        CloseConnect();     //发消息的时候连接服务器，收到消息后关闭
        return message;
    }


//    /**
//     * 包装search操作类型json数据
//     * @param type 操作类型
//     * @param source 包含信息的javabean
//     * @return 返回source转换的json格式的字符串
//     */
//    public String search(String type, Object source){
//        JSONObject job = null;
//        String jstr = null;
//        System.out.println("开始查找编码操作类型");
//        job = (JSONObject) JSON.toJSON(source);
//        if(source.getClass() != JSONObject.class){      //判断传入的是否已经是jsonobject类型，是的话直接转为字符串返回，不是的话开始编码
//            switch (type){
//                case "login":   //登陆
//                    System.out.println("开始编码login内容");
//                    job.put("login","1");
//                    break;
//                case "newMessage":  //新闻信息查询
//                    System.out.println("开始编码newMessage内容");
//                    job.put("newMessage","1");
//                    break;
//                case "PersonMessage":   //个人信息查询
//                    break;
//                case "creditScore": //信誉积分查询
//                    break;
//                case "stall":   //个人车位查询
//                    break;
//                case "help":    //帮助查询
//                    break;
//                default:
//                    break;
//            }
//            if (job != null) {
//                job.put("type","search");
//                jstr = job.toJSONString();
//                System.out.println("编码成功，编码结果为："+jstr);
//            }
//        }else{
//            jstr = JSON.toJSONString(source);
//            System.out.println("检查到已经是目标类型，直接编码，编码结果为："+jstr);
//        }
//        return jstr;
//    }
//
//    /**
//     * 登陆方法
//     * @param name 用户名
//     * @param password  登陆密码
//     */
//    public boolean login(String name, String password){
//        JSONObject job = new JSONObject();  //创建一个json对象存放login信息
//        job.put("name",name);
//        job.put("password",password);
//        job.put("login","1");
//        job.put("type","search");
//
//        String Msend = search("login",job); //用本类的search方法将json对象转换为json字符串
//        sendMessage(Msend);
//        String reply = "";
//        reply = receiveMessage();    //获取服务器返回信息
//        JSONObject replyjob = null;
//        if(reply!=null && !reply.equals("")){
//            replyjob = JSONObject.parseObject(reply);
//        }
//        if(replyjob!=null && replyjob.get("sign")!=null && replyjob.get("sign").toString().equals("default")){
//            System.out.println("Connect", "login failed");
//            MainActivity.logflag=false;
//            return false;
//        }else if (reply != null && !reply.trim().equals("")) {
//            System.out.println("Connect", "login successful");
//            UserOrdinary uo = JSON.parseObject(reply, UserOrdinary.class);    //将服务器返回的消息解码为user类
//
//            MainActivity.logflag = true;        //设置当前登录状态
//            editor_user.putBoolean("logflag", true);
//            editor_user.putInt("PhoneNum", uo.getPhoneNum());     //保存登录信息，只保存登陆名和密码，下次开启app重新登陆
//            editor_user.putString("Password", uo.getPassword());
//            editor_user.putString("userinfo", reply);
//            editor_user.apply();
//
//            return true;
//        }
//        return false;
//    }
//
//
//    /**
//     * 获取新闻
//     * @param messageId 新闻框id
//     */
//    public NewMessage newMessage(int messageId){
//        JSONObject job = new JSONObject();
//        job.put("messageId",messageId);
//        job.put("newMessage","1");
//        job.put("type","search");
//
//        String Msend = "";
//        Msend = updata("newMessage",job);       //转换为字符串
//        sendMessage(Msend);
//        String reply = "";
//        reply = receiveMessage();    //获取服务器返回信息
//        NewMessage newMessage = new NewMessage();
//        if(reply != null && !reply.trim().equals("")){
//            newMessage = JSON.parseObject(reply,NewMessage.class);       //转换为NewMessage JavaBean
//        }
//        return newMessage;
//    }
//
//    /**
//     * 获取当前账号头像
//     */
//    public Bitmap getHeadPortrait(){
//        System.out.println("start get HeadPortrait");
//        JSONObject job = new JSONObject();
//        job.put("name", String.valueOf(sp_user.getInt("PhoneNum",123)));            //获取保存在本地的账户名
//        job.put("upHeadPortrait","2");
//        job.put("type","search");
//        job.put("password",sp_user.getString("Password","1234"));
//        job.put("login","1");
//
//        String Msend = "";
//        Msend = updata("newMessage",job);       //转换为字符串
//        sendMessage(Msend);
//        String reply = "";
//        reply = receiveMessage();    //获取服务器返回信息
//        Bitmap ReceiveImage = ReceiveImage();
//        try {
//            File file = new File(context.getFilesDir().getPath());
//            File f = new File(file, "head.PNG");
//            f.createNewFile();
//            FileOutputStream fos = new FileOutputStream(f);
//            ReceiveImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
//            fos.flush();
//            System.out.println("Connect", "save HeadPortrait file successful");
//            sp_user.edit().putString("HeadPortraitPath", f.getPath()).apply();       //储存图片储存的路径
//            fos.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return ReceiveImage;
//    }
//
//    /**
//     * 包装update操作类型数据
//     * 参数用法同search方法
//     */
//    public String updata(String type, Object source){
//        JSONObject job = null;
//        String jstr = null;
//        System.out.println("开始查找编码操作类型");
//        job = (JSONObject) JSON.toJSON(source);
//        if(source.getClass() != JSONObject.class){      //判断传入的是否已经是jsonobject类型，是的话直接转为字符串返回，不是的话开始编码
//            switch (type){
//                case "personMessage":   //修改个人信息
//                    break;
//                case "ediget":  //注册账号
//                    job.put("ediget","1");
//                    break;
//                case "updataPassWord":  //修改密码
//                    job.put("updataPassword","1");
//                    break;
//                case "upHeadPortrait":  //修改头像
//                    job.put("upHeadPortrait","1");
//                    break;
//                case "publishStall":    //停车位信息插入
//                    break;
//                default:
//                    break;
//            }
//            if (job != null) {
//                job.put("type","updata");
//                jstr = job.toJSONString();
//                System.out.println("编码成功，编码结果为："+jstr);
//            }
//        }else{
//            jstr = JSON.toJSONString(source);
//            System.out.println("检查到已经是目标类型，直接编码，编码结果为："+jstr);
//        }
//        return jstr;
//    }
//
//    /**
//     * 注册账号
//     * @param phoneNum  用户手机号
//     * @param password  密码
//     * @return  是否注册成功
//     */
//    public boolean Register(String phoneNum, String password){
//        UserOrdinary uo = new UserOrdinary();
//        uo.setPhoneNum(Integer.parseInt(phoneNum));
//        uo.setPassword(password);
//
//
//        String Msend = updata("ediget",uo);
//        sendMessage(Msend);
//        String reply = "";
//        reply = receiveMessage();    //获取服务器返回信息
//        System.out.println("Connect","message received"+reply);
//        JSONObject replyjob = null;
//        if(reply!=null && !reply.equals("")){
//            replyjob = JSONObject.parseObject(reply);
//        }
//        if(replyjob!=null && replyjob.get("sign")!=null && replyjob.get("sign").toString().equals("default")){
//            MainActivity.logflag=false;
//            return false;
//        }else{
//            System.out.println("Connect","register successful");
//            System.out.println("reply:"+reply);
//            UserOrdinary replyuo = JSON.parseObject(reply,UserOrdinary.class);    //将服务器返回的消息解码为user类
//
//            MainActivity.logflag = true;        //设置当前登录状态
//            editor_user.putBoolean("logflag",true);
//            editor_user.putInt("PhoneNum",replyuo.getPhoneNum());     //保存登录信息，只保存登陆名和密码，下次开启app重新登陆
//            editor_user.putString("Password",replyuo.getPassword());
//            editor_user.putString("userinfo",reply);
//            editor_user.apply();
//
//            return true;
//        }
//    }
//
//    /**
//     * 修改密码
//     * @param newPassword 新密码
//     * @return 修改成功返回true
//     */
//    public boolean ChangePassword(String newPassword){      //必须要有type:updata,updataPassword:1,name:账号，newUserMessage：新密码
//        JSONObject uo = new JSONObject();
//        uo.put("name", String.valueOf(sp_user.getInt("PhoneNum",123)));      //获取保存在本地的账户名
//        uo.put("newPassword",newPassword);
//        uo.put("type","updata");
//        uo.put("updataPassword","1");
//        String Msend = updata("updataPassword",uo);     //将jsonObject转换为String
//
//        this.sendMessage(Msend);
//        String reply = "";
//        reply = receiveMessage();    //获取服务器返回信息
//        System.out.println("Connect","message received"+reply);
//        JSONObject replyjob = null;
//        if(reply!=null && !reply.equals("")){
//            replyjob = JSONObject.parseObject(reply);
//        }
//        if(replyjob!=null && replyjob.get("sign")!=null && replyjob.get("sign").toString().equals("default")){
//            MainActivity.logflag=false;
//            return false;
//        }else if(replyjob!=null && replyjob.get("sign")!=null && replyjob.get("sign").toString().equals("success")){
//            System.out.println("Connect", "Changed Password successful");
//            System.out.println( "reply:" + reply);
//
//            //保存修改后的密码
//            editor_user.putString("PassWord",newPassword);
//            String jstr = sp_user.getString("userinfo","");
//            JSONObject job = JSONObject.parseObject(jstr);
//            job.put("Password",newPassword);
//            jstr = job.toJSONString();
//            editor_user.putString("userinfo",jstr);
//            editor_user.apply();
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 修改头像
//     */
//    public void upHeadPortrait(Bitmap bitmap){       //先发送头像更改请求，然后再上传图片
//        JSONObject job = new JSONObject();
//        job.put("name", String.valueOf(sp_user.getInt("PhoneNum",123)));      //获取保存在本地的账户名
//        job.put("type","updata");
//        job.put("upHeadPortrait","1");
//        job.put("password",sp_user.getString("Password","1234"));
//        job.put("login","1");
//
//        String Msend = updata("upHeadPortrait",job);    //先发送修改头像请求
//        sendMessage(Msend);
//        CloseConnect();         //没设置回复直接关闭接口
//        //String reply = receiveMessage();
//        //System.out.println(reply);
//        UploadImage(bitmap);
//
//    }

    /**
     * 关闭连接
     */
    public void CloseConnect(){
        try {
            if(din != null){
                din.close();
            }
            if(dout != null){
                dout.close();
            }
            if(sc != null) {
                sc.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        isConnect = false;
        System.out.println("关闭连接");
    }




}
