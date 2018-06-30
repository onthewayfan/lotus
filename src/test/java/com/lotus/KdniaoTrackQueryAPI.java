package com.lotus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * 快递鸟物流轨迹即时查询接口
 *
 * @技术QQ群: 456320272
 * @see: http://www.kdniao.com/YundanChaxunAPI.aspx
 * @copyright: 深圳市快金数据技术服务有限公司
 *
 * DEMO中的电商ID与私钥仅限测试使用，正式环境请单独注册账号
 * 单日超过500单查询量，建议接入我方物流轨迹订阅推送接口
 *
 * ID和Key请到官网申请：http://www.kdniao.com/ServiceApply.aspx
 */
public class KdniaoTrackQueryAPI {
    //DEMO
    public static void main(String[] args) {
        KdniaoTrackQueryAPI api = new KdniaoTrackQueryAPI();
        // "STO", "3343794984730" ;  YZPY , 9891592339928
//		try {
//			String result = api.getOrderTracesAnonByJson("STO", "3343794984730");
//			System.out.print(result);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		try {
//			String result = api.discernOrderByJson("BE961955006HK");
//			System.out.print(result);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}


        try {
            String result = api.getOrderTracesByJson("STO", "3343794984730");
            System.out.print(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //电商ID  1313230
    private String EBusinessID="1313230";
    //电商加密私钥，快递鸟提供，注意保管，不要泄漏  0c234cba-2c1d-4233-baec-0726488d64b0
    private String AppKey="0c234cba-2c1d-4233-baec-0726488d64b0";
    //请求url 即时
    private String AnonReqURL="http://api.kdniao.cc/Ebusiness/EbusinessOrderHandle.aspx";
    //请求url 订阅接口
    private String SubscribeReqURL="http://api.kdniao.cc/api/dist";

    private String SubscribeReqURL_test="http://testapi.kdniao.cc:8081/api/dist";


    /**
     * Json方式 单号识别
     * @throws Exception
     */
    public String discernOrderByJson(String expNo) throws Exception{
        String requestData= "{'OrderCode':'','LogisticCode':'" + expNo + "'}";

        Map<String, String> params = new HashMap<String, String>();
        String RequestType = "2002";
        params = buildParam(requestData,RequestType);
        String result=sendPost(AnonReqURL, params);

        //根据公司业务处理返回的信息......

        return result;
    }


    /**
     * Json方式 查询订单物流轨迹 (即时查询)
     * @throws Exception
     */
    public String getOrderTracesAnonByJson(String expCode, String expNo) throws Exception{
        String requestData= "{'OrderCode':'','ShipperCode':'" + expCode + "','LogisticCode':'" + expNo + "'}";

        Map<String, String> params = new HashMap<String, String>();
        String RequestType = "1002";
        params = buildParam(requestData,RequestType);
        String result=sendPost(AnonReqURL, params);

        //根据公司业务处理返回的信息......

        return result;
    }

    /**
     * Json方式 查询订单物流轨迹 (物流轨迹查询)   res 服务不可用
     * @throws Exception
     */
    public String getOrderTracesByJson(String expCode, String expNo) throws Exception{
        String requestData= "{'OrderCode':'','ShipperCode':'" + expCode + "','LogisticCode':'" + expNo + "'}";

        Map<String, String> params = new HashMap<String, String>();
        String RequestType = "1008";
        params = buildParam(requestData,RequestType);
        String result=sendPost(SubscribeReqURL, params);

        //根据公司业务处理返回的信息......

        return result;
    }


    /**
     * 组装系统级参数
     * @param requestData 请求内容需进行URL(utf-8)编码。请求内容JSON格式，须和DataType一致
     * @param RequestType  请求指令类型
     * @return
     * @throws Exception
     */
    public Map<String, String> buildParam(String requestData,String RequestType) throws Exception{
        Map<String, String> params = new HashMap<String, String>();
        params.put("RequestData", urlEncoder(requestData, "UTF-8"));
        params.put("EBusinessID", EBusinessID); //商户ID
        params.put("RequestType", RequestType);
        String dataSign=encrypt(requestData, AppKey, "UTF-8");
        params.put("DataSign", urlEncoder(dataSign, "UTF-8")); //数据内容签名：把(请求内容(未编码)+AppKey)进行MD5加密，然后Base64编码，最后 进行URL(utf-8)编码
        params.put("DataType", "2"); //请求、返回数据类型
        return params;
    }

    /**
     * MD5加密
     * @param str 内容
     * @param charset 编码方式
     * @throws Exception
     */
    @SuppressWarnings("unused")
    private String MD5(String str, String charset) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes(charset));
        byte[] result = md.digest();
        StringBuffer sb = new StringBuffer(32);
        for (int i = 0; i < result.length; i++) {
            int val = result[i] & 0xff;
            if (val <= 0xf) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(val));
        }
        return sb.toString().toLowerCase();
    }

    /**
     * base64编码
     * @param str 内容
     * @param charset 编码方式
     * @throws UnsupportedEncodingException
     */
    private String base64(String str, String charset) throws UnsupportedEncodingException{
        String encoded = base64Encode(str.getBytes(charset));
        return encoded;
    }

    @SuppressWarnings("unused")
    private String urlEncoder(String str, String charset) throws UnsupportedEncodingException{
        String result = URLEncoder.encode(str, charset);
        return result;
    }

    /**
     * 电商Sign签名生成
     * @param content 内容
     * @param keyValue Appkey
     * @param charset 编码方式
     * @throws UnsupportedEncodingException ,Exception
     * @return DataSign签名
     */
    @SuppressWarnings("unused")
    private String encrypt (String content, String keyValue, String charset) throws UnsupportedEncodingException, Exception
    {
        if (keyValue != null)
        {
            return base64(MD5(content + keyValue, charset), charset);
        }
        return base64(MD5(content, charset), charset);
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * @param url 发送请求的 URL
     * @param params 请求的参数集合
     * @return 远程资源的响应结果
     */
    @SuppressWarnings("unused")
    private String sendPost(String url, Map<String, String> params) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn =(HttpURLConnection) realUrl.openConnection();
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // POST方法
            conn.setRequestMethod("POST");
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.connect();
            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            // 发送请求参数
            if (params != null) {
                StringBuilder param = new StringBuilder();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    if(param.length()>0){
                        param.append("&");
                    }
                    param.append(entry.getKey());
                    param.append("=");
                    param.append(entry.getValue());
                    //System.out.println(entry.getKey()+":"+entry.getValue());
                }
                //System.out.println("param:"+param.toString());
                out.write(param.toString());
            }
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result.toString();
    }


    private static char[] base64EncodeChars = new char[] {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '+', '/' };

    public static String base64Encode(byte[] data) {
        StringBuffer sb = new StringBuffer();
        int len = data.length;
        int i = 0;
        int b1, b2, b3;
        while (i < len) {
            b1 = data[i++] & 0xff;
            if (i == len)
            {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[(b1 & 0x3) << 4]);
                sb.append("==");
                break;
            }
            b2 = data[i++] & 0xff;
            if (i == len)
            {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
                sb.append(base64EncodeChars[(b2 & 0x0f) << 2]);
                sb.append("=");
                break;
            }
            b3 = data[i++] & 0xff;
            sb.append(base64EncodeChars[b1 >>> 2]);
            sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
            sb.append(base64EncodeChars[((b2 & 0x0f) << 2) | ((b3 & 0xc0) >>> 6)]);
            sb.append(base64EncodeChars[b3 & 0x3f]);
        }
        return sb.toString();
    }



}
