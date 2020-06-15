import java.io.File
import java.nio.file.Path
import java.time.Month
import java.util.*
import javax.xml.crypto.Data

/*
һ������д��־����
 */

object doLog {
    var nowtime:Calendar = Calendar.getInstance()
    private val Logpath:String = "D:/"
    private var date:String = nowtime.get(Calendar.YEAR).toString()+"-"+nowtime.get(Calendar.MONTH+1).toString()+"-"+nowtime.get(Calendar.DATE).toString()
    private var time:String = nowtime.get(Calendar.HOUR_OF_DAY).toString()+"-"+nowtime.get(Calendar.MINUTE).toString()+"-"+nowtime.get(Calendar.SECOND).toString()
    private var file:File = File(Logpath+ date+".txt")
    //�����־
    fun addLog(msg:String,type:String){
        correctTime()
        //����-ʱ��-����-����[Info]-����
        file.appendText(date+"-"+time+"-"+type.toUpperCase()+":"+msg)
    }
    //�½���־
    fun newLog():File{
        var m_file:File = File(Logpath)
        if(!m_file.exists()){
            m_file.mkdirs()
        }
        //����
        if(file.exists()){
            return file
        }else{
            file.createNewFile()
            return file
        }
    }
    //��־����
    fun LogisExists():Boolean{
        return file.exists()
    }
    //ɾ����־
    fun delLog(){
        file.delete()
    }
    //��ȡ��ַ
    fun getLogPath():Path{
        return file.toPath()
    }
    fun correctTime(){
        nowtime = Calendar.getInstance()
        date = nowtime.get(Calendar.YEAR).toString()+"-"+nowtime.get(Calendar.MONTH+1).toString()+"-"+nowtime.get(Calendar.DATE).toString()
        time = nowtime.get(Calendar.HOUR_OF_DAY).toString()+"-"+nowtime.get(Calendar.MINUTE).toString()+"-"+nowtime.get(Calendar.SECOND).toString()
    }
}