package id.web.faisalabdillah.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseDomain {
	@Column
	private String createby;
	@Column
	private Date createtm=new Date();
	@Column
	private String lastupdby;
	@Column
	private Date lastupdtm = new Date();
	@Column
	private Boolean deleted;

	public Boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public Date getCreatetm() {
		return createtm;
	}

	public void setCreatetm(Date createtm) {
		this.createtm = createtm;
	}

	public String getLastupdby() {
		return lastupdby;
	}

	public void setLastupdby(String lastupdby) {
		this.lastupdby = lastupdby;
	}

	public Date getLastupdtm() {
		return lastupdtm;
	}

	public void setLastupdtm(Date lastupdtm) {
		this.lastupdtm = lastupdtm;
	}

}
