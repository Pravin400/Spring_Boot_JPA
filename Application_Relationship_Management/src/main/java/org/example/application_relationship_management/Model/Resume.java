package org.example.application_relationship_management.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CurrentTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(unique = true,nullable = false)
    private String resume_url;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @PrePersist
    protected void onCreate() {
        created_at = new Date();
    }


    //one applicant can associated with one resume
    @OneToOne
//Make Foreign Key For Resu
    @JoinColumn(name = "applicant_id" )
//in bidirectional mapping to avoid  circular deendancy use the JsonIgnore
    @JsonIgnore
    private Applicant applicant;
}
