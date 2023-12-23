package com.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.beans.Person;
import com.beans.Tasks;
import com.beans.Users;
import com.dao.TaskDaoImpl;
import com.dao.registerDaoImpl;
import com.models.*;



@Controller
public class ShareControllers {
	@RequestMapping(value = "/createtask",  method = RequestMethod.GET)
    public String sharedtasks(@RequestParam("person_id") Long fk_person_id, String passcode, Model model, HttpSession session) {
		
		System.out.println("Printing session value : "+session.getAttribute("user_id"));
		if(session.getAttribute("user_id")!=null) {
		System.out.println("In shared tasks controller");
		System.out.println(fk_person_id);
        TaskDaoImpl taskDaoImpl = new TaskDaoImpl();
        ArrayList<Tasks> tasks = taskDaoImpl.getTask(fk_person_id,"");
        model.addAttribute("tasks", tasks);
        model.addAttribute("fk_person_id", fk_person_id);
        model.addAttribute("passcode", passcode);
        //redirectAttributes.addFlashAttribute("fk_person_id", fk_person_id);
        //redirectAttributes.addFlashAttribute("tasks", tasks);
        return "createtask";
		}
		else {
			
			model.addAttribute("message","Please log in or create an account to assign tasks");
			return "home";
		}
    }
	
	
	//home
	/*@RequestMapping(value = "/")
    public String home(Model model) {
		System.out.println("In index");
		        return "home";
    }
	*/
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showForm(Model model) {
		System.out.println("Here in object binding class for Register Form");
		//model.addAttribute("csvSuccess","");
        return new ModelAndView("register", "Users", new Users());
    }
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView loginForm(Model model, String status) {
		System.out.println("Here in object binding class for Login Form");
		model.addAttribute("status",status);
        return new ModelAndView("loginpage", "Users", new Users());
    }
	
	
	@RequestMapping(value = "/registerUser", params="register", method = RequestMethod.POST)
    public String register(@ModelAttribute("Users")Users Users, BindingResult result, ModelMap model) {
		System.out.println("Add user in DB");
		
		if(!Users.getPassword().equals(Users.getConfirm_password())){
			System.out.println("Passwords don't match");
			model.addAttribute("status", "Passwords don't match");
			model.addAttribute("Users", new Users());
			return "register";
		}
			
        //TaskResolver tasks = new TaskResolver();
		registerDaoImpl registerDao = new registerDaoImpl();
		model.addAttribute("Users", new Users());
		if(registerDao.registerUser(Users.getEmail(),Users.getPassword()).equals("success"))
        model.addAttribute("status", "Registration Successfull!");
		else
			model.addAttribute("status", "Sorry there was an error X/");
        return "register";
    }
	
	
}
