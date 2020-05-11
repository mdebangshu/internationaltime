package com.lightweight.internationaltime.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "country_validator")
public class CountryValidator {

	private String id;
	private String validity;

	@DynamoDBHashKey(attributeName = "Id")
	public String getId() {
		return id;
	}

	@DynamoDBAttribute(attributeName = "Validity")
	public String getValidity() {
		return validity;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}
}