package com.music.school.api;

import com.music.school.domain.Student;
import com.music.school.dto.ClientDto;
import com.music.school.dto.StudentDto;
import com.music.school.exception.StudentRegisteredPreviouslyException;
import com.music.school.service.SingInStudentService;
import com.music.school.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentResource {

@Autowired
private StudentService studentService;

@Autowired
private SingInStudentService singInStudentService;


@GetMapping
public List<Optional<StudentDto>> getAll() {
	return studentService.getAll();
}

//@GetMapping
public Optional<Student> retrieveStudent(Student student) {
	return studentService.getStudentByNationalCode(student);
}

@PostMapping
@ApiOperation(value = "add a student", response = Iterable.class)
@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully add student"),
		@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
})
public Optional<StudentDto> save(@ApiParam(value = "student object store in database table", required = true)
                                 @Valid @RequestBody Student student) {
	return studentService.save(student);
}

@PostMapping("/api/signInStudent")
public ClientDto singIn(@Valid @RequestBody ClientDto clientDto) {
	return singInStudentService.singInStudent(clientDto);
}

@PostMapping(value = "/api/editStudent")
public void editStudent(@Valid @RequestBody Student student) {
	studentService.editStudentInformation(student);
	
}

@PostMapping(value = "/api/confirmStudent")
public void payCostAndConfirmStudent(@Valid @RequestBody Student student) {
	studentService.paymentAndConfirmation(student);
}

@GetMapping(value = "/api/generateInstituteNo")
public void instituteNoGenerator(@Valid Student student) {
	studentService.instituteNoGenerator(student);
}

@RequestMapping
public ResponseEntity<Object> determineDuplicatedStudent() {
	throw new StudentRegisteredPreviouslyException();
}


}