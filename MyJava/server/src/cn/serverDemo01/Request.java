package cn.serverDemo01;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 封装Request
 * @author YR
 *
 */
public class Request {
    //请求方式
    private String method;
    //请求资源
    private String url;
    //请求参数
    private Map<String,List<String>> parameterMapValues;
    
    //内部
    public static final String CRLF = "\r\n";
    private InputStream is;
    private String requestInfo;
    
    public Request(){
	method = "";
	url = "";
	parameterMapValues = new HashMap<>();
	requestInfo = "";
    }
    public Request(InputStream is){
	this();
	this.is = is;
	try {
	    byte[] data = new byte[20480];
	    int len;
	    len = is.read(data);
	    requestInfo = new String(data,0,len);
	} catch (IOException e) {
	    return;
	}
	//分析请求信息
	parseRequestInfo();
    }
    //分析请求信息
    private void parseRequestInfo(){
	if(null == requestInfo|| requestInfo.trim().equals("")){
	   return ; 
	}
	String paramString = "";//接收请求参数
	//1、获取请求方式
	String firstLine = requestInfo.substring(0,requestInfo.indexOf(CRLF));
	int idx = requestInfo.indexOf("/");// /的位置
	this.method = firstLine.substring(0,idx).trim();
	String urlStr = firstLine.substring(idx,firstLine.indexOf("HTTP/")).trim();
	if(this.method.equalsIgnoreCase("post")){
	    this.url = urlStr;
	    paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
	}
	else if(this.method.equalsIgnoreCase("get")){
	    if(urlStr.contains("?")){	//是否存在参数
		String[] urlArray = urlStr.split("\\?");
		this.url = urlArray[0];
		paramString = urlArray[1];//接收请求参数
	    }else{
		this.url = urlStr;
	    }
	}
	//2、将请求参数封装到Map中
	if(paramString.equals("")){
	    return;
	}
	parseParams(paramString);
    }
    private void parseParams(String paramString){
	//分割 ，将字符串转成数组
	StringTokenizer token = new StringTokenizer(paramString,"&");
	while(token.hasMoreTokens()){
	    String keyValue = token.nextToken();
	    String[] keyValues = keyValue.split("=");
	    if(keyValues.length==1){
		keyValues = Arrays.copyOf(keyValues, 2);
		keyValues[1] = null;
	    }
	    String key = keyValues[0].trim();
	    String value = null== keyValues[1]?null:keyValues[0].trim();
	    //转换成Map
	    if(parameterMapValues.containsKey(key)){
		parameterMapValues.put(key,new ArrayList<String>());
	    }
	    List<String> values = parameterMapValues.get(key);
	    values.add(value);
	}
    }
    //根据页面name获取多个值
    public String[] getParameterValues(String name){
	
	List<String> values = null;
	if((values=parameterMapValues.get(name))==null){
	    return null;
	}else{
	    return values.toArray(new String[0]);
	}
    }
    //更具页面name获取单个值
    public String getParameter(String name){
	String[] values = getParameterValues(name);
	if(null==values){
	    return null;
	}
	return values[0];
    }
}
