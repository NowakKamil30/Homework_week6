package pl.akademiaspringa.homeworkweek6.Models;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String producer;
    @NotNull
    private int year;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

}
