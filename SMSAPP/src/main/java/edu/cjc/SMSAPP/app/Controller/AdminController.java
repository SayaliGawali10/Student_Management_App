package edu.cjc.SMSAPP.app.Controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.yaml.snakeyaml.events.Event.ID;

import edu.cjc.SMSAPP.app.Model.Student;
import edu.cjc.SMSAPP.app.ServiceI.StudentService;

@Controller
public class AdminController {

	@Autowired
	StudentService ss;
	
	@RequestMapping("/")
	public String preLogin() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String onLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model m) {
		
		if(username.equals("admin") && password.equals("admin123")) {
			List<Student> students=ss.getAllStudents();
			m.addAttribute("data", students);
		return "adminscreen";
	}
		else {
		m.addAttribute("login_fail", "Enter Valid Login Details");
	    return "login";
		
		}
		}
	
	@RequestMapping("/enroll_student")
	public String saveStudent(@ModelAttribute Student s, Model m) {
		ss.saveStudentDetails(s);
		List<Student> students=ss.getAllStudents();
		m.addAttribute("data", students);
		return "adminscreen";
	}
	
	@RequestMapping("/search")
	public String getBatchStudent(@RequestParam String batchNumber, Model m) {
		List<Student> result=ss.searchStudentsByBatch(batchNumber);
		if(result.size()>0)
		{
			m.addAttribute("data", result);
			
		}
		else {
		List<Student> students=ss.getAllStudents();
		m.addAttribute("data", students);
		m.addAttribute("message", "No Record Are Available For The Batch' "+batchNumber+" '...!");
		
	}
		return "adminscreen";
}
	
	@RequestMapping("/fees")
	public String onFees(@RequestParam  int id, Model m) {
		Student st=ss.getSingleStudent(id);
		m.addAttribute("st", st);
		return "fees";
	}
	
	@RequestMapping("/payfees")
	public String payFees(@RequestParam("studentid") int studentid, @RequestParam("ammount") float ammount, Model m) {
		
		List<Student> students=ss.updateStudentFees(studentid, ammount);
		m.addAttribute("data", students);
		return "adminscreen";
		
	}
	
	@RequestMapping("/remove")
	public String removeStudent(@RequestParam ("id") int id, Model m) {
		ss.removeDelete(id);
		List<Student> list=ss.getAllStudents();
		m.addAttribute("data", list);
		return "adminscreen";
		
	}
	
	
}