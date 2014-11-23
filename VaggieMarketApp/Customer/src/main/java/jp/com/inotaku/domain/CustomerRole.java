package jp.com.inotaku.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer_role")
public class CustomerRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_role_id")
    private Long customerRoleId;
	
	@ManyToOne
	private Role role;
	
}
