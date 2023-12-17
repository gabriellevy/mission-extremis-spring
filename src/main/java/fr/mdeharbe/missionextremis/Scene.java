package fr.mdeharbe.missionextremis;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Scene {

    @org.springframework.data.annotation.Id
    private String id;
    private String name;

    public Scene(String name) {
        this.name = name;
    }
}
