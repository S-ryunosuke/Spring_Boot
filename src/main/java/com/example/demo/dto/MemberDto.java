package com.example.demo.dto;

import com.example.demo.entity.MemberEntity;
import com.example.demo.form.MemberForm;

//メンバーDto
public class MemberDto {

	//ID
	private String id;

	//氏名
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
	
	//Form→Dtoへの変換メソッド
	public static MemberDto convertFormToDto(MemberForm memberForm) {
		
		//Dto生成し、そこに渡ってきたformの値を入れる
		MemberDto memberDto = new MemberDto();

		memberDto.setId(memberForm.getId());
		memberDto.setName(memberForm.getName());
		memberDto.setAge(memberForm.getAge());
		memberDto.setSex(memberForm.getSex());
		memberDto.setAddress(memberForm.getAddress());
		memberDto.setTelephone(memberForm.getTelephone());
		memberDto.setMail(memberForm.getMail());
		memberDto.setPosition(memberForm.getPosition());
		memberDto.setPlace(memberForm.getPlace());
		
		//Dtoを返す
		return memberDto;
	}
	
	//Dto→Entityへの変換メソッド
	public static MemberEntity convertDtoToEntity(MemberDto memberDto) {
			
		//Entity生成し、そこに渡ってきたDtoの値を入れる
		MemberEntity memberEntity = new MemberEntity();

		memberEntity.setId(memberDto.getId());
		memberEntity.setName(memberDto.getName());
		memberEntity.setAge(memberDto.getAge());
		memberEntity.setSex(memberDto.getSex());
		memberEntity.setAddress(memberDto.getAddress());
		memberEntity.setTelephone(memberDto.getTelephone());
		memberEntity.setMail(memberDto.getMail());
		memberEntity.setPosition(memberDto.getPosition());
		memberEntity.setPlace(memberDto.getPlace());
			
		//Entityを返す
		return memberEntity;
			
	}

}
