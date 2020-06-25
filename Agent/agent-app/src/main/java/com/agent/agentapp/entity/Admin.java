package com.agent.agentapp.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "AdminApp")
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS)
public class Admin extends SimpleUser {



}
