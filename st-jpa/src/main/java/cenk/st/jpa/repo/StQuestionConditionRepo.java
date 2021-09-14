package cenk.st.jpa.repo;

import cenk.st.jpa.entity.StConditionalQuestion;
import cenk.st.jpa.entity.StQuestionCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StQuestionConditionRepo extends JpaRepository<StQuestionCondition, Long> {
}