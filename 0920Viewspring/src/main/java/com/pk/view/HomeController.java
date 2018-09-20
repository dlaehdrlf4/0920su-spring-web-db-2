package com.pk.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	// excel.xml 요청을 처리하는 메소드
	@RequestMapping(value = "excel.xls", method = RequestMethod.GET)
	public String excel(Model model) {

		List<String> list = new ArrayList<>();
		list.add("호날두퇴장");
		list.add("호우형");
		list.add("다음경기출전불가");
		list.add("호우형퇴장후눈물");
		list.add("퇴장와우!!!");
		list.add("비가오는날엔");
		list.add("막걸리지");

		model.addAttribute("list", list);
		return "honaldo";

	}

	// data.pdf 요청을 처리하는 메소드
	@RequestMapping(value = "data.pdf", method = RequestMethod.GET)
	public String pdf(Model model) {

		List<String> list = new ArrayList<>();
		list.add("올라프");
		list.add("이블린");
		list.add("가렌");
		list.add("오리아나");
		list.add("트런들");
		list.add("리신");
		list.add("갈리오");
		list.add("트위치");
		list.add("마스터이");

		// unit 라는 이름으로 list 저장
		model.addAttribute("unit", list);

		// 출력하는 뷰이름을 unt으로 저장
		return "unit";
	}

	@RequestMapping(value = "jsonview.json", method = RequestMethod.GET)
	public String json(Model model) {
		
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String>  map= new HashMap<>();
		map.put("name", "james");
		map.put("position", "powerfoward");
		list.add(map);
		
		map = new HashMap<>();
		map.put("name", "coby");
		map.put("position", "shootinggard");
		list.add(map);
		
		map = new HashMap<>();
		map.put("name", "jordan");
		map.put("position", "shootinggard");
		list.add(map);
		
		model.addAttribute("list",list);
		
		return "basketplayer";
	}
}