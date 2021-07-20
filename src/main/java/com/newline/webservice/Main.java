package com.newline.webservice;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.handlers.soap.SOAPService;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) {
        try {
            // 直接引用远程的wsdl文件地址，如http://www.baidu.com/myService/serviceTest
            String endpoint = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";

            Service service = new Service();

            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new URL(endpoint));
            call.setOperationName(new QName("http://WebXml.com.cn","getWeatherbyCityName"));// WSDL里面描述的接口名称
            call.addParameter("theCityName",
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);// 接口的参数

            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型
//            call.setReturnClass(Object[].class);
            call.setUseSOAPAction(true);
            call.setSOAPActionURI("http://WebXml.com.cn/getWeatherbyCityName");
//            Object[] result = (Object[]) call.invoke(new Object[] { "重庆"});// 必须和addParameter方法中设置的参数类型一致
            // 给方法传递参数，并且调用方法
            Object result = (Object) call.invoke(new Object[] {"重庆"});
            System.out.println("result is " + result);
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
