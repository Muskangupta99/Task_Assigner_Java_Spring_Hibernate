package com.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.beans.Person;
import com.beans.Tasks;
import com.beans.Users;
import com.dao.*;
import com.models.EmailUtility;
import com.models.TaskResolver;

@Controller
public class UserControllers {
	
		@RequestMapping(value = "/registerUser1", params="Login", method = RequestMethod.POST)
	    public String register(@ModelAttribute Users Users, BindingResult result, ModelMap model) {
			System.out.println("Add user in DB");
			
	        //TaskResolver tasks = new TaskResolver();
			registerDaoImpl registerDao = new registerDaoImpl();
	        model.addAttribute("status", registerDao.registerUser(Users.getEmail(),Users.getPassword()));
	        return "register";
	    }
		
		@RequestMapping(value = "/login", params="login", method = RequestMethod.POST)
	    public String login(@ModelAttribute Users Users, BindingResult result, ModelMap model, HttpSession session) {
			System.out.println("Search user in DB");
			
	        //TaskResolver tasks = new TaskResolver();
			LoginDao loginDaoImpl = new LoginDaoImpl();
			PersonDaoImpl personDaoImpl = new PersonDaoImpl();
			
			Long id = loginDaoImpl.login(Users.getEmail(),Users.getPassword());
	        if(id!=null) {
	        	session.setAttribute("user_id", id);
	        	model.addAttribute("user_id", id);
	        	model.addAttribute("persons",personDaoImpl.getPersons(id));
	        	//Person person = new Person();
	        	//person.setFk_user_id(id);
	            return "people";
	        }
	        else{
	        	session.setAttribute("user_id", null);
	        	 model.addAttribute("status", "wrong user name or password");
	        	 model.addAttribute("Users", new Users());
	        	 return "loginpage";
	        	 
	        }
	       
	    }
		
		
		
		
		@RequestMapping(value = "/addperson", method = RequestMethod.POST)
		public @ResponseBody String processAJAXRequest(
		            @RequestParam("person_name") String person_name,
		            @RequestParam("fk_user_id") String fk_user_id) {
			        
			     System.out.println(person_name+" "+fk_user_id);
		        String response = "";
				PersonDaoImpl personDaoImpl = new PersonDaoImpl();
				Person person = new Person();
				person.setPerson_name(person_name);
				person.setFk_user_id(Long.parseLong(fk_user_id));
				
				Long id = personDaoImpl.addperson( Long.parseLong(fk_user_id),person_name);
				person.setPk_person_id(id);
		        if(id != null) {
		        	//model.addAttribute("pk_task_id",id);
		        	System.out.println("person added");
		        	
		        }
		        else{
		        	System.out.println("person not added");
		        			        	
		    }
		        return Long.toString(id);
		    }
		
		
		@RequestMapping(value = "/addtask", method = RequestMethod.POST)
		public @ResponseBody void addTask(
		            @RequestParam("task_description") String task_description,
		            @RequestParam("person_id") String fk_person_id   ) {
			        
			     System.out.println(task_description+" "+fk_person_id);
		        String response = "";
				TaskDaoImpl taskDaoImpl = new TaskDaoImpl();
				
		        if(taskDaoImpl.setTask( Long.parseLong(fk_person_id),task_description))
		        	System.out.println("task added");
		        else{
		        	System.out.println("task not added");
		        	
		        	
		    }
		       
		    }
		
		
		@RequestMapping(value = "/email", method = RequestMethod.POST)
		public @ResponseBody void email(
		            @RequestParam("task_description") String task_description,
		            @RequestParam("person_name") String fk_person_name  ,
		            @RequestParam("task_id") String fk_task_id ,
		            @RequestParam("email") String email ) {
			        
			     System.out.println(task_description+" "+fk_person_name+" "+fk_task_id+" "+email);
		        String response = "";
				EmailUtility emailUtility = new EmailUtility();
				TaskDaoImpl tasks = new TaskDaoImpl();
				tasks.setCompleted(Long.parseLong(fk_task_id));
		        if(emailUtility.emailSender(email, fk_person_name+" has completed the task: "+task_description, "Dear user,"+"\nThis is a notification that "+fk_person_name+" has completed the task: "+task_description+"!"))
		        	System.out.println("email sent");
		        else{
		        	System.out.println("email not sent");
		        	
		        	
		    }
		       
		    }
		
		@RequestMapping(value = "/passcode", method = RequestMethod.GET)
	    public ModelAndView loginForm(Model model, Long person_id) {
			System.out.println("Here in object binding class for passcode");
			model.addAttribute("person_id", person_id);
			Person person = new Person();
			person.setPk_person_id(person_id);
	        return new ModelAndView("passcode", "Person", person);
	    }
		
		
		@RequestMapping(value = "/checkpasscode", params="pass", method = RequestMethod.POST)
	    public String login(@ModelAttribute Person Person, BindingResult result, ModelMap model) {
			System.out.println("Validate passcode");
			
	      
			
			PersonDaoImpl personDaoImpl = new PersonDaoImpl();
			
			int res=personDaoImpl.getPassCode(Person.getPk_person_id(), Person.getPasscode());
	        if(res==1) {
	        	TaskDaoImpl taskDaoImpl = new TaskDaoImpl();
				LoginDaoImpl loginDaoImpl = new LoginDaoImpl();
				
		        ArrayList<Tasks> tasks = taskDaoImpl.getTask(Person.getPk_person_id(),"mytasks");
		        
		        System.out.println("Printing tasks "+tasks.get(0).getDescription());
		        
		        ArrayList<Person> person = personDaoImpl.getPersonsDetails(Person.getPk_person_id());
		        String user_email = loginDaoImpl.UserDetails(person.get(0).getFk_user_id());
		        		
		        model.addAttribute("tasks", tasks);
		        model.addAttribute("fk_person_name",person.get(0).getPerson_name());
		        model.addAttribute("fk_person_id",Person.getPk_person_id());
		        model.addAttribute("notify",user_email);
		        return "mytasks";
	        	
	        }
	        else if(res==0){
	        	 Person person = new Person();
	        	 person.setPk_person_id(Person.getPk_person_id());
	        	 model.addAttribute("Person", person);
	        	 model.addAttribute("status", "Please ask assigner to set a pass code.");
	    
	        	return "passcode";
	        	 
	        }
	        else {
	        	 Person person = new Person();
	        	 person.setPk_person_id(Person.getPk_person_id());
	        	 model.addAttribute("Person", person);
	        	 model.addAttribute("status", "wrong pass code");
	    
	        	return "passcode";
	        }
	    }
		
		
		@RequestMapping(value = "/addpasscode", method = RequestMethod.POST)
		public @ResponseBody void addpasscode(
		            @RequestParam("passcode") String passcode,
		            @RequestParam("person_id") String person_id) {
			        
			     System.out.println(passcode+" "+person_id);
		        String response = "";
				PersonDaoImpl personDaoImpl = new PersonDaoImpl();
				Person person = new Person();
			
				
		        if(personDaoImpl.addpasscode(Long.parseLong(person_id),passcode)) {
		        	//model.addAttribute("pk_task_id",id);
		        	System.out.println("passcode added/update");
		        	
		        }
		        else{
		        	System.out.println("passcode not added/update");
		        			        	
		    }
		       
		    }
		//using get anyone can access ur web page so don't use it unless its a general link
		/*@RequestMapping(value = "/mytasks", method = RequestMethod.GET)
	    public String mytasks(Model model, Long person_id) {
			System.out.println("In my tasks controller");
			Long fk_person_id = person_id;
			System.out.println(fk_person_id);
			
			TaskDaoImpl taskDaoImpl = new TaskDaoImpl();
			PersonDaoImpl personDaoImpl = new PersonDaoImpl();
			LoginDaoImpl loginDaoImpl = new LoginDaoImpl();
			
	        ArrayList<Tasks> tasks = taskDaoImpl.getTask(fk_person_id,"mytasks");
	        
	        System.out.println("Printing tasks "+tasks.get(0).getDescription());
	        
	        ArrayList<Person> person = personDaoImpl.getPersonsDetails(fk_person_id);
	        String user_email = loginDaoImpl.UserDetails(person.get(0).getFk_user_id());
	        		
	        model.addAttribute("tasks", tasks);
	        model.addAttribute("fk_person_name",person.get(0).getPerson_name());
	        model.addAttribute("fk_person_id",fk_person_id);
	        model.addAttribute("notify",user_email);
	        return "mytasks";
	    }
		*/
		
}
