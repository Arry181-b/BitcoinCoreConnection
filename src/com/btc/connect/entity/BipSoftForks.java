package com.btc.connect.entity;

public class BipSoftForks {
    private softforks csv;
    private softforks segwit;

    public softforks getCsv() {
        return csv;
    }

    public void setCsv(softforks csv) {
        this.csv = csv;
    }

    public softforks getSegwit() {
        return segwit;
    }

    public void setSegwit(softforks segwit) {
        this.segwit = segwit;
    }
}