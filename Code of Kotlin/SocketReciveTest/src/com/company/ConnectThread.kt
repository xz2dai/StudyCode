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

            println("thread start:"+this.name)
            message = ct.receiveMessage()
            if (message == null) {
                println("error:null cilent message ")
                return
            }
            println("recived cilent message:$message")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val type = getDisposeType(message)
        if(type != null){
            println("get message type:$type")
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
        var type: String
        type = jsonData!!.get("type").toString()
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
                        println("get id:$id")
                        password = jsonData!!["password"] as String?
                        println("get password:$password")
                        login(id, password)
                    }
                }
                "updata" -> {
                    println("get updata type，but no method find")
                }
                else -> {
                    println("none type get!")
                }
            }
        }
    }

    private fun login(id: String?, password: String?) {
        var sendData = ""
        println("login successful")
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
        println("user data：" + jsonUser.toJSONString())
        sendData = jsonUser.toJSONString()
        try {
            out!!.write("""
    $sendData
    
    """.trimIndent())
            out!!.flush()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        println("send user data successful!")
    }

    companion object {
        var jsonData: JSONObject? = null
    }

}