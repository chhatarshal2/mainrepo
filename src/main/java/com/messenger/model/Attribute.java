package com.messenger.model;

import java.util.ArrayList;
import java.util.List;

public class Attribute {
	
	private String key;
	private String value;
	private Integer count;
	private Integer sequence;
	private Attribute attribute;
	
	private List<AttributeChoice> attributeChoices=new ArrayList<AttributeChoice>();

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public Attribute getAttribute() {
		return attribute;
	}
	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
	public List<AttributeChoice> getAttributeChoices() {
		return attributeChoices;
	}
	public void setAttributeChoices(List<AttributeChoice> attributeChoices) {
		this.attributeChoices = attributeChoices;
	}
	
}
