import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Evt {

    @org.springframework.data.annotation.Id
    private String id;
    private String name;

    public Evt(String name) {
        this.name = name;
    }
}
