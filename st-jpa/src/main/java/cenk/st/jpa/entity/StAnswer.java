package cenk.st.jpa.entity;

import cenk.st.jpa.common.StCategory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "id" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StAnswer {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private StSession session;

    @ManyToOne
    private StQuestion question;

    @Column
    private String content;

}
