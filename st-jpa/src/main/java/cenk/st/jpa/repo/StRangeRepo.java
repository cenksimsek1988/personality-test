package cenk.st.jpa.repo;

import cenk.st.jpa.entity.StQuestionCondition;
import cenk.st.jpa.entity.StRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StRangeRepo extends JpaRepository<StRange, Long> {
}