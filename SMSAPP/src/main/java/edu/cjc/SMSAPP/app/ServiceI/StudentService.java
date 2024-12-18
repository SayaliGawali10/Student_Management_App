package edu.cjc.SMSAPP.app.ServiceI;

import java.util.List;

import edu.cjc.SMSAPP.app.Model.Student;

public interface StudentService {
	
	
	public void saveStudentDetails(Student st);

	public List<Student> getAllStudents();
	
	public List<Student> searchStudentsByBatch(String batchNumber);

	public Student getSingleStudent(int id);

	public List<Student> updateStudentFees(int studentid, float ammount);
	
	public void removeDelete(int id);
}
