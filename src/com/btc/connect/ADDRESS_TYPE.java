package com.btc.connect;

/**
 * 比特币地址类型的枚举： legacy, p2sh-segwit, bech32
 *  标识符规范：标识符只能由字母、数字、下划线、$组成，不能以数字开头
 */
public enum ADDRESS_TYPE {
    LEGACY,
    P2SH_SEGWIT,
    BECH32
}
