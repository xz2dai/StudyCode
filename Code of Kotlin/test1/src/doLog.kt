import java.io.File
import java.nio.file.Path
import java.time.Month
import java.util.*
import javax.xml.crypto.Data

/*
一个用于写日志的类
 */

object doLog {
    var nowtime:Calendar = Calendar.getInstance()
    private val Logpath:String = "D:/"
    private var date:String = nowtime.get(Calendar.YEAR).toString()+"-"+nowtime.get(Calendar.MONTH+1).toString()+"-"+nowtime.get(Calendar.DATE).toString()
    private var time:String = nowtime.get(Calendar.HOUR_OF_DAY).toString()+"-"+nowtime.get(Calendar.MINUTE).toString()+"-"+nowtime.get(Calendar.SECOND).toString()
    private var file:File = File(Logpath+ date+".txt")
    //添加日志
    fun addLog(msg:String,type:String){
        correctTime()
        //日期-时间-类名-类型[Info]-问题
        file.appendText(date+"-"+time+"-"+type.toUpperCase()+":"+msg)
    }
    //新建日志
    fun newLog():File{
        var m_file:File = File(Logpath)
        if(!m_file.exists()){
            m_file.mkdirs()
        }
        //日期
        if(file.exists()){
            return file
        }else{
            file.createNewFile()
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