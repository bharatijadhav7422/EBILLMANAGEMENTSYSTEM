package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Cunsumer;

public interface CunsumerService {
	public List<Cunsumer>findAllCunsumer();
	public Cunsumer addCunsumer(Cunsumer c);
	public Cunsumer getCunsumerByCunsumerId(int cunsumer_id);
	public Cunsumer updateCunsumer(Cunsumer c);
	public String deleteByCunsumerId(int cunsumer_id);
	
}