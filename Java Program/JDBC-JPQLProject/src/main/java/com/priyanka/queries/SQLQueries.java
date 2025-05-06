package com.priyanka.queries;

public interface SQLQueries {

	public final String FILE_LOCATION = "C:\\Users\\skc\\OneDrive\\Pictures\\Screenshots";
    
	public final static String  delete_row="delete from Admin a where a.admin_id=:abc";

	public final static String  UPDATE_ROW="update  Admin a set a.company='HCL' where a.admin_id=?1";

	public final static String FIND_ALL="select a from Admin a";
	
	public final static String ALTER_COMPANY="alter Admin a add constraint abcd unique(company)";
}
