package com.pk.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pk.view.service.MemberService;

@Controller
public class DataController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	@Autowired
	private MemberService memberServie;
	@RequestMapping(value="idcheck", method=RequestMethod.GET)
	//반드시 idcheck 요청을 할 때 id 의 값을 같이 넘겨주어야 합니다.
	public Map<String, String> idcheck(
			@RequestParam("id") String id){
			String result = memberServie.idcheck(id);
			Map<String, String> map = new HashMap<>();
			// 아이디가 존재하지 않을 때
			if(result == null) {
				map.put("result", "true");
			}else {
				map.put("result", "false");
			}
			return map;
	}
	
	//csv를 만들어서 리턴하는 메소드
	@RequestMapping(value="data.csv", method=RequestMethod.GET)
	public String dataCSV() {
		return "csv,xml,json";
		//,로 구분된 문자열로 구분한다  이걸 출력하면 csv 파일이 다운로드 받아지고 확인하면 엑셀로 보여진다.
	}
	//json을 만들어서 리턴하는 메소드
	@RequestMapping(value="data.json", method=RequestMethod.GET)
		public List<Map<String, Object>>  datajson(){
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> map = new HashMap<>();
			map.put("name", "kaka");
			map.put("team", "brazil");
			list.add(map);
			
			map = new HashMap<>();
			map.put("name","messi");
			map.put("team", "balselrona");
			list.add(map);
			
			return list;
		}
	}

