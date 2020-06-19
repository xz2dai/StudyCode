package com.company

import jdk.nashorn.internal.ir.RuntimeNode
import sun.misc.Request
import java.io.File
import java.lang.Exception
import java.nio.file.Path
import java.time.Month
import java.util.*
import javax.xml.crypto.Data
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder

/*
一个用于写日志的类
 */

object doLog {
    var nowtime:Calendar = Calendar.getInstance()
    //private val Logpath:String =
    private val Logpath:String = "/www/server/tomcat/webapps/"
    private var date:String = nowtime.get(Calendar.YEAR).toString()+"-"+nowtime.get(Calendar.MONTH+1).toString()+"-"+nowtime.get(Calendar.DATE).toString()
    private var time:String = nowtime.get(Calendar.HOUR_OF_DAY).toString()+"-"+nowtime.get(Calendar.MINUTE).toString()+"-"+nowtime.get(Calendar.SECOND).toString()
    private lateinit var file:File
    //添加日志
    fun addLog(msg:String,type:String="info"){
        try {
            if(file.canWrite()){
                correctTime()
                //日期-时间-类名-类型[Info]-问题
                file.appendText(date+"-"+time+"-"+type.toUpperCase()+":"+msg+"\n")
            }else{
                println("can not write to file!")
            }
            println(msg)
        }catch (e:Exception){
            e.printStackTrace()
            println(e.message)
        }
    }
    //新建日志
    fun newLog():File{
        file = File(Logpath+ "TestServerLog.txt")
        var m_file:File = File(Logpath)
        if(!m_file.exists()){
            m_file.mkdirs()
        }
        //日期
        if(file.exists()){
            return file
        }else{
            file.createNewFile()
            file.setWritable(true)
            return file
        }
    }
    //日志存在
    fun LogisExists():Boolean{
        return file.exists()
    }
    //删除日志
    fun delLog(){
        file.delete()
    }
    //获取地址
    fun getLogPath():Path{
        return file.toPath()
    }
    fun correctTime(){
        nowtime = Calendar.getInstance()
        date = nowtime.get(Calendar.YEAR).toString()+"-"+nowtime.get(Calendar.MONTH+1).toString()+"-"+nowtime.get(Calendar.DATE).toString()
        time = nowtime.get(Calendar.HOUR_OF_DAY).toString()+"-"+nowtime.get(Calendar.MINUTE).toString()+"-"+nowtime.get(Calendar.SECOND).toString()
    }
}