package com.models;
import java.util.*;
public class TaskResolver {

	
	public String GetTasks(int person_id) {
		
		HashMap<Integer,String> db = new HashMap<Integer,String>();
		db.put(1, "1. Copy PPS notes 2. Meet friend at Concordia gate");
		db.put(2, "1. Have fun");
		
		return db.get(person_id);
	}
}
