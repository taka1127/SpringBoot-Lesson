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
	@GetMapping("/")//←最終的な省略形。　　
	//　14~17までがハンドラメソッド
	public String index() {
		return "index"; //値に対応するビューの検索→index.html
	}
	
	@PostMapping("/result") //@RequestParamはクエリ文字列を受け取る。 クエリ文字列の名前と引数の名前が一致する場合は19行目のように省略できる。
	// 21~27までがハンドラメソッド	//名前が異なる場合→(例）@RequestParam("name") String searchNameとしクエリ文字列の名前を指定する。
	public String result(@RequestParam String name, Model model) {
							//Modelインターフェースはビューに表示するデータを設定する
							//addAttributeメソッドはモデルに属性を追加し、ビューで利用できるようになる。↓
							//モデルに"name"という名前でname引数に入っている値を設定する。
		model.addAttribute("name", name);
		return "result";
	}
	
}
