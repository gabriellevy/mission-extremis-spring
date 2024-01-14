package fr.mdeharbe.missionextremis.equipe;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Perso {

    @org.springframework.data.annotation.Id
    private String id;
    private String name;

    public Perso(String name) {
        this.name = name;
    }
}
