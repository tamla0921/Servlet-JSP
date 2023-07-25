package com.edu.beans;

/**
 * memberInput.jsp 페이지에서 입력된 값들을 바인딩(저장)할 목적으로 사용되는 클래스.
 * @author seo
 *
 */
public class Member {

    private String id;
    private String passwd;
    private String name;
    private String mail;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    
}
