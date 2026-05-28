package com.example.demo.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.MemberDto;
import com.example.demo.form.MemberForm;
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
	
	//新規登録画面の初期表示
	@GetMapping("/members/add")
	public String showadd(Model model) {
		
		//formを渡して、入力値を入れる
		model.addAttribute("memberForm", new MemberForm());
		
		//新規登録画面表示
		return "insert/insert";
		
	}
	
	//新規登録処理
	//form = Getで渡した物を受け取る
	@PostMapping("/members/add")
	public String add(@Valid @ModelAttribute("memberForm") MemberForm form, BindingResult result,
			RedirectAttributes redirAttrs, Model model) {
		
		//もしバリデーションエラーあれば
		if (result.hasErrors()) {
			
			//登録画面、再表示
			return "insert/insert";
			
		}
		
		//Form→Dtoに変換(Dto内変換メソッド使用)
		MemberDto memberDto = MemberDto.convertFormToDto(form);
		
		//変換したDtoで登録処理
		memberService.insert(memberDto);
		
		//成功メッセージ表示
		redirAttrs.addFlashAttribute("message", "登録完了しました");
		
		//成功時一覧画面へリダイレクト
		return "redirect:/members";
	
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
