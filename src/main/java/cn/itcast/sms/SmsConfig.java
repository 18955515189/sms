package cn.itcast.sms;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="alidayu.sms")
public class SmsConfig {
	
	private String appkey;//应用key
	private String secret;//秘钥
	private String freeSignName;//签名
	
	public String getAppkey() {
		return appkey;
	}
	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getFreeSignName() {
		return freeSignName;
	}
	public void setFreeSignName(String freeSignName) {
		this.freeSignName = freeSignName;
	}
	
	
	

}
