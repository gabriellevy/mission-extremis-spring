package fr.mdeharbe.missionextremis;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;

@Data
@Document
public class Mission {

    @org.springframework.data.annotation.Id
    private String id;
    private String name;
    private ArrayList<Scene> scenes;

    public Mission(String name, ArrayList<Scene> scenes) {
        this.name = name;
        this.scenes = scenes;
    }
}
