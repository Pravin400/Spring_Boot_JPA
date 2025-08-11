package org.example.application_relationship_management.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String status;

    private  String position;

    @ManyToOne
    @JoinColumn(name = "applicantId",nullable = false)
    @JsonIgnore
    private  Applicant applicant;
}
