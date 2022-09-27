package com.supermercado.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supermercado.dto.CupomFiscalDto;
import com.supermercado.model.CupomFiscal;
import com.supermercado.service.ICupomFiscalService;

@RestController
@RequestMapping(value="/supermercado", produces={MediaType.APPLICATION_JSON_VALUE})
public class CupomFiscalController {

	@Autowired
	private ICupomFiscalService cupomFiscalService;
	
	@GetMapping(value="/cupons")
	public List<CupomFiscal> getAllCupons(){
		
		return  cupomFiscalService.findAll();
		
	}	
	
	@GetMapping(value = "/cupons/{id}")
	public ResponseEntity<Object> getCupomFiscalById(@PathVariable("id") Integer id ) {
		Optional<CupomFiscal> cupomFiscal = cupomFiscalService.findById(id);
		if(!cupomFiscal.isPresent()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cupom Fiscal Não Existe !");
		}
		return ResponseEntity.status(HttpStatus.OK).body(cupomFiscal.get());		
	}	

	
	@PostMapping(value = "/cupons")
	public ResponseEntity<CupomFiscal> saveCupomFiscal(@RequestBody @Valid CupomFiscalDto cupomFiscalDto) {
		var cupomFiscal = new CupomFiscal();
		BeanUtils.copyProperties(cupomFiscalDto, cupomFiscal);
		cupomFiscal.setData(LocalDate.now(ZoneId.of("UTC")));
		cupomFiscal.setHora(LocalDateTime.now(ZoneId.of("UTC")));
		cupomFiscalService.save(cupomFiscal);
		return ResponseEntity.status(HttpStatus.CREATED).body(cupomFiscal);
	}
	
	@PutMapping("/cupons/{id}")
	public ResponseEntity<Object> updateCupomFiscal(@PathVariable(value="id") Integer id, @RequestBody @Valid CupomFiscalDto cupomFiscalDto) {
		Optional<CupomFiscal> cupomFiscalOp = cupomFiscalService.findById(id);
		if(!cupomFiscalOp.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CupomFiscal inexistente.");
		}
		var cupomFiscal = cupomFiscalOp.get();
		BeanUtils.copyProperties(cupomFiscalDto, cupomFiscal);
//		cupomFiscal.setData(LocalDate.now(ZoneId.of("UTC")));
//		cupomFiscal.setHora(LocalDateTime.now(ZoneId.of("UTC")));
		cupomFiscalService.save(cupomFiscal);		
		return ResponseEntity.status(HttpStatus.OK).body(cupomFiscal);
		
	}

    @DeleteMapping("/cupons/{id}")
    public ResponseEntity<Object> deleteCupomFiscal(@PathVariable(value="id") Integer id){
    	Optional<CupomFiscal> cupomFiscalOp = cupomFiscalService.findById(id);
		if(!cupomFiscalOp.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CupomFiscal inexistente.");
		}
		cupomFiscalService.delete(cupomFiscalOp.get());
        return ResponseEntity.status(HttpStatus.OK).body("CupomFiscal deleted successfully.");
    }
	
	
}
