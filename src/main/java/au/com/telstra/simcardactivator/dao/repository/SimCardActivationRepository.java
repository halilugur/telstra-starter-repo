package au.com.telstra.simcardactivator.dao.repository;

import au.com.telstra.simcardactivator.dao.entity.SimCardActivationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimCardActivationRepository extends JpaRepository<SimCardActivationEntity, Long> {
}
