package com.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.messenger.model.Profile;

public class ProfileService {
	
	private Map<String,Profile> profiles=new HashMap<String,Profile>();

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public static void main(String[] args) {
		D e=new E();
		e.bMethod();
		
		D d2=(D)(new E());
		d2.bMethod();
	}
	
}


interface A { public void aMethod(); }
interface B { public void bMethod(); }
interface C { public void cMethod(); }
class D implements B {

	public void bMethod() {
		// TODO Auto-generated method stub
		
	}
	
}

class E extends D implements C {

	public void aMethod() {
		// TODO Auto-generated method stub
		
	}

	public void bMethod() {
		// TODO Auto-generated method stub
		
	}
	public void cMethod() {
		// TODO Auto-generated method stub
		
	}
}