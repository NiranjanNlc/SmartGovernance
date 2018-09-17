package com.example.ashok.smartgovernance;

public class modelNotice {
    private String nimg;
    private String ntop;
    private String  notice ;

    public modelNotice(String nimg, String ntop, String notice) {

        this.nimg = nimg;
        this.ntop = ntop;
        this.notice = notice;
    }

    public String getNimg() {

        return nimg;
    }

    public String getNtop() {
        return ntop;
    }

    public String getNotice() {
        return notice;
    }
}
