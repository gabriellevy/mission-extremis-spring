package fr.mdeharbe.missionextremis;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Mission {

    @org.springframework.data.annotation.Id
    private String id;
    private String name;

    public Mission(String name) {
        this.name = name;
    }
}
