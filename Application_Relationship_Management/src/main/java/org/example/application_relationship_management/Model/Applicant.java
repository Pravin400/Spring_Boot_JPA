package org.example.application_relationship_management.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;
    @Column(unique = true)
    private  String email;
    @Column(unique = true)
    private  String phone;
    private String status;

    //because of cascadin when we adding the applicat first resume add then applicant on the db
    @OneToOne(mappedBy = "applicant",cascade = CascadeType.ALL)
//    we face problem while doing the bidirection gat an looping error
//    applicant -> resume -> applicant ->resume ->applicant -> ......................(infinite loop)
//    this will happpen due to circular dependancy
    private Resume resume;
}
