package cn.itcast.sms;

import javax.annotation.Resource;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

import cn.itcast.member.entity.Sms;

@Component
public class Consumer {
	
	@Resource
	private SmsConfig smsConfig;
	
	
	@JmsListener(destination="itcast.sms")
	public void sendSms(Sms sms){
		
		try {
			String url="http://gw.api.taobao.com/router/rest";
			TaobaoClient client = new DefaultTaobaoClient(url, smsConfig.getAppkey(), smsConfig.getSecret());
			AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
			req.setExtend( "" );
			req.setSmsType( "normal" );
			
			req.setSmsFreeSignName(smsConfig.getFreeSignName()  );//签名
			req.setSmsParamString(sms.getParamString() );//参数字符串
			req.setRecNum( sms.getPhone());//手机号
			req.setSmsTemplateCode( sms.getTemplatCode() );//短信代码
			AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);//发送短信
			System.out.println(rsp.getBody());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
