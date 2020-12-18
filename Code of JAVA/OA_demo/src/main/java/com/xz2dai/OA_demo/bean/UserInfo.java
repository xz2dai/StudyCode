package com.xz2dai.OA_demo.bean;

import com.xz2dai.OA_demo.Utils.StringUtils;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author yq
 * @date 2020年12月15日
 */
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 3787840712864705471L;
	
	private String id;// 用户id
	private String account;// 登录名
	private String password;// 密码
	private String realName;// 真实姓名
	private Integer gender;// 性别【性别 0：男 1：女 2：未知】
	private Integer age;// 年龄
	private String mobile;// 手机号码
	private String email;// 邮箱地址
	private String birthday;// 出生日期【格式：xx-xx】
	private String identity;// 身份证号码
	private Date entryTime;// 入职时间
	private Integer status;// 状态【0：试用期 1：正式员工 2：离职】
	private Date createTime;// 创建时间

	private String entryTimeStr;

	public String getEntryTimeStr() {
		return entryTimeStr;
	}

	// 日期格式
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public void setEntryTimeStr(String entryTimeStr) {
		this.entryTimeStr = entryTimeStr;

		try {
			// 将字符串的日期转成Date类型的日期
			entryTime = sdf.parse(entryTimeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public String getGenderStr() {
		// 性别【性别 0：男 1：女 2：未知】
		if (gender == 0) {
			return "男";
		}
		if (gender == 1) {
			return "女";
		}
		return "未知";
	}

	public String getStatusStr() {
		// 状态【0：试用期 1：正式员工 2：离职】
		return (status == 0) ? "试用期" : (status == 1 ? "正式员工" : "离职");
	}

	public String getBirthdayStr() {
		String year = StringUtils.isEmpty(identity) ? "" : identity.substring(6, 10);
		return year + "-" + birthday;
	}
	// 必须保留无参构造器
	public UserInfo() {
	}

	public UserInfo(String id, String account, String password, String realName, Integer gender, Integer age,
			String mobile, String email, String birthday, String identity, Date entryTime, Integer status,
			Date createTime) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.realName = realName;
		this.gender = gender;
		this.age = age;
		this.mobile = mobile;
		this.email = email;
		this.birthday = birthday;
		this.identity = identity;
		this.entryTime = entryTime;
		this.status = status;
		this.createTime = createTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", account=" + account + ", password=" + password + ", realName=" + realName
				+ ", gender=" + gender + ", age=" + age + ", mobile=" + mobile + ", email=" + email + ", birthday="
				+ birthday + ", identity=" + identity + ", entryTime=" + entryTime + ", status=" + status
				+ ", createTime=" + createTime + "]";
	}

}
