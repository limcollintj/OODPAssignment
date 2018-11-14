package util;

public interface Database {
	public Object getData() throws Exception;
	public void updateData(Object object) throws Exception;
}
