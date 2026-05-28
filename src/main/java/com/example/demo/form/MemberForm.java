package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;

//メンバーForm
public class MemberForm {
	
	//ID
	@NotBlank(message = "IDは必須です。")
    private String id;
    
	//氏名
    @NotBlank(message = "氏名は必須です。")
    private String name;
	
	//年齢
    private Integer age;
	
	//性別
    private Integer  sex;
    
    //住所
    private String address;
	
	//電話番号
    private String telephone;
	
	//メールアドレス
    private String mail;
	
	//役職
    private String position;
	
	//事業所
    private String place;
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer  getSex() {
        return sex;
    }

    public void setSex(Integer  sex) {
        this.sex = sex;
    }
    
    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
		
	}

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

}
