package com.appointment.app.modaldto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="mobile_number")
public class MobileNmber {
	
	@Id
	private  Long mobileNumber;

	@Column(name = "otp")
	private Integer otp;

	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "StoreIdSequenceGenerator")
	// @SequenceGenerator(name = "StoreIdSequenceGenerator", sequenceName = "store_storeid_seq")  
    //  @Column(name = "mobid") 
	// private Long mobId;
	
	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "MobileNmber [mobileNumber=" + mobileNumber + ", otp=" + otp + "]";
	}

	
	// public Long getMobId() {
	// 	return mobId;
	// }

	// public void setMobId(Long mobId) {
	// 	this.mobId = mobId;
	// }

	

}
