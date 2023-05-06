package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.CunsumerDao;
import com.example.demo.entity.Cunsumer;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class CunsumerServiceImplementation implements CunsumerService{

    @Autowired
    CunsumerDao dao;
	@Override
	public List<Cunsumer> findAllCunsumer() {		
		return dao.findAll();
	}
	@Override
	public Cunsumer addCunsumer(Cunsumer c) {
		Cunsumer existingcsm=dao.findById(c.getCunsumer_id()).orElse(null);
   if(existingcsm==null)
    {
		c.setConsumer_name(c.getConsumer_name());
		c.setAddress(c.getAddress());
		c.setUnit(c.getUnit());
		c.setBill_amt(c.getBill_amt());
		c.setAdmin_id(c.getAdmin_id());
		c.setConnection_type(c.getConnection_type());
		return dao.save(c);
}
else
{
	throw new ResourceNotFoundException("Cunsumer is already exist");
}
}
	@Override
	public Cunsumer getCunsumerByCunsumerId(int cunsumer_id) {

		return this.dao.findById(cunsumer_id).orElseThrow(() -> new ResourceNotFoundException("Cunsumer not exist with CunsumerId :" + cunsumer_id));
	}
	
	@Override
	public Cunsumer updateCunsumer(Cunsumer c) {
		Cunsumer existingCsm=dao.findById(c.getCunsumer_id()).orElseThrow(() -> new ResourceNotFoundException("Cunsumer not exist with id :"));
		
		existingCsm.setConsumer_name(c.getConsumer_name());
		existingCsm.setAddress(c.getAddress());
		existingCsm.setUnit(c.getUnit());
		existingCsm.setBill_amt(c.getBill_amt());
		existingCsm.setAdmin_id(c.getAdmin_id());
		existingCsm.setConnection_type(c.getConnection_type());
		
		return dao.save(existingCsm);
	}
	@Override
	public String deleteByCunsumerId(int cunsumer_id) {
		Cunsumer existsID=dao.findById(cunsumer_id).orElse(null);
		if(existsID!=null)
		{
		dao.deleteById(cunsumer_id);
		return "Cunsumer deleted!!";
		}
		else
		{
		throw new ResourceNotFoundException("CunsumerId  not available");

		}
	}
}
