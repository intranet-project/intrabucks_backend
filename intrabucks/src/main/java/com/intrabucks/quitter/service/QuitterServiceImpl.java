package com.intrabucks.quitter.service;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.intrabucks.employee.data.repository.DepartmentRepository;
import com.intrabucks.entity.Department;
import com.intrabucks.entity.Quitter;
import com.intrabucks.quitter.data.reactdto.Quitter_QuitterDTO;
import com.intrabucks.quitter.data.repository.QuitterRepository;

/**
 * 퇴사자(Quitter) ServiceImpl : CRUD  
 * @author 구은재
 * @version 1.0 
 * 2024-06-30
 **/

@Service
public class QuitterServiceImpl implements QuitterService{
	
	public final QuitterRepository quitterRepository;
	public final DepartmentRepository departmentRepository;
	
	public QuitterServiceImpl(QuitterRepository quitterRepository, DepartmentRepository departmentRepository) {
		this.quitterRepository = quitterRepository;
		this.departmentRepository = departmentRepository;
	}

	/**퇴사자등록*/
	@Override
	public Long createQuitter(Quitter_QuitterDTO quitterDTO) {
		String deptCode = quitterDTO.getDeptCode(); // 수정된 부분: deptCode 추출
        Department department = departmentRepository.findByDeptCode(deptCode)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Department Code: " + deptCode));
				 
				Quitter quitter = new Quitter();
				quitter.setQuitId(quitterDTO.getQuitId());
				quitter.setQuitName(quitterDTO.getQuitName());
				quitter.setQuitEmail(quitterDTO.getQuitEmail());
				quitter.setQuitPhone(quitterDTO.getQuitPhone());
				quitter.setQuitAddress(quitterDTO.getQuitAddress());
				quitter.setQuitJoindate((Date)quitterDTO.getQuitJoindate());
				quitter.setQuitPosition(quitterDTO.getQuitPosition());
				quitter.setQuitLeavingdate((Date)quitterDTO.getQuitLeavingdate());
				quitter.setDepartment(department);
				System.out.println("quitter : " + quitter);
				
				quitterRepository.save(quitter);
				//System.out.println("quitter : " + quitter);
		        
				return quitter.getQuitId();
	}

	/**퇴사자전체조회*/
	@Override
	public Page<Quitter_QuitterDTO> ListQuitter(String quitName, Pageable pageable) {
		int page = pageable.getPageNumber();
	    if (page < 0) {
	        page = 0;
	    }
		
		final int pageSize = 10;
    	
		pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "quitLeavingdate"));
    	
    	Page<Quitter> quitterPage;
    	
    	if (quitName == null || quitName.isEmpty()) {
            // empName이 null이거나 빈 문자열인 경우 모든 직원을 조회
    		quitterPage = quitterRepository.findAll(pageable);
        } else {
            // empName이 주어진 경우 해당 이름을 포함하는 직원을 조회
        	quitterPage = quitterRepository.findByQuitNameContainingIgnoreCase(quitName, pageable);
        }   
    	   
    	return quitterPage.map(quitter ->
    	new Quitter_QuitterDTO(
    			quitter.getQuitId(), 
    			quitter.getQuitName(), 
    			quitter.getQuitEmail(),
    			quitter.getQuitPhone(), 
    			quitter.getQuitAddress(), 
    			(Date) quitter.getQuitJoindate(), 
                quitter.getQuitPosition(),
                (Date) quitter.getQuitLeavingdate(),
                quitter.getDepartment().getDeptCode()
            )
    	);
	}

	/**퇴사자ID조회*/
	@Override
	public Quitter_QuitterDTO selectOneQuitter(Long quitId) {
		// 퇴사자 ID로 직원 정보를 조회합니다.
		Quitter quitter = quitterRepository.findById(quitId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Employee ID: " + quitId));
       
        return new Quitter_QuitterDTO(
        		quitter.getQuitId(), 
        		quitter.getQuitName(), 
        		quitter.getQuitEmail(),
        		quitter.getQuitPhone(), 
        		quitter.getQuitAddress(), 
        		(Date) quitter.getQuitJoindate(), 
        		quitter.getQuitPosition(),
        		(Date) quitter.getQuitLeavingdate(),
        		quitter.getDepartment().getDeptCode()
        		);
	}

	/**퇴사자정보수정*/
	@Override
	public Long updateQuitter(Quitter_QuitterDTO quitterDTO) {
		Quitter quitter = quitterRepository.findById(quitterDTO.getQuitId())
				.orElseThrow(()-> new IllegalArgumentException("Invalid Quitter ID:" + quitterDTO.getQuitId()));
		
		String deptCode = quitterDTO.getDeptCode(); // 수정된 부분: deptCode 추출
        Department department = departmentRepository.findByDeptCode(deptCode)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Department Code: " + deptCode));
		
		quitter.setQuitName(quitterDTO.getQuitName());
		quitter.setQuitEmail(quitterDTO.getQuitEmail());
        quitter.setQuitPhone(quitterDTO.getQuitPhone());
        quitter.setQuitAddress(quitterDTO.getQuitAddress());
        quitter.setQuitJoindate((Date)quitterDTO.getQuitJoindate());
        quitter.setQuitPosition(quitterDTO.getQuitPosition());
        quitter.setQuitLeavingdate((Date)quitterDTO.getQuitLeavingdate());
        quitter.setDepartment(department);

        // 퇴사자 정보 저장
        quitterRepository.save(quitter);

        return quitter.getQuitId();
	}

	/**퇴사자정보삭제*/
	@Override
	public Long deleteQuitter(Long quitId) {
        Quitter quitter = quitterRepository.findById(quitId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Quitter ID: " + quitId));
       
        quitterRepository.delete(quitter);

        return quitter.getQuitId();
	}
}