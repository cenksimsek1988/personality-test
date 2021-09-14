package cenk.st.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "id" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StRange {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "_from")
    private int from;

    @Column(name = "_to")
    private int to;
}
