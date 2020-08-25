package com.dxctraining.computermgt.controller;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;

import com.dxctraining.computermgt.computer.dto.ComputerDto;
import com.dxctraining.computermgt.computer.dto.CreateComputerRequest;
import com.dxctraining.computermgt.computer.dto.SupplierDto;
import com.dxctraining.computermgt.computer.entities.Computer;
import com.dxctraining.computermgt.computer.service.IComputerService;
import com.dxctraining.computermgt.computer.util.ComputerUtil;

@RestController
@RequestMapping("/computers")
@Controller
public class ComputerController {
	@Autowired
	private IComputerService computerservice;
	
	@Autowired
	private ComputerUtil computerUtil;
	
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ComputerDto create(@RequestBody CreateComputerRequest requestData) {
        String name = requestData.getName();
        int supplierId = requestData.getSupplierId();
        int diskSize=requestData.getDiskSize();
        Computer computer = new Computer(name, supplierId, diskSize);
        SupplierDto supplier = fetchFromSupplierAppById(supplierId);
        ComputerDto response = computerUtil.computerDto(computer, supplierId, computer.getName());
        return response;
    }

    @GetMapping("/get/{id}")
    public ComputerDto findPhone(@PathVariable("id") int id) {
    	Computer computer = computerservice.findComputerById(id);
        int supplierId = computer.getSupplierId();
        SupplierDto supplier = fetchFromSupplierAppById(supplierId);
		ComputerDto response = computerUtil.computerDto(computer, supplierId, supplier.getName());
		return response;
    }

    @GetMapping
    public List<ComputerDto> fetchAll() {
        List<Computer> list = computerservice.allComputers();
        List<ComputerDto>response=new ArrayList<>();
        for (Computer computer:list){
            int  supplierId=computer.getSupplierId();
            SupplierDto supplier= fetchFromSupplierAppById(supplierId);
            ComputerDto dto=computerUtil.computerDto(computer,supplierId,supplier.getName());
            response.add(dto);
        }
        return response;
    }

    @GetMapping("/supplier/{supplierId}")
    public List<ComputerDto> fetchAllComputersBySupplier(@PathVariable("supplierId") int supplierId) {
    	List<Computer> list = computerservice.allComputersBySupplier(supplierId);
    	List<ComputerDto> response=new ArrayList<>();
    	SupplierDto supplier= fetchFromSupplierAppById(supplierId);
    	for (Computer computer : list) {
			ComputerDto computerDto = computerUtil.computerDto(computer, supplierId, supplier.getName());
			response.add(computerDto);
		}
		return response;
    }

    public SupplierDto fetchFromSupplierAppById(int supplierId) {
        String url = "http://localhost:8586/suppliers/get/" + supplierId;
        SupplierDto dto = restTemplate.getForObject(url, SupplierDto.class);
        return dto;
    }
}

/*
@GetMapping("/authenticate/{id}/{password}")
public boolean authenticate(@PathVariable("id") int id, @PathVariable("password") String password) {
    boolean result =computerservice.authenticate(id, password);
    return result;
}*/