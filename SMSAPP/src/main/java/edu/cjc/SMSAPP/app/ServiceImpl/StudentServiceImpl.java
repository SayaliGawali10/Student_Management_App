package edu.cjc.SMSAPP.app.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import edu.cjc.SMSAPP.app.Model.Student;
import edu.cjc.SMSAPP.app.Repository.StudentRepository;
import edu.cjc.SMSAPP.app.ServiceI.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository sr;

	@Override
	public void saveStudentDetails(Student st) {
		sr.save(st);
		
	}

	@Override
	public List<Student> getAllStudents() {
		
		return (List<Student>) sr.findAll();
	}

	@Override
	public List<Student> searchStudentsByBatch(String batchNumber) {
	List<Student> batchStudents=sr.findAllByBatchNumber(batchNumber);
		return batchStudents;
	}

	@Override
	public Student getSingleStudent(int id) {
		Optional<Student> opStudent=sr.findById(id);
		return opStudent.get();
	}

	@Override
	public List<Student> updateStudentFees(int studentid, float ammount) {
		
		Student s=sr.findById(studentid).get();
		float paidfees=Float.parseFloat(s.getFeesPaid())+ammount;
		s.setFeesPaid(String.valueOf(paidfees));
		sr.save(s);
		return (List<Student>) sr.findAll();
	}

	@Override
	public void removeDelete(int id) {
		sr.deleteById(id);
	}

	@Override
	public List<Student> updateStudentBatch(int studentid, String batchNumber) {
		Student s=sr.findById(studentid).get();
	    s.setBatchNumber(batchNumber);
		sr.save(s);
		return (List<Student>) sr.findAll();
		
	}

	

	
	
	
}
