package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.MemberService;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
		
	//初期画面
	@GetMapping("/")
	public String index() {
			
		return "first/first";
			
	}
	
	//メンバー一覧画面初期表示
	@GetMapping("/members")
	public String show(Model model) {
		
		//サービスのfindAllメソッドで一覧を取得
		//取得結果をviewに渡す
		model.addAttribute("members",memberService.findAll());
		
		//メンバー一覧の表示
		return "list/list";
	
	}
	
	//詳細画面
	@PostMapping("/detail")
	public String detail() {
		
		return "detali/detail";
		
	}
	
	//削除処理
	@PostMapping("/delete")
	public String delete() {
		
		return "delete/delete";
		
	}
	
	//更新画面
	@PostMapping("/update")
	public String update() {
		
		return "update/update";
		
	}
	
}
