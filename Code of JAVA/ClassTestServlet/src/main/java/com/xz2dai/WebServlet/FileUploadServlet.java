package com.xz2dai.WebServlet;

import org.w3c.dom.Text;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

@WebServlet(name = "FileUploadServlet",urlPatterns = {"/fileUpload.do"})
@MultipartConfig(location = "d:\\",fileSizeThreshold = 1024)
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = this.getServletContext().getRealPath("/");
        String mnumber = req.getParameter("mnumber");
        Part p = req.getPart("filename");

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<font color='#0000ff");
        if(p.getSize() > 1024*1024){
            p.delete();
            out.println("文件太大，不能上传");
        }else{
            path = path + "\\student\\" +mnumber;
            File f = new File(path);
            if(!f.exists()){
                f.mkdir();
            }
            String header = p.getHeader("content-disposition");

            String fname = getFileName(header);
            p.write(path+"\\"+fname);
            out.println("文件上传成功");
        }
        out.println("</body></html>");
    }
    //通用获取文件路径的方法 getFileName
    /**
     * 根据请求头解析出文件名 请求头的格式：火狐和 google 浏览器下： form data;
     name="file";
     * filename="snmp4j api.zip" IE 浏览器下： form data; name="file";
     * filename=" snmp4j api.zip"
     *
     * @param header
     * 请求头
     * @return 文件名
     **/

    public String getFileName(String header) {
/**
 * String[] tempArr1 =
 * header.split(";");代码执行完之后，在不同的浏览器下，tempArr1数组里面的内容稍有区别
 * 火狐或者google浏览器下：
 * tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
 * IE浏览器下：tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
 */
        String[] tempArr1 = header.split(";");
/**
 * 火狐或者google浏览器下：tempArr2={filename,"snmp4j--api.zip"}
 * IE浏览器下：tempArr2={filename,"E:\snmp4j--api.zip"}
 */
        String[] tempArr2 = tempArr1[2].split("=");
// 获取文件名，兼容各种浏览器的写法
        String fileName = tempArr2[1].substring(
                tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
        return fileName;
    }

}
