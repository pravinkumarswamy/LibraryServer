package com.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.dao.LibraryDTO;
import com.library.entities.Library;
import com.library.services.LibraryServices;

@RestController
public class LibraryRestController {
	@Autowired
	private LibraryServices libraryservice;
	//for getting all the library records
	@GetMapping(value="/login")
	public ResponseEntity<LibraryDTO> getAllRecords() {
		LibraryDTO librarydto=new LibraryDTO();
		librarydto.setLibrary(libraryservice.getAllLibrary());
		return new ResponseEntity<LibraryDTO>(librarydto, HttpStatus.OK);
	}
	//first deleting and then fetching all the library records
	@DeleteMapping(value="/delete-record")
	public ResponseEntity<LibraryDTO> deleteById(@RequestParam("student_id")int student_id){
//		System.out.println(student_id);
		libraryservice.deleteRecord(student_id);
		LibraryDTO librarydto=new LibraryDTO();
		librarydto.setLibrary(libraryservice.getAllLibrary());
		return new ResponseEntity<LibraryDTO>(librarydto, HttpStatus.OK);
	}
	//for inserting into DB and then fetching all the library records
	@PostMapping(value="/insert-record")
	public ResponseEntity<LibraryDTO> insert(@RequestBody Library library){
		libraryservice.insertRecord(library);
		LibraryDTO librarydto=new LibraryDTO();
		librarydto.setLibrary(libraryservice.getAllLibrary());
		return new ResponseEntity<LibraryDTO>(librarydto,HttpStatus.OK);
		
		
	}
	//for updating into DB and then fetching all the library records
	@PostMapping(value="/update-record")
	public ResponseEntity<LibraryDTO> update(@RequestBody Library library){
		libraryservice.updateRecord(library);
		LibraryDTO librarydto=new LibraryDTO();
		librarydto.setLibrary(libraryservice.getAllLibrary());
		return new ResponseEntity<LibraryDTO>(librarydto,HttpStatus.OK);
	}
	
	
}
