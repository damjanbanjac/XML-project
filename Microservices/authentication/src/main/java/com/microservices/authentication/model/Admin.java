package com.microservices.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Getter
@Setter

//@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AdminAuth")
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS)
public class Admin extends  User {
}
