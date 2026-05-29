package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PlaceEntity;
import com.example.demo.repository.PlaceRepository;

//事業所機能サービスクラス
@Service
public class PlaceService {
	
	@Autowired
	private PlaceRepository placeRepository;
	
	//役職情報を返す
	public List<PlaceEntity> findAll() {
		return placeRepository.findAll();
		
	}

}