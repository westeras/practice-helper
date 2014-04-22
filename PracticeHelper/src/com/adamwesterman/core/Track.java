package com.adamwesterman.core;

public class Track {
	private String name;
	private String artist;
	
	public Track(String name, String artist) {
		super();
		this.name = name;
		this.artist = artist;
	}
	
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected String getArtist() {
		return artist;
	}
	protected void setArtist(String artist) {
		this.artist = artist;
	}
}
