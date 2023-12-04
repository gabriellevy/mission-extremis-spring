package fr.mdeharbe.missionextremis;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Chapter {

    @org.springframework.data.annotation.Id
    private String id;
    private String name;

    public Chapter(String name) {
        this.name = name;
    }
}
