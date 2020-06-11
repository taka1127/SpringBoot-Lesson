package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sample01Controller {
	//@GetMapping(value="/",name="index")←本来の形
	//@GetMapping({"/","/index"})←value引数の型はString型配列のためこれでもOK。コンパイラが自動的に配列として扱う
	@GetMapping("/")//←最終的な省略形。　　　＊13~16までがハンドラメソッド
	public String index() {
		return "index"; //値に対応するビューの検索→index.html
	}
	
	@PostMapping("/result")
	public String result(@RequestParam String name, Model model) {
		model.addAttribute("name", name);
		return "result";
	}
	
}
