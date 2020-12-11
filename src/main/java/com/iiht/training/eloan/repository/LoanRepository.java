package com.iiht.training.eloan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iiht.training.eloan.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{

	@Query("SELECT l FROM Loan l WHERE l.customerId = ?1")
	List<Loan> findAllByCustId(Long customerId);
	
	@Query("SELECT l FROM Loan l WHERE l.status ='processed'")
	List<Loan> findAllProcessedLoan();
	
	@Modifying
	@Query("UPDATE Loan l set l.status = 'rejected' where l.id=:loanAppId")
	Loan rejectLoan(Long loanAppId);
	
	@Modifying
	@Query("UPDATE Loan l set l.status ='processed' where l.id=:loanAppId")
	Loan setStatus(Long loanAppId);
	
}
