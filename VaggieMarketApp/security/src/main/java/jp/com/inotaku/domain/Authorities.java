package jp.com.inotaku.domain;
import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Authorities implements Serializable {

	@Id
	@NotNull
    private long roleId;
	
    @NotNull
    private String roleName;

    @NotNull
    @ManyToOne
    private User consumer;
}
