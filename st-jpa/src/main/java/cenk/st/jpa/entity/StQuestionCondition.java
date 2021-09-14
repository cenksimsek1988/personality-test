package cenk.st.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "id" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StQuestionCondition {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private StQuestionPredicate predicate;

    @ManyToOne
    @JsonProperty("if_positive")
    private StConditionalQuestion ifPositive;
}
