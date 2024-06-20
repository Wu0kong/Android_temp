package com.example.lzp102.bean;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

public class User extends BmobUser {
    private BmobFile imageHead;
    private String nickName;
    private boolean sex;
    private String info;

    public BmobFile getImageHead() {
        return imageHead;
    }

    public void setImageHead(BmobFile imageHead) {
        this.imageHead = imageHead;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
