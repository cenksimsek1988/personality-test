package cenk.st.jpa.entity;

import cenk.st.jpa.common.StCategory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "id" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StQuestion {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private StCategory category;

    @OneToOne
    @JsonProperty("question_type")
    private StQuestionType questionType;

    @OneToMany
    private List<StAnswer> answers;

    @Column
    private String question;

}
