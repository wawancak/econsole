package com.sh.djpk.econsole.ui.controller.pengaturan;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sh.djpk.share.model.User;

@ManagedBean
@ViewScoped
public class UsmanCtl  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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


	
}
