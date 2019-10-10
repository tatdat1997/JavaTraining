package new_Package;

/*
 * Copyright (C) 2015 by GMO Runsystem Company
 *
 * Create SortBy class
 *
 * @version 1.0
 *
 * @author DatNT
 *
 */

public enum SortBy {
	SortbyGPA ("GPA"),
	SortByName ("Name");
	
    private String value;
 
    SortBy(String sorttype) {
        this.value = sorttype;
    }
 
    public String getvalue() {
        return value;
    }
}