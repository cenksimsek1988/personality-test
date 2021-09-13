package cenk.st.jpa.repo;

import cenk.st.jpa.entity.StQuestionPredicate;
import cenk.st.jpa.entity.StQuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StQuestionTypeRepo extends JpaRepository<StQuestionType, Long> {
}