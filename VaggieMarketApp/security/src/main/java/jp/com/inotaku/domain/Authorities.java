package jp.com.inotaku.domain;
import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Authorities implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
    @NotNull
    private String roleName;


    @ManyToOne
    private User consumer;



	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public User getConsumer() {
		return consumer;
	}

	public void setConsumer(User consumer) {
		this.consumer = consumer;
	}
    
    public Authorities(){}
    
    public Authorities(String roleName){
    	super();
    	this.roleName = roleName;
    }

	public Authorities(String roleName, User consumer) {
		super();
		this.roleName = roleName;
		this.consumer = consumer;
	}

	@Override
	public String toString() {
		return "Authorities [roleName=" + roleName + ", consumer=" + consumer
				+ "]";
	}
    
    
}
