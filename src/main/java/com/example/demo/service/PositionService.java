package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PositionEntity;
import com.example.demo.repository.PositionRepository;

//役職機能サービスクラス
@Service
public class PositionService {
	
	@Autowired
	private PositionRepository positionRepository;
	
	//事業所情報を返す
	public List<PositionEntity> findAll() {
		return positionRepository.findAll();
	}

}