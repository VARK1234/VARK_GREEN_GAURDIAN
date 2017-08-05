package dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import beans.Constants;

public class CacheClass {

	private static Map<String, Set<String>> depTags = new HashMap<>();
	
	public CacheClass(){
		depTags.put(Constants.FOREST_AUTHORITY_FIRE, createTagesFire());
		depTags.put(Constants.FOREST_AUTHORITY_INFRASTRUCTURE, createTagesInfra());
		depTags.put(Constants.FOREST_AUTHORITY_POACHING, createTagesPoaching());
		depTags.put(Constants.FOREST_AUTHORITY_MEDICAL, createTagesMedical());
	}
	
	private Set<String> createTagesFire() {
		Set<String> fireTags = new HashSet<>();
		fireTags.add("fire");
		fireTags.add("burn");
		fireTags.add("burnt");
		fireTags.add("smoke");
		fireTags.add("trees");
		fireTags.add("temperature");
		fireTags.add("animals");
		return fireTags;
	}
	
	private Set<String> createTagesInfra() {
		Set<String> infraTags = new HashSet<>();
		infraTags.add("fence");
		infraTags.add("road");
		infraTags.add("broken");
		infraTags.add("animal");
		infraTags.add("trees");
		infraTags.add("landslide");
		infraTags.add("blocked");
		return infraTags;
	}
	
	private Set<String> createTagesPoaching() {
		Set<String> poachTag = new HashSet<>();
		poachTag.add("gun");
		poachTag.add("guns");
		poachTag.add("arms");
		poachTag.add("animals");
		poachTag.add("animal");
		poachTag.add("fire");
		poachTag.add("firing");
		poachTag.add("hunting");
		poachTag.add("endangered");
		poachTag.add("poaching");
		poachTag.add("people");
		poachTag.add("shots");
		return poachTag;
	}
	
	private Set<String> createTagesMedical() {
		Set<String> poachTag = new HashSet<>();
		poachTag.add("blood");
		poachTag.add("hurt");
		poachTag.add("animal");
		poachTag.add("broke");
		poachTag.add("free");
		poachTag.add("help");
		poachTag.add("dead");
		poachTag.add("dying");
		poachTag.add("fire");
		return poachTag;
	}

	public static Map<String, Set<String>> getAllDepTags(){
		return depTags;
	}
	public static Set<String> getDepTags(String dep){
		return depTags.get(dep);
	}


}