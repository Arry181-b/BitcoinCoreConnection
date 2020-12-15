package com.btc.connect;

/**
 * 常量
 */
public class Constants {
    //rpc服务协议
    public static final String RPCUSER= "user"; //rpc用户名
    public static final String RPCPASSWORD = "pwd";//RPC用户密码
    public static final String RPCURL = "http://127.0.0.1:8332";  //rpc的链接

    //地址类型
    public static  final String ADDRESS_LEGACY = "legacy";
    public static  final String ADDRESS_P2SH_SEGWIT = "p2sh-segwit";
    public static final String ADDRESS_BECH32 = "bech32";
    //rpc服务命令

    /**
     * 获取节点区块总数
     */
    public static final String GETBLOCKCOUNT = "getblockcount";

    /**
     * 获取最新区块hash
     */
    public static final String GETBESTBLOCKHASH = "getbestblockhash";

    /**
     * 获取区块节点信息
     */
    public static final String GETBLOCKINFO = "getblockchaininfo";

    /**
     * 获取指定高度区块的hash
     * getblockhash height
     */
    public static final String GETBLOCKHASHBYHEIGHT = "getblockhash";

    /**
     * 通过hash获取区块
     * getblock "hash"
     */
    public static final String GETBLOCKBYHASH = "getblock";

    /**
     * 获取新的区块地址
     * getnewaddress ("label" "address_type")
     */
    public static final String GETNEWADDRESS = "getnewaddress";

    /**
     * 获取挖矿信息
     * getmininginfo
     */
    public static final String GETMININGINFO = "getmininginfo";

    /**
     * 获取网络hashPS
     * getnetworkhashps
     */
    public static final String NETWORKHASHPS = "getnetworkhashps";

    /**
     * 获取已连接数量
     * getconnectioncount
     */
    public static final String CONNECTIONCOUNT  = "getconnectioncount";

    /**
     * 获取peerinfo
     * getpeerinfo
     */
    public static final String PEERINFO = "getpeerinfo";

    /**
     * 获取余额
     * getbalances
     */
    public static final String BALANCES = "getbalances";

    /**
     * 获取钱包信息
     * getwalletinfo
     */
    public static final String WALLETINFO = "getwalletinfo";

    /**
     * 获取待确认的余额
     * getunconfirmedbalance
     */
    public static final String UNCOFIRMEDBALANCE= "getunconfirmedbalance";

    /**
     * 获取新地址
     * getnewaddress
     */
    public static final String NEWADDRESS = "getnewaddress";

    /**
     * 获取未加工处理地址
     * getrawchangeaddress
     */
    public static final String RAWCHANGEADDRESS = "getrawchangeaddress";

    /**
     * 该方法用于根据枚举类型返回对应的比特币地址的类型对应字符串
     *
     * @param type 枚举
     * @return  比特币地址类型字符串形式
     */
    public static String getAddressType(ADDRESS_TYPE type) {
        switch (type) {
            case LEGACY:
                return ADDRESS_LEGACY;
            case P2SH_SEGWIT:
                return ADDRESS_P2SH_SEGWIT;
            case BECH32:
                return ADDRESS_BECH32;
            default:
                return null;
        }
    }
}
