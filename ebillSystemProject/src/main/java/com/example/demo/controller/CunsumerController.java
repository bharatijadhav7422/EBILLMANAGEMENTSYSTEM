package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Cunsumer;
import com.example.demo.service.CunsumerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/csr")
@CrossOrigin(origins = "http://localhost:4200")
public class CunsumerController {
	@Autowired
	CunsumerService service;
	@GetMapping("/list")
	public List<Cunsumer> getAllCunsumer() 
	{
		return service.findAllCunsumer();
	}
	
	@PostMapping("/addcunsumer")
	public ResponseEntity<Cunsumer> addCunsumer(@Valid @RequestBody Cunsumer c) {

		return new ResponseEntity<Cunsumer>(service.addCunsumer(c), HttpStatus.CREATED);
	}
	@GetMapping("find/{cunsumer_id}")
	public ResponseEntity<Cunsumer> getCunsumerId(@PathVariable("cunsumer_id") int cunsumer_id) {
		return new ResponseEntity<Cunsumer>(service.getCunsumerByCunsumerId(cunsumer_id), HttpStatus.OK);
	}
	@PutMapping("update/{cunsumer_id}")
	public ResponseEntity<Cunsumer> UpdateCunsumer(@Valid  @RequestBody Cunsumer c) {
		return new ResponseEntity<Cunsumer>(service.updateCunsumer(c),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{cunsumer_id}")
	public ResponseEntity<Boolean> deleteCunsumer(@PathVariable("cunsumer_id") int cunsumer_id) {
		service.deleteByCunsumerId(cunsumer_id);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}