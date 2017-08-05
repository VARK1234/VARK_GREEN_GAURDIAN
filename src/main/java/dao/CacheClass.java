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
		fireTags.add("burning");
		fireTags.add("burnt");
		fireTags.add("smoke");
		fireTags.add("trees");
		fireTags.add("temperature");
		return fireTags;
	}
	
	private Set<String> createTagesInfra() {
		Set<String> infraTags = new HashSet<>();
		infraTags.add("fence");
		infraTags.add("road");
		infraTags.add("broken");
		infraTags.add("going to break");
		infraTags.add("trees");
		infraTags.add("landslide");
		infraTags.add("pit");
		infraTags.add("blocked");
		return infraTags;
	}
	
	private Set<String> createTagesPoaching() {
		Set<String> poachTag = new HashSet<>();
		poachTag.add("gun");
		poachTag.add("guns");
		poachTag.add("arms");
		poachTag.add("killed");
		poachTag.add("killing");
		poachTag.add("fire");
		poachTag.add("firing");
		poachTag.add("hunting");
		poachTag.add("hunters");
		poachTag.add("hunter");
		poachTag.add("people");
		poachTag.add("endangered");
		poachTag.add("trap");
		poachTag.add("poaching");
		poachTag.add("shots");
		poachTag.add("shot");
		return poachTag;
	}
	
	private Set<String> createTagesMedical() {
		Set<String> poachTag = new HashSet<>();
		poachTag.add("blood");
		poachTag.add("bleeding");
		poachTag.add("hurt");
		poachTag.add("broke");
		poachTag.add("free");
		poachTag.add("help");
		poachTag.add("dead");
		poachTag.add("dying");
		poachTag.add("fire");
		poachTag.add("wounded");
		poachTag.add("wound");
		poachTag.add("drowning");
		poachTag.add("pain");
		return poachTag;
	}

	public static Map<String, Set<String>> getAllDepTags(){
		return depTags;
	}
	public static Set<String> getDepTags(String dep){
		return depTags.get(dep);
	}


}