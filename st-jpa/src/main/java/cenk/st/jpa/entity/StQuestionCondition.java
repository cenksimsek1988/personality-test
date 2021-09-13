package cenk.st.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StQuestionCondition {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private StQuestionPredicate predicate;

    @ManyToOne
    private StConditionalQuestion ifPositive;
}
