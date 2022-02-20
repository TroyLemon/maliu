package com.troyliu.maliu.unittest;

public class Item implements java.io.Serializable {

    public String name ;
    private String desc ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
