package com.stackroute.musicservice.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data                       // This is used to generate getters and setters by default
@NoArgsConstructor          // This is used to generate by default constructors
@AllArgsConstructor          // This is used to generate argument Constructor
public class Music {
    @Id                     //make id as a primary Key
    private int trackId;
    private String trackName;
    private String overview;
}
