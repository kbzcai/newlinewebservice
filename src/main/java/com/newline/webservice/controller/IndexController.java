package com.newline.webservice.controller;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
//@RequestMapping("/index")
public class IndexController {

    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url) {
        System.out.println(url);
        return url;
    }

    @GetMapping("/show")
    public ModelAndView show(Model model){
        //访问wsdl网址方式获取字符串
//        String url="http://www.webxml.com.cn/WebServices/ChinaStockWebService.asmx?wsdl";
//        HttpMethod method=HttpMethod.GET;
//        MultiValueMap<String,String> params=new LinkedMultiValueMap<>();
//        System.out.println(httpClientService.httpClient(url,method,params));


//        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
//        factory.setAddress("http://www.webxml.com.cn/WebServices/ChinaStockWebService.asmx");
//        factory.setServiceClass(ChinaStockWebServiceHttpGet.class);
//        Object webService = factory.create();
//        ChinaStockWebServiceSoap soap=(ChinaStockWebServiceSoap)webService;
//        //设置客户端的配置信息，超时等.
//        Client proxy = ClientProxy.getClient(webService);
//        HTTPConduit conduit = (HTTPConduit) proxy.getConduit();
//        HTTPClientPolicy policy = new HTTPClientPolicy();
//        policy.setConnectionTimeout(30000); //连接超时时间
//        policy.setReceiveTimeout(180000);//请求超时时间.
//        conduit.setClient(policy);
//        System.out.println(soap.getStockInfoByCode("sh000001"));

//        WeatherWebService webService=new WeatherWebService();
//        WeatherWebServiceSoap soap=webService.getWeatherWebServiceSoap();
//        ArrayOfString info=soap.getSupportProvince();
//        for(String s:info.getString()){
//            System.out.println(s);
//        }
        return new ModelAndView("index");
    }

    @ResponseBody
    @GetMapping("/getInfo/{StationNo}")
    public String getInfo(@PathVariable("StationNo") String stationNo){
        System.out.println(stationNo);
        StringBuffer ss;
//        String urlString="http://localhost:32829/Report/GetDataBystation";
//        BufferedReader br=null;
//        try{
//            //创建url请求
//            URL url=new URL(urlString);
//            //连接请求协议
//            HttpURLConnection _url=(HttpURLConnection)url.openConnection();
//            //设置请求方法
//            _url.setRequestMethod("GET");
//            //设置请求开启连接
//            _url.connect();
//            //写入请求参数,记得把字节流转换成字符流
//            br=new BufferedReader(new InputStreamReader(_url.getInputStream()));//_url.getInputStream()是URL返回的流
//            //实现读入内存的操作
//            String content="";
//            ss=new StringBuffer();
//            while((content=br.readLine())!=null){
//                ss.append(content);
//            }
//            System.out.println("打印输出结果："+ss.toString());
//        }catch(Exception e){
//            throw new RuntimeException(e);
//        }finally{
//            try {
//                br.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        String jsonString="[{\n" +
                "\t\"ID\": 6,    //ID\n" +
                "\t\"Order_Id\": \"165515353\", //工单编号\n" +
                "\t\"MTL_No\": \"31100-T527-000000\", //物料号\n" +
                "\t\"MTL_Name\": \"SR650车架总成（白坯）\",//物料名称\n" +
                "\t\"Tray_Type\": \" CX02-ZCZH-001 \",//托盘类型\n" +
                "\t\"StationNo\": \"1-A\", //工位编号\n" +
                "\t\"Production_Qty\": 100, //计划生产数量\n" +
                "\t\"Actual_Qty\": 0, //实际生产数量\n" +
                "\t\"State\": 0,   //状态 0新建，1已下发,2进行中,3已完成，-1已关闭\n" +
                "\t\"Task_State\": 0, //仓库任务状态 0未下发，1等待，2进行中，3完成，-1失败，-2取消\n" +
                "\t\"Batch\": null,\n" +
                "\t\"Priority\": null, //优先级\n" +
                "\t\"Remark\": null, //备注\n" +
                "\t\"Create_Date\": \"2021-06-20 21:16:49\", //创建时间\n" +
                "\t\"Create_UserId\": \"管理员\",//创建人\n" +
                "\t\"Update_Date\": null,\n" +
                "\t\"Update_UserId\": null,\n" +
                "\t\"Plan_Date\": null,  //计划生产时间\n" +
                "\t\"Actual_Date\": null, //实际生产时间\n" +
                "\t\"Complete_Date\": null //实际完成时间\n" +
                "}, {\n" +
                "\t\"ID\": 7,\n" +
                "\t\"Order_Id\": \"165515353\",\n" +
                "\t\"MTL_No\": \"31100-T527-000000\",\n" +
                "\t\"MTL_Name\": \"SR650车架总成（白坯）\",\n" +
                "\t\"Tray_Type\": \"KL100\",\n" +
                "\t\"StationNo\": \"10-A\",\n" +
                "\t\"Production_Qty\": 100,\n" +
                "\t\"Actual_Qty\": 0,\n" +
                "\t\"State\": 0,\n" +
                "\t\"Task_State\": 0,\n" +
                "\t\"Batch\": null,\n" +
                "\t\"Priority\": null,\n" +
                "\t\"Remark\": null,\n" +
                "\t\"Create_Date\": \"2021-06-20 21:16:49\",\n" +
                "\t\"Create_UserId\": \"管理员\",\n" +
                "\t\"Update_Date\": null,\n" +
                "\t\"Update_UserId\": null,\n" +
                "\t\"Plan_Date\": null,\n" +
                "\t\"Actual_Date\": null,\n" +
                "\t\"Complete_Date\": null\n" +
                "}, {\n" +
                "\t\"ID\": 8,\n" +
                "\t\"Order_Id\": \"165515353\",\n" +
                "\t\"MTL_No\": \"31100-T527-000000\",\n" +
                "\t\"MTL_Name\": \"SR650车架总成（白坯）\",\n" +
                "\t\"Tray_Type\": \"NC450\",\n" +
                "\t\"StationNo\": \"2-A\",\n" +
                "\t\"Production_Qty\": 100,\n" +
                "\t\"Actual_Qty\": 0,\n" +
                "\t\"State\": 0,\n" +
                "\t\"Task_State\": 0,\n" +
                "\t\"Batch\": null,\n" +
                "\t\"Priority\": null,\n" +
                "\t\"Remark\": null,\n" +
                "\t\"Create_Date\": \"2021-06-20 21:16:49\",\n" +
                "\t\"Create_UserId\": \"管理员\",\n" +
                "\t\"Update_Date\": null,\n" +
                "\t\"Update_UserId\": null,\n" +
                "\t\"Plan_Date\": null,\n" +
                "\t\"Actual_Date\": null,\n" +
                "\t\"Complete_Date\": null\n" +
                "}]";
//        JSONArray jsonArray=JSONArray.fromObject(ss.toString());
        JSONArray jsonArray=JSONArray.fromObject(jsonString);
        jsonArray.forEach(System.out::println);
        String jsonStr="";
        for (int i=0;i<jsonArray.size();i++){
            System.out.println(jsonArray.getJSONObject(i).get("StationNo"));
            if(jsonArray.getJSONObject(i).get("StationNo").equals(stationNo)){
                jsonStr=jsonArray.getJSONObject(i).toString();
                System.out.println(jsonStr);
                break;
            }
        }
        return jsonStr;
    }
}
