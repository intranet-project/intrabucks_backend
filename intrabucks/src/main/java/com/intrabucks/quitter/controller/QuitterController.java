package com.intrabucks.quitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intrabucks.entity.Employee;
import com.intrabucks.quitter.data.reactdto.Quitter_QuitterDTO;
import com.intrabucks.quitter.service.QuitterService;

/**
 * 직원(Employee) Controller : CRUD 퇴사자등록, 퇴사자전체조회, 퇴사자ID조회, 퇴사자정보수정, 퇴사자정보삭제 (Talend완료)
 * @author 구은재
 * @version 1.0 
 * 2024-06-30
**/

@RestController
@RequestMapping("/api/v1/intrabucks/quitter")
public class QuitterController {

	private  final QuitterService quitterService;
	
	@Autowired
	public QuitterController(QuitterService quitterService) {
		this.quitterService = quitterService;
	}
	
	/**퇴사자등록*/
	@PostMapping("/create")
	public ResponseEntity<Long> createQuitter(@RequestBody Quitter_QuitterDTO QuitterDTO){
	 // 직원이 존재하는 경우 퇴사자 정보를 생성
				Long quitId = quitterService.createQuitter(QuitterDTO);
				return ResponseEntity.ok().body(quitId);

}
	
	/**퇴사자전체조회*/
	@GetMapping("/select")
	public ResponseEntity<Page<Quitter_QuitterDTO>> getAllEntity(@RequestParam(required = false) String empName,
			@RequestParam(required = false) Integer page, @RequestParam(defaultValue = "10") int size) {

		int pageNumber = (page != null && page > 0) ? page : 0;
		PageRequest pageable = PageRequest.of(pageNumber, size, Sort.by(Sort.Direction.DESC, "quitLeavingdate"));
		Page<Quitter_QuitterDTO> quitters = quitterService.ListQuitter(empName, pageable);
		return ResponseEntity.ok().body(quitters);
	}
	
	/**퇴사자ID조회*/
	@GetMapping("/{quitId}")
	public ResponseEntity<Quitter_QuitterDTO> selectOneQuitter(@PathVariable Long quitId) {
		Quitter_QuitterDTO QuitterDTO = quitterService.selectOneQuitter(quitId);

		if (QuitterDTO != null) {
			return ResponseEntity.ok().body(QuitterDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	/**퇴사자정보수정*/
	@PutMapping("/update/{quitId}")
	public ResponseEntity<Long> updateQuitter(@RequestBody Quitter_QuitterDTO quitterDTO) {
		Long quitId = quitterService.updateQuitter(quitterDTO);
		return ResponseEntity.ok().body(quitId);
	}
	
	/**퇴사자정보삭제*/
	@DeleteMapping("/delete/{quitId}")
	public ResponseEntity<Long> deleteQuitter(@PathVariable Long quitId) {
		Long deletedquitId = quitterService.deleteQuitter(quitId);
		return ResponseEntity.ok().body(deletedquitId);
	}
	
}
