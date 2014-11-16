package jp.com.inotaku.domain;

import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable{

	@Id
    @NotNull
    private String userName;

    @NotNull
    private String password;

    private boolean enabled;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Authorities> authorities = new HashSet<Authorities>();
}
