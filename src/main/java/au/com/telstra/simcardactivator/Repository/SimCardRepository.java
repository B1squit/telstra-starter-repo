package au.com.telstra.simcardactivator.Repository;

import org.springframework.data.repository.CrudRepository;

public interface SimCardRepository extends CrudRepository<SimCardEntity, Long> {

    SimCardEntity findById(long id);

    SimCardEntity findByIccid(long iccid);
}