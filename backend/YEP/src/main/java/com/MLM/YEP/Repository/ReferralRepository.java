package com.MLM.YEP.Repository;
import com.MLM.YEP.Entities.ReferralCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferralRepository extends JpaRepository<ReferralCodeEntity , Long> {
}
