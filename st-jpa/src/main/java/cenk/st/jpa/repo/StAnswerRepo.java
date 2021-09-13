package cenk.st.jpa.repo;

import java.util.List;
import java.util.Set;

import cenk.st.jpa.entity.StAnswer;
import cenk.st.jpa.entity.StSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StAnswerRepo extends JpaRepository<StAnswer, Long> {

    List<StAnswer> findAllBySession(StSession session);

    List<StAnswer> findAllBySessionRespondent(String name);
}