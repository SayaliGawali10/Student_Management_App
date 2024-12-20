package edu.cjc.SMSAPP.app.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.cjc.SMSAPP.app.Model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	public List<Student> findAllByBatchNumber(String batchNumber);
	
}
