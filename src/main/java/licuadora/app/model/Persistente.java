package licuadora.app.model;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
public class Persistente {
    @Id
    @GeneratedValue
    private Long id;
}
