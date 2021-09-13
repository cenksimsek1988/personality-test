package cenk.st.jpa.entity;

import cenk.st.jpa.common.StQuestionTypeEnum;
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
public class StQuestionType {

    @Id
    @GeneratedValue
    private Long id;

    private StQuestionTypeEnum type;

    @ElementCollection
    private List<String> options;

    @ManyToOne
    private StQuestionCondition condition;
}
