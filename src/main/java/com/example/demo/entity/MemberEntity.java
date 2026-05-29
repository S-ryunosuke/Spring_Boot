package com.example.demo.entity;

	import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "tbl_member")
	public class MemberEntity {

		//ID
		@Id
	    @Column(name = "member_id")
	    private String id;
	    
		//氏名
	    @Column(name = "member_name")
	    private String name;
		
		//年齢
	    @Column(name = "age")
	    private Integer age;
		
		//性別
	    @Column(name = "sex_flg")
	    private Integer  sex;
	    
	    //住所
	    @Column(name = "address")
	    private String address;
		
		//電話番号
	    @Column(name = "telephone")
	    private String telephone;
		
		//メールアドレス
	    @Column(name = "mail")
	    private String mail;
		
		//役職
	    @Column(name = "position_id") 
	    private String position;
		
		//事業所
	    @Column(name = "place_id") 
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

