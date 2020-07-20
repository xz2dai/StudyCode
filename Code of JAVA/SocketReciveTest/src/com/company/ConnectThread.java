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
			message = input.readLine();		//从连接中读入一行
			if(message == null){
				System.out.println("error:null cilent message ");
			}
			System.out.println("recived cilent message:"+message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String type = getDisposeType(message);		//解析操作类型
		System.out.println("get message type:"+type);
		disposeOperation(type);		//根据类型进行操作
	}


	/**
	 * 获取客户端的操作类型
	 * @param message 客户端发送的字符串消息
	 * @return	操作类型
	 */
	public String getDisposeType(String message)  {
			//在任何操作前都要记得判断对象非空
			if(message == null || message.equals("")){
				return null;
			}
			jsonData = JSONObject.parseObject(message);		//将jsonstring转换为jsonobject
			String type;
			type = String.valueOf(jsonData.get("type"));
			return type;
	}

	/**
	 * 根据操作类型进行操作
	 * @param type	操作类型
	 */
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
				if(jsonData.get("getBookInfo")!=null){
					String bookId = (String)jsonData.get("bookNum");
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

	/**
	 * 登陆操作
	 * @param id	用户id
	 * @param password	用户密码
	 */
	private void login(String id,String password) {
		String sendData = "";
		System.out.println("login successful");
		UserOrdinary testpack = new UserOrdinary();	//要发回的用户消息
		/*
		这两个非空判断只是用于简单测试，实际使用中应该先是在数据库中查询有无对应用户，有的话就查询该用户信息，然后将用户信息打包发回客户端
		 */
		if(id != null){
			testpack.setId(Integer.parseInt(id));
		}
		if(password != null){
			testpack.setPassword(password);
		}
		testpack.setAccountNum("0000000");
		JSONObject jsonUser = (JSONObject)JSONObject.toJSON(testpack);	//javabean转换为jsonstring
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
