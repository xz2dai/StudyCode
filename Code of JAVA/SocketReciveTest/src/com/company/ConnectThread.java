package com.company;

import com.alibaba.fastjson.JSONObject;
import com.company.bean.TestPack;


import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class ConnectThread extends Thread{
	BufferedReader input;
	private BufferedWriter out = null;
	private Socket sc;

	static JSONObject jsonData = null;

	String message;

	public ConnectThread(Socket sc) {
		this.sc = sc;
	}
	
	@Override
	public void run()  {
		try {
			System.out.println("thread start");
			input = new BufferedReader(new InputStreamReader(sc.getInputStream(), StandardCharsets.UTF_8));
			out = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream(), StandardCharsets.UTF_8));
			message = input.readLine();
			if(message == null){
				System.out.println("error:null cilent message ");
				interrupt();
			}
			System.out.println("recived cilent message:"+message);
			out.write("message recived\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String type = getDisposeType(message);
		System.out.println("get message type:"+type);
		disposeOperation(type);
	}


	public String getDisposeType(String message)  {

			if(message == null || message.equals("")){
				return null;
			}
			jsonData = JSONObject.parseObject(message);
			String type;
			type = String.valueOf(jsonData.get("type"));
			return type;
	}
	

	private void disposeOperation(String type) {
		if(type != null) {
			switch (type) {
			case "search":{
				if(jsonData.get("login") != null) {
					login();
				}
				break;
			}
			case "updata":{
				System.out.println("get updata type，but no method find");
				break;
			}
			default:{
				System.out.println("none type get!");
				break;
			}
			}	
		}
	}


	private void login() {

				System.out.println("login successful");
				TestPack user = new TestPack();
				user.setId(10086);
				user.setInformation("Test information");
				JSONObject jsonUser = (JSONObject)JSONObject.toJSON(user);
				System.out.println("user data："+jsonUser.toJSONString());
				try {
					out.write(jsonUser.toJSONString()+"\n");
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("send user data successful!");


	}

}
