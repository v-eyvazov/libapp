package az.lib.libapp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 300)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 300)
    private String lastName;

    @Column(name = "second_name", nullable = false, length = 300)
    private String secondName;

    @OneToMany(mappedBy = "author")
    private Set<AuthorsBook> authorsBooks = new LinkedHashSet<>();

}