package main

import (
	"BTCConnection/src/entity"
	"BTCConnection/src/entity/utils"
	"bytes"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
	"time"
)

//常量
const RPCURL = "http://127.0.0.1:8332"
const RPCUSER = "user"
const RPCPASSWORD = "pwd"

func main() {
	fmt.Println("hello world")

	/**
	* 1、准备进行RPC通信时的JSON数据
	  2、使用http连接的post请求，发送json数据
	  3、接收http响应
	  4、根据响应的结果进行判断处理
	      状态码200正常，非200不正常
	*/

	//1、准备要发送的JSON数据
	//json操作：序列化、反序列化

	rpcReq := entity.RPCRequest{}
	rpcReq.Id = time.Now().Unix()
	rpcReq.Jsonrpc = "2.0"
	rpcReq.Method = "getblockcount" //获取当前节点的区块数量



	//对结构体类型进行序列化
	rpcBytes, err := json.Marshal(&rpcReq)
	if err != nil {
		fmt.Println(err.Error())
		return
	}
	fmt.Println("准备好的json格式的数据", string(rpcBytes))

	//2、发送一个post请求
	//client：客户端，客户端用于发起请求
	client := http.Client{} //先实例化一个请求客户端

	//实例化一个请求
	request, err := http.NewRequest("POST", RPCURL, bytes.NewBuffer(rpcBytes))
	if err != nil {
		fmt.Println(err.Error())
		return
	}

	//给post请求添加请求头设置信息
	//key --> value
	request.Header.Add("Encoding", "UTF-8")
	request.Header.Add("Content-Type", "application/json")
	//权限认证设置
	request.Header.Add("Authorization", "Basic "+utils.Base64Str(RPCUSER+":"+RPCPASSWORD))

	//使用客户端发送请求
	response, err := client.Do(request)
	if err != nil {
		fmt.Println(err.Error())
		return
	}
	//通过response获取相应的数据
	code := response.StatusCode
	if code == 200 {
		fmt.Println("恭喜,请求成功!")
		resultBytes,err := ioutil.ReadAll(response.Body)
		if err != nil {
			fmt.Println(err.Error())
			return
		}
		fmt.Println("rpc调用的响应结果：",string(resultBytes))
		//json的反序列号
		var result entity.RPCResult
		err = json.Unmarshal(resultBytes, &result)
		if err != nil {
			fmt.Println(err.Error())
			return
		}
		//反序列化正常，没错误
		fmt.Println("功能调用结果：",result.Result)
	} else {
		fmt.Println("抱歉，请求失败")
	}

}