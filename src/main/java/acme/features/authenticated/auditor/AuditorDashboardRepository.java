
package acme.features.authenticated.auditor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorDashboardRepository extends AbstractRepository {

	@Query("select count(au) from Audit au where au.auditor.id = auditor.id")
	Integer totalNumberOfAudits();

	@Query("select stddev(select count(ar) from AuditingRecord ar where ar.au.id = au.id) from Audit au where au.auditor.id = auditor.id")
	Double deviationNumberOfAuditingRecordsAudit();

	@Query("select avg(select count(ar) from AuditingRecord ar where ar.au.id = au.id) from Audit au where au.auditor.id = auditor.id")
	Double averageNumberOfAuditingRecordsAudit();

	@Query("select max(select count(ar) from AuditingRecord ar where ar.au.id = au.id) from Audit au where au.auditor.id = auditor.id")
	Integer maximunNumberOfAuditingRecordsAudit();

	@Query("select min(select count(ar) from AuditingRecord ar where ar.au.id = au.id) from Audit au where au.auditor.id = auditor.id")
	Integer minimunNumberOfAuditingRecordsAudit();

	@Query("select avg(select sum(ar.duration) from AuditingRecord ar where ar.au.id = au.id) from Audit au where au.auditor.id = auditor.id")
	Double averageTimeOfPeriodLengthAuditingRecords();

	@Query("select stddev(select sum(ar.duration) from AuditingRecord ar where ar.au.id = au.id) from Audit au where au.auditor.id = auditor.id")
	Double deviationTimeOfPeriodLengthAuditingRecords();

	@Query("select min(select sum(ar.duration) from AuditingRecord ar where ar.au.id = au.id) from Audit au where au.auditor.id = auditor.id")
	Double minimunTimeOfPeriodLengthAuditingRecords();

	@Query("select max(select sum(ar.duration) from AuditingRecord ar where ar.au.id = au.id) from Audit au where au.auditor.id = auditor.id")
	Double maximunTimeOfPeriodLengthAuditingRecords();
}