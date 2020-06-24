package com.agent.agentapp.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "Users")
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS)

public class User extends  SimpleUser {

}