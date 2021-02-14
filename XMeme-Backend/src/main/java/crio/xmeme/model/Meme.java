package crio.xmeme.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "memes")
@Getter
@Setter
public class Meme {
    @Id
    @NotBlank
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    private String name;

    @NotBlank
    private String caption;

    @NotBlank
    private String url;

    private long createdAt;
    private long lastUpdatedAt;
}
