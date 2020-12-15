package com.btc.connect.entity;

public class MiningInfo {
    private int blocks;
    private double difficulty;
    private double networkhashps;
    private int pooledtx;
    private String chain;
    private String warnings;

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public double getNetworkhashps() {
        return networkhashps;
    }

    public void setNetworkhashps(double networkhashps) {
        this.networkhashps = networkhashps;
    }

    public int getPooledtx() {
        return pooledtx;
    }

    public void setPooledtx(int pooledtx) {
        this.pooledtx = pooledtx;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }
}
