package com.company

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.company.bean.UserOrdinary
import java.io.*
import java.net.Socket
import java.nio.charset.StandardCharsets
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class ConnectThread(private val sc: Socket) : Thread() {
    var input: BufferedReader? = null
    var out: BufferedWriter? = null
    var message: String? = null
    var reply:String? = null
    override fun run() {
        val ct:Connect = Connect(sc)
        ct.InitConnect()
        try {
            doLog.addLog("thread start:"+this.name)
            doLog.addLog("客户端ip地址是："+sc.getInetAddress());
            message = ct.receiveMessage()
            if (message == null) {
                doLog.addLog("error:null cilent message ","error")
                return
            }
            doLog.addLog("recived cilent message:$message")
        } catch (e: Exception) {
            e.printStackTrace()
            doLog.addLog(e.toString())
        }
        val type = getDisposeType(message)
        if(type != null){
            doLog.addLog("get message type:$type")
            disposeOperation(type)
        }else{
            when(message){
                "2333","1","ez" ->{
                    reply = "Connected!"
                }
                else ->{

                }
            }
        }
        ct.sendMessage(reply)
        ct.CloseConnect()
    }

    fun getDisposeType(message: String?): String? {
        if (message == null || message == "" || message[0] != '{') {
            return null
        }
        jsonData = JSONObject.parseObject(message)
        val type: String = jsonData!!.get("type").toString()
        return type
    }

    private fun disposeOperation(type: String?) {
        if (type != null) {
            when (type) {
                "search" -> {
                    if (jsonData!!["login"] != null) {
                        var id: String? = ""
                        var password: String? = ""
                        id = jsonData!!["id"] as String?
                        doLog.addLog("get id:$id")
                        password = jsonData!!["password"] as String?
                        doLog.addLog("get password:$password")
                        login(id, password)
                    }
                }
                "updata" -> {
                    doLog.addLog("get updata type，but no method find")
                }
                else -> {
                    doLog.addLog("none type get!")
                }
            }
        }
    }

    private fun login(id: String?, password: String?) {
        var sendData = ""
        doLog.addLog("login successful")
        val testpack = UserOrdinary()
        if (id != null) {
            testpack.id = id.toInt()
        }
        if (password != null) {
            testpack.password = password
        }
        testpack.accountNum = "0000000"
        val jsonUser = JSONObject.toJSON(testpack) as JSONObject
        jsonUser["type"] = "search"
        jsonUser["login"] = "1"
        doLog.addLog("user data：" + jsonUser.toJSONString())
        sendData = jsonUser.toJSONString()
        try {
            out!!.write("""
    $sendData
    
    """.trimIndent())
            out!!.flush()
        } catch (e: IOException) {
            e.printStackTrace()
            doLog.addLog(e.toString())

        }
        doLog.addLog("send user data successful!")
    }

    companion object {
        var jsonData: JSONObject? = null
    }

}