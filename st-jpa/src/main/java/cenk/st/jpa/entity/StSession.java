package cenk.st.jpa.entity;

import cenk.st.jpa.common.StCategory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StSession {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String respondent;

    @Column
    private LocalTime endTime;

}
