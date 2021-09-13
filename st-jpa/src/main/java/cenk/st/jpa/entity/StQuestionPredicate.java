package cenk.st.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StQuestionPredicate {

    @Id
    @GeneratedValue
    private Long id;

    @ElementCollection
    private List<String> exactEquals;
}
