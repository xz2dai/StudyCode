import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.net.URL
import java.net.URLConnection

fun main(){
    val getimg = PixivDownloader()
    getimg.GetIMG("82429481")
}

class PixivDownloader {

        fun GetIMG(pvid:String,name:String? = "test"){
            val savePath:String = "D:\\image\\"
            var uri:String = "https://pixiv.cat/$pvid.jpg"
            download(uri, "$name.jpg",savePath)
        }
        @Throws(Exception::class)
        fun download(urlString: String?, filename: String = "test.jpg", savePath: String? = "D:\\image\\") {
            // 构造URL
            val url = URL(urlString)
            // 打开连接
            val con: URLConnection = url.openConnection()
            //设置请求超时为5s
            con.setConnectTimeout(2 * 1000)
            // 输入流
            val `is`: InputStream = con.getInputStream()

            // 1K的数据缓冲
            val bs = ByteArray(1024)
            // 读取到的数据长度
            var len: Int
            // 输出的文件流
            val sf = File(savePath)
            if (!sf.exists()) {
                sf.mkdirs()
            }
            val os: OutputStream = FileOutputStream(sf.path + "\\" + filename)
            // 开始读取
            while (`is`.read(bs).also { len = it } != -1) {
                os.write(bs, 0, len)
            }
            // 完毕，关闭所有链接
            os.close()
            `is`.close()
        }

}