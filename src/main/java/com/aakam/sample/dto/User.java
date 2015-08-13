package com.aakam.sample.dto;

import java.io.Serializable;

import com.aakam.sample.view.UserView;
import com.fasterxml.jackson.annotation.JsonView;

public class User implements Serializable {

	@JsonView(UserView.Detail.class)
	private Long userId;

	@JsonView(UserView.Summary.class)
	private String bioDetails;

	@JsonView(UserView.Summary.class)
	private String firstNm;

	@JsonView(UserView.Detail.class)
	private String lastNm;

	public User(Long userId, String firstNm, String lastNm) {
		this.userId = userId;
		this.firstNm = firstNm;
		this.lastNm = lastNm;
	}

	public User(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getBioDetails() {
		return this.bioDetails;
	}

	public void setBioDetails(String bioDetails) {
		this.bioDetails = bioDetails;
	}

	public String getFirstNm() {
		return this.firstNm;
	}

	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}

	public String getLastNm() {
		return lastNm;
	}

	public void setLastNm(String lastNm) {
		this.lastNm = lastNm;
	}

}