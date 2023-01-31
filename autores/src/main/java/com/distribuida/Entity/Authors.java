package com.distribuida.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Authors extends PanacheEntity{
		public String first_name;
		public String last_name;
}
