package com.btc.connect;

import com.alibaba.fastjson.JSON;
import com.btc.connect.entity.*;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

//service:服务
//rpc服务
public class BTCService {

    private static final Map<String,String> map = new HashMap<>();

    static {
        map.put("Authorization","Basic "+ BcRPCUtils.base64Encode(Constants.RPCUSER+":"+Constants.RPCPASSWORD));
    }

    //新需求： 生成比特币的地址
    /**
     * 生成一个新的比特币地址
     * @param label 标签，可自定义
     * @param address_type 比特币的地址类型，可选项是legacy,p2sh-segwit,bech32
     * @return 返回生成的新的比特币的地址，如果请求失败，返回null
     */
    public String getNewAddress(String label, ADDRESS_TYPE address_type) {
        String type = Constants.getAddressType(address_type);
        String json = BcRPCUtils.prepareJSON(Constants.GETNEWADDRESS,label, type);
        Result result = BcRPCUtils.executePost(map, json);
        if(result==null) {
            return null;
        }
        if (result.getCode()==HttpStatus.SC_OK){
            return result.getData().getResult();
        }
        return null;
    }



    /**
     * 根据区块哈市值获取指定区块的信息
     * @param hash  区块的hash
     * @return   区块的信息，查询失败返回null
     */
    public BlockData getBlockByHash(String hash) {
        String json = BcRPCUtils.prepareJSON(Constants.GETBLOCKBYHASH,hash);
        Result result = BcRPCUtils.executePost(map, json);
        if(result==null) {
            return null;
        }
        if (result.getCode()==HttpStatus.SC_OK){//正常
            return JSON.parseObject(result.getData().getResult(), BlockData.class);
        }
        return null;
    }


    //需求：获取指定高度的区块的hash

    /**
     * 获取指定高度的区块hash
     * @param height  指定高度
     * @return  区块的hash值，请求失败返回null;
     */
    public String getBlockHashByHeight(int height) {
        String json = BcRPCUtils.prepareJSON(Constants.GETBLOCKHASHBYHEIGHT, height);
        Result result = BcRPCUtils.executePost(map, json);
        if(result == null) {
            return null;
        }
        if(result.getCode()==HttpStatus.SC_OK){
            return result.getData().getResult();
        }
        return null;
    }

    /**
     * 作业1：查询挖矿信息
     * @return  获取挖矿信息，请求失败返回null;
     */
    public String getMiningInfo () {
        String json = BcRPCUtils.prepareJSON(Constants.GETMININGINFO);
        Result result = BcRPCUtils.executePost(map, json);
        if(result==null){
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String info = result.getData().getResult();
            return result.getData().getResult();
        }
            return null;
    }

    /**
     * 作业2：获取已连接数量
     * @return   获取链接数量，请求失败返回null;
     */
   public String connectionCount () {
       String json = BcRPCUtils.prepareJSON(Constants.CONNECTIONCOUNT);
       Result result = BcRPCUtils.executePost(map, json);
       if(result==null){
           return null;
       }
       if (result.getCode() == HttpStatus.SC_OK) {
           return result.getData().getResult();

       }
       return null;
   }

    /**
     * 作业3：获取peerinfo
     * @return  请求不成功返回null
     */
    public String peerInfo() {
        String json = BcRPCUtils.prepareJSON(Constants.PEERINFO);
        Result result = BcRPCUtils.executePost(map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String info = result.getData().getResult();
            return result.getData().getResult();
        }
        return null;
    }


    /**
     * 作业4：获取余额
     * @return  请求不成功返回null
     */
    public String balances() {
        String json = BcRPCUtils.prepareJSON(Constants.BALANCES);
        Result result = BcRPCUtils.executePost(map, json);
        if(result==null){
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        }
        return null;
    }


    /**
     * 作业5：获取网络hashPS
     * @return   请求不成功返回null
     */
    public  String networkHashPS() {
        String json = BcRPCUtils.prepareJSON(Constants.NETWORKHASHPS);
        Result result = BcRPCUtils.executePost(map, json);
        if(result==null){
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();

        }
        return null;
    }

    /**
     * 作业6：获取钱包信息
     * @return  请求不成功返回null
     */
    public String walletInfo() {
        String json = BcRPCUtils.prepareJSON(Constants.WALLETINFO);
        Result result = BcRPCUtils.executePost(map,json);
        if(result==null){
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String info = result.getData().getResult();
            return result.getData().getResult();
        }
        return null;
    }


    /**
     * 作业7：获取待确认的余额
     * @return  请求失败返回null
     */
    public String unConfirmedBalance() {
        String json = BcRPCUtils.prepareJSON(Constants.UNCOFIRMEDBALANCE);
        Result result = BcRPCUtils.executePost(map,json);
        if(result==null){
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String info = result.getData().getResult();
            return result.getData().getResult();
        }
        return null;
    }


    /**
     * 作业8：获取新地址
     * @return 请求失败返回null
     */
    public String newAddress() {
        String json = BcRPCUtils.prepareJSON(Constants.NEWADDRESS);
        Result result = BcRPCUtils.executePost(map,json);
        if(result==null){
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String info = result.getData().getResult();
            return result.getData().getResult();
        }
        return null;
    }


    /**
     * 作业9：获取未加工处理地址
     * @return  请求失败返回null
     */
    public String rawChangeAddress() {
        String json = BcRPCUtils.prepareJSON(Constants.RAWCHANGEADDRESS);
        Result result = BcRPCUtils.executePost(map,json);
        if(result==null){
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String info = result.getData().getResult();
            return result.getData().getResult();
        }
        return null;
    }




    /**
     * 获取当前区块链的信息
     * 命令：getblockchaininfo
     *
     * @return 返回查询节点的区块链信息，查询失败返回null;
     */
    public BlockChainInfo getBlockChainInfo() {
        String json = BcRPCUtils.prepareJSON(Constants.GETBLOCKINFO);
        Result result = BcRPCUtils.executePost(map,json);
        if(result==null){
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String info = result.getData().getResult();
            System.out.println(info);
            return JSON.parseObject(info, BlockChainInfo.class);
        }
        return null;
    }

    /**
     * 返回最新区块的hash值
     * @return 最新区块的hash值
     */
    public String getBestBlockHash() {
        String json = BcRPCUtils.prepareJSON(Constants.GETBESTBLOCKHASH);
        Result result = BcRPCUtils.executePost(map,json);
        if(result == null){
            return null;
        }
        if(result.getCode() == HttpStatus.SC_OK){
            return result.getData().getResult();
        }
        return null;
    }
    /**
     * 获取比特币节点的区块总数
     * @return 返回比特币节点的区块总数，int类型
     */
    public int getBlockCount() {
        //1、json
        //2、post请求
        String json = BcRPCUtils.prepareJSON(Constants.GETBLOCKCOUNT);
        Map<String, String> map = new HashMap<String,String>();
        map.put("Authorization", "Basic " + BcRPCUtils.base64Encode(Constants.RPCUSER + ":" + Constants.RPCPASSWORD));
        Result result = BcRPCUtils.executePost(map, json);
        if(result == null){
            return -1;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String countStr = result.getData().getResult();
            return Integer.parseInt(countStr);
        }
        return -1; //-1代表查询失败或错误

    }
}
