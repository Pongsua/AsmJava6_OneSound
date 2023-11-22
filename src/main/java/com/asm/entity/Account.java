package com.asm.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Accounts")
public class Account {
	@Id
	private String username;
	private String password;
	private String fullname;
	private String email;
	private Boolean role;
	private String phoneNumber;
	@JsonIgnore
	@OneToMany(mappedBy = "user")
    private List<Favorite> favorites;
}
