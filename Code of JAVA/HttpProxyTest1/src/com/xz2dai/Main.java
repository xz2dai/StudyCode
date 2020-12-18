package com.xz2dai;

import javax.net.ssl.HttpsURLConnection;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class Main {
    private static final String proxyHost = "cn4.mydarkcloud.info";
    private static final int proxyPort = 11788;
    private static final String proxyUser = "xz2dai@163.com";
    private static final String proxyPass = "UYnldb2Ulbzv";

    public static void main(String[] args) {
        String url = "https://www.google.com/";
        String content = DoProxy(url);
        System.out.println("Result :===================\n " + content);

    }

    public static String DoProxy(String targetUrl){
        System.setProperty("http.proxySet", "true");
        System.setProperty("http.proxyHost", proxyHost);
        System.setProperty("http.proxyPort", "" + proxyPort);
        // 针对https也开启代理
        System.setProperty("https.proxyHost", proxyHost);
        System.setProperty("https.proxyPort", "" + proxyPort);
        // 设置默认校验器
        BasicAuthenticator auth = new BasicAuthenticator(proxyUser, proxyPass);
        Authenticator.setDefault(auth);

        //开始请求
        try {
            URL u = new URL(targetUrl);
            URLConnection conn = u.openConnection();
            HttpsURLConnection httpsCon = (HttpsURLConnection) conn;
            httpsCon.setFollowRedirects(true);

            String encoding = conn.getContentEncoding();
            if (encoding.isEmpty()) {
                encoding = "UTF-8";
            }
            InputStream is = conn.getInputStream();
            String content = Arrays.toString(is.readAllBytes());
            return content;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

}
