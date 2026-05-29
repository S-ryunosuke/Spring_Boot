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
import com.example.demo.service.PlaceService;
import com.example.demo.service.PositionService;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PositionService positionService;
	
	@Autowired
	private PlaceService placeService;
		
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
		
		//役職リストを渡す
		model.addAttribute("positionList",positionService.findAll());
		
		//事業所リストを渡す
		model.addAttribute("placeList",placeService.findAll());
		
		//新規登録画面表示
		return "insert/insert";
		
	}
	
	//新規登録処理(エラーチェック)
	//form入力された物を受け取る
	@PostMapping("/members/confirm")
	public String confirm(@Valid @ModelAttribute("memberForm") MemberForm form, BindingResult result, Model model) {
		
		//もしバリデーションエラーあれば
		if (result.hasErrors()) {
			
			//再度役職リストを渡す
			model.addAttribute("positionList",positionService.findAll());
			
			//再度事業所リストを渡す
			model.addAttribute("placeList",placeService.findAll());
			
			//登録画面、再表示
			return "insert/insert";
			
		}
		
		 //エラー無ければ、確認画面用にformを渡す
		model.addAttribute("memberForm",form);
		
		//エラー無ければ、確認画面へ遷移
		return "insert/insertConf";
		
	}
	
	//新規登録処理(確認画面用)
	@PostMapping("/members/add")
	public String add(@ModelAttribute("memberForm") MemberForm form, RedirectAttributes redirAttrs) {

		//Form→Dtoに変換(Dto内変換メソッド使用)
		MemberDto memberDto = MemberDto.convertFormToDto(form);
				
		//変換したDtoで登録処理
		memberService.insert(memberDto);
		
		//完了画面で、登録した情報を表示させるためformを渡す
		redirAttrs.addFlashAttribute("member", form);
		
		//完了画面処理へ
	    return "redirect:/members/complete";
	}
	
	//新規登録完了画面
	@GetMapping("/members/complete")
	public String compiete() {
		
		return "insert/insertComp";
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
