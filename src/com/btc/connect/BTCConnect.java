package com.btc.connect;

import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.ws.addressing.WsaTubeHelper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.Base64;

public class BTCConnect {
    //RPC服务的用户名，应该与比特币客户端节点的配置文件bitcoin.conf中配置的一样


    //maven:管理和构建项目的依赖和配置
    //依赖的配置：xml文件
    //例如：配置MySQL数据库
    //lib：依赖库
    public static void main(String[] args) {
        System.out.println("Hello World");

        /**
         *  1、准备json-rpc通信的json数据
         *     fastjson.jar
         *  2、使用Java网络通信进行rpc连接
         *     httpclient、 httpcore
         *     请求类型：GET、POST
         *  3、接收java中的http形式的rpc连接的响应
         *  4、处理结果
         */
        JSONObject object = new JSONObject();
        object.put("id", System.currentTimeMillis() + "");
        object.put("jsonrpc","2.0");//rpc服务协议版本
//        object.put("method","getblockcount");
        object.put("method","getblockhash");
        int[] arr = new int[1];
        arr[0] = 1;
        object.put("params", arr);  //调用命令时的传参
        //object.put("Authorization", "Basic " + BcRPCUtils.base64Encode(Constants.RPCUSER + ":" +Constants.RPCPASSWORD));

        String jsonRpcStr = object.toJSONString();
        System.out.println(jsonRpcStr);

        //2、发起一个post类型的网络请求，将第一步准备好的json格式数据发送给rpc 服务器
        //tcp三次握手： client -> server(rpc服务)
        DefaultHttpClient client = new DefaultHttpClient();
        //www.baidu.com -> dns解析ip和端口号
        HttpPost post = new HttpPost(Constants.RPCURL);
        //client执行一个Post请求
        try {
            //设置请求头
            post.addHeader("Encoding", "UTF-8");
            post.addHeader("Content-Type", "application/json");
            post.addHeader("Authorization","Basic "+BcRPCUtils.base64Encode(Constants.RPCUSER +":"+Constants.RPCPASSWORD));
            //entity 实体，
            StringEntity entity = new StringEntity(jsonRpcStr);
            post.setEntity(entity); //设置请求的数据
            HttpResponse response = client.execute(post);  //执行网络，阻塞在当前行
            //请求状态码 200正常
            int code = response.getStatusLine().getStatusCode();
            if (code==200) {
                System.out.println("rpc请连接成功");
                String result = EntityUtils.toString(response.getEntity());
                System.out.println(result);
            } else {
                //UNAUTHORIZED  unauthorized 未授权的

                System.out.println("rpc请求连接失败,状态码是：" + code);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}