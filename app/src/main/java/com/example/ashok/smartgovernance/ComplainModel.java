package com.example.ashok.smartgovernance;

public class ComplainModel {
    private String cimg;
    private String ctop;
    private String cloc;
    private String cgriv;
    private String cname;
    private String contact;
    private String cid;

    public ComplainModel(String cimg, String ctop, String cloc, String cgriv, String cname, String contact, String cid) {
        this.cimg = cimg;
        this.ctop = ctop;
        this.cloc = cloc;
        this.cgriv = cgriv;
        this.cname = cname;
        this.contact = contact;
        this.cid = cid;
    }

    public String getCimg() {
        return cimg;
    }

    public String getCtop() {
        return ctop;
    }

    public String getCloc() {
        return cloc;
    }

    public String getCgriv() {
        return cgriv;
    }

    public String getCname() {
        return cname;
    }

    public String getContact() {
        return contact;
    }

    public String getCid() {
        return cid;
    }
}

