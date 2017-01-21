package com.messenger.controller;

import java.util.List;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DataStore {
	private List<String> ceos;
    private List<String> companies;

    public DataStore() {

        String data = "Steve Jobs, Bill Gates, Dell, Larry Ellision, Lary Page, Sergy Brin";

        ceos = new ArrayList<String>();
        StringTokenizer token = new StringTokenizer(data, ",");

        while(token.hasMoreTokens()) {
            ceos.add(token.nextToken().trim());
        }

        String strTags = "Apple, Microsoft, Oracle, Google, Facebook, Twitter";
        companies = new ArrayList<String>();
        StringTokenizer token2 = new StringTokenizer(strTags, ",");

        while(token2.hasMoreTokens()) {
            companies.add(token2.nextToken().trim());
        }

    }

    public List<String> getCeosList(String query) {

        String country = null;
        query = query.toLowerCase();
        List<String> matched = new ArrayList<String>();
        for(int i=0; i < ceos.size(); i++) {
            country = ceos.get(i).toLowerCase();
            if(country.startsWith(query)) {
                matched.add(ceos.get(i));
            }
        }
        return matched;
    }

    public List<String> getCoList(String query) {
        String country = null;
        query = query.toLowerCase();
        List<String> matched = new ArrayList<String>();
        for(int i=0; i < companies.size(); i++) {
            country = companies.get(i).toLowerCase();
            if(country.startsWith(query)) {
                matched.add(companies.get(i));
            }
        }
        return matched;
    }
}