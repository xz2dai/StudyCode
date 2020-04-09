package com.company;

import com.alibaba.fastjson.JSONObject;
import com.company.bean.TestPack;
import com.company.bean.UserOrdinary;


import java.beans.ParameterDescriptor;
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
			}
			System.out.println("recived cilent message:"+message);
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
				String id = "",password = "";
				id = (String)jsonData.get("id");
				System.out.println("get id:"+id);
				password = (String)jsonData.get("password");
				System.out.println("get password:"+ password);
				login(id,password);
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


	private void login(String id,String password) {
		String sendData = "";
		System.out.println("login successful");
		UserOrdinary testpack = new UserOrdinary();
		if(id != null){
			testpack.setId(Integer.parseInt(id));
		}
		if(password != null){
			testpack.setPassword(password);
		}
		testpack.setAccountNum("0000000");
		JSONObject jsonUser = (JSONObject)JSONObject.toJSON(testpack);
		jsonUser.put("type","search");
		jsonUser.put("login","1");
		System.out.println("user data："+jsonUser.toJSONString());
		sendData = jsonUser.toJSONString();
		try {
			out.write(sendData+"\n");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("send user data successful!");


	}

}
