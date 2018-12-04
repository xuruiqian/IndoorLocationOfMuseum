package com.minusone.indoorlocationofmuseum.utilities;

import android.util.Log;

public class WebServicesUtil {
    /**
     * 手机号段归属地查询
     *
     * @param phoneSec 手机号段
     */
//    public String getRemoteInfo(String phoneSec) throws Exception {
//        String WSDL_URI = "http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx?WSDL";//wsdl 的uri
//        String namespace = "http://WebXml.com.cn/";//namespace
//        String methodName = "getMobileCodeInfo";//要调用的方法名称
//
//        SoapObject request = new SoapObject(namespace, methodName);
//        // 设置需调用WebService接口需要传入的两个参数mobileCode、userId
//        request.addProperty("mobileCode", phoneSec);
//        request.addProperty("userId", "");
//
//        //创建SoapSerializationEnvelope 对象，同时指定soap版本号(之前在wsdl中看到的)
//        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapSerializationEnvelope.VER12);
//        envelope.bodyOut = request;//由于是发送请求，所以是设置bodyOut
//        envelope.dotNet = true;//由于是.net开发的webservice，所以这里要设置为true
//
//        HttpTransportSE httpTransportSE = new HttpTransportSE(WSDL_URI);
//        httpTransportSE.call(null, envelope);//调用
//
//        // 获取返回的数据
//        SoapObject object = (SoapObject) envelope.bodyIn;
//        // 获取返回的结果
//        result = object.getProperty(0).toString();
//        Log.d("debug", result);
//        return result;
//
//    }
}
