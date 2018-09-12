package com.sh.djpk.econsole.ui.controller.pengaturan;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.sh.djpk.share.model.User;

@ManagedBean
public class UsmanCtl implements Template{
	
	public List<User> getUserView(){
		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setEmail("admin@gmail.com");
		user.setNameDesc("Administrator");
		user.setNameShort("Admin");
		user.setRole("theCreator");
		user.setStatus("Aktive");
//		user.setUser_name("admin");
		list.add(user);
		return list;
		
	}
	
	public String indexButtonAdd(){
		System.out.println("masuk sini");
		return "_detail";
	}

	@Override
	public String doAdd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMenuName() {
		return "Usman";
	}

	
}
