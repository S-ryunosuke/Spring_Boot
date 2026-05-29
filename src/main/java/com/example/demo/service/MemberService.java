package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MemberDto;
import com.example.demo.entity.MemberEntity;
import com.example.demo.repository.MemberRepository;

//メンバー機能Serviceクラス
@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	//メンバー一覧の返却(戻り値リスト)
	public List<MemberDto> findAll() {

		//DBから全権取得
		//Entityのリストで取得
		List<MemberEntity> entityList = memberRepository.findAll();

		//DTOを格納するList作成
		List<MemberDto> dtoList = new ArrayList<>();

		//EntityListの件数分、繰り返し処理
		for (MemberEntity memberEntity : entityList) {

			//Dto生成
			MemberDto dto = new MemberDto();

			//Entity→Dtoへ

			/* ID
			 * 名前
			 * 年齢
			 * 性別
			 * 住所
			 * 電話番号
			 * メールアドレス
			 * 役職
			 * 事業所
			 */
			dto.setId(memberEntity.getId());
			dto.setName(memberEntity.getName());
			dto.setAge(memberEntity.getAge());
			dto.setSex(memberEntity.getSex());
			dto.setAddress(memberEntity.getAddress());
			dto.setTelephone(memberEntity.getTelephone());
			dto.setMail(memberEntity.getMail());
			dto.setPosition(memberEntity.getPosition());
			dto.setPlace(memberEntity.getPlace());

			//Dtoリストに追加
			dtoList.add(dto);
			
		}
		
		//Dtoリストを返却
		return dtoList;
	}
	
	//メンバー新規登録処理
	public void insert(MemberDto memberDto) {
		
		//渡って来たDtoを→Entityに変換
		MemberEntity memberEntity = MemberDto.convertDtoToEntity(memberDto);
		
		//変換したEntityをDBに登録処理
		memberRepository.save(memberEntity);
		
	
	}
	
	//メンバーの返却
	public MemberDto findById(String memberId) {
		
		//DBからIDを元に取得
		MemberEntity memberEntity = memberRepository.findById(memberId).orElse(null);
		
		//取得したEntityをDtoに変換
		MemberDto memberDto = MemberDto.convertEntityToDto(memberEntity);
		
		//変換したDtoを返却
		return memberDto;
		
	}

}
