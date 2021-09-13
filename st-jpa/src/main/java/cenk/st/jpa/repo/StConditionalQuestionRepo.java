package cenk.st.jpa.repo;

import cenk.st.jpa.common.StCategory;
import cenk.st.jpa.entity.StConditionalQuestion;
import cenk.st.jpa.entity.StQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StConditionalQuestionRepo extends JpaRepository<StConditionalQuestion, Long> {
}