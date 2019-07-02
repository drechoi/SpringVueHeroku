package com.example.demo.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper=true)
public class AppUser extends BaseEntity{	
    @Column(unique = true)
    @NotBlank
    private String extId;

    @NotBlank
    private String userName;
    
    @Email
    private String email;
    
    private String picture;
        
    @ManyToOne
    private Scheme defaultScheme;
    // joiner or backer
    private String defaultSchemeRole;
    
    private String loginToken;
    private Date loginTokenExpiry;
}
