package com.a2bo.main.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.a2bo.main.model.dao.MainDao;
import com.a2bo.main.model.vo.MainVlv;

import common.JDBCTemplate;

public class MainService {
	
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	private MainDao mDao = new MainDao();
	
	public MainService() {
		super();
	}
	
	public List<MainVlv> searchingVg(List<Integer> list) {
		
		Connection conn = jdt.getConnection();
		List<MainVlv> vgList = new ArrayList<MainVlv>();
		
		try {
			vgList = mDao.searchingVg(conn, list);
//			vgMap.put("isSuccess", true);
//			vgMap.put("res", "불러오는데 성공했다야");
		} catch (SQLException e) {
//			vgMap.put("isSuccess", false);
//			vgMap.put("res", "관리자에게 문의 하세요");
			e.printStackTrace();
		}finally {
			jdt.close(conn);
		}
		
		
		
		System.out.println("서비스 단에서 list " + list);
		System.out.println("서비스 단에서 vgList " + vgList);		
		return vgList;
		
	}


	public Map<String, Object> searchingMenu(String myLevel){
		
		Map<String, Object> Menu = new HashMap<String, Object>();
		List<Integer> list = null;
		
		List<MainVlv> vgList = new ArrayList<MainVlv>();
		vgList = searchingVg(list);
		
		
		System.out.println("서칭 메뉴 서비스 단에서 vgList" + vgList);
		
		
		
		
		
		
		
		return Menu;
		
	}
	
}
