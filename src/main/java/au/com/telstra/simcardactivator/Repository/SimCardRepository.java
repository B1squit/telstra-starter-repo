package au.com.telstra.simcardactivator.Repository;

import org.springframework.data.repository.CrudRepository;

import au.com.telstra.simcardactivator.Foundation.SimCard;

public interface SimCardRepository extends CrudRepository<SimCard, Long> {

    SimCard findById(long id);

    SimCard findByIccid(long iccid);
}