package com.btc.connect.demo;

import com.btc.connect.ADDRESS_TYPE;
import com.btc.connect.BTCService;
import com.btc.connect.entity.BlockChainInfo;
import com.btc.connect.entity.BlockData;

public class Test {

    public static void main(String[] args) {
        //测试：获取区块的总数
        BTCService service = new BTCService();
        int count = service.getBlockCount();
        System.out.println("比特币节点的区块数:"+count);
        //获取最新区块哈希值
        String hash = service.getBestBlockHash();
        System.out.println("最新区块的hash:"+hash);

        //测试：获取区块链节点信息
        BlockChainInfo chainInfo = service.getBlockChainInfo();
        if(chainInfo != null) {
            String chain = chainInfo.getChain();
            System.out.println("区块链节点信息:"+chain);
            System.out.println("难度:"+chainInfo.getDifficulty());
//            List<Bip>bipList = chainInfo.getSoftforks();
//            需求：取出集合中的每一个成员  -> 遍历
//            for (Bip bip: bipList) {
//                System.out.println(bip.getId());
//            }
        }

        //测试：获取特定高度的区块哈希
        String hash0 = service.getBlockHashByHeight(0);
        System.out.println("特定高度的区块哈希："+ hash0);

        //测试：根据获取hash值获取特定区块信息
        BlockData data = service.getBlockByHash(hash0);
        if(data !=null){
            System.out.println("结果："+data.getHash());
        }

//        测试： 生成一个新比特币地址
        String address = service.getNewAddress("btc", ADDRESS_TYPE.LEGACY);
            System.out.println("新比特币地址："+address);

        //测试：获取挖矿信息
        String miningInfo = service.getMiningInfo();
        if(data != null) {
            System.out.println("1.挖矿信息:" + miningInfo);

        //测试：获取连接数量
        String connectionCount = service.connectionCount();
            System.out.println("2.连接数量:" + connectionCount);

        //测试：获取peerinfo
        String peerInfo = service.peerInfo();
            System.out.println("3.peerinfo:"+ peerInfo);

        //获取余额
        String Balance = service.balances();
            System.out.println("4.余额:" + Balance);

        //获取网络哈希ps
        String networkHashPS = service.networkHashPS();
            System.out.println("5.网络哈希PS："+networkHashPS);

        //获取钱包信息
        String WalletInfo = service.walletInfo();
            System.out.println("6.钱包信息："+ WalletInfo);

        //获取待确认的余额
        String UnconfirmedBalance = service.unConfirmedBalance();
            System.out.println("7.待确认的余额:"+UnconfirmedBalance);

        //获取新地址
        String NewAddress = service.newAddress();
            System.out.println("8.获取新地址:" + NewAddress);

        //获取未加工处理的地址
        String RawChangeAddress = service.rawChangeAddress();
            System.out.println("9.未加工处理地址：" +RawChangeAddress);


        }


    }

}
