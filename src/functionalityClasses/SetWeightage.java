package functionalityClasses;

/**
 * Interface <code>SetWeightage</code> class to edit the weightage of the different 
 * <code>Result</code>components within a specific <code>Course</code>
 * 
 * @author LFM
 * @version 1.0
 * @since 2018-11-05
 */
public interface SetWeightage {
	/**
	 * Method to update the specific weightage of the <code>Result</code> component of the specified
	 * <code>Course</code>
	 * 
	 * @param id ID of the desired <code>Course</code>
	 * @param weight the specified <code>Result</code> weightage
	 * @throws Exception
	 */
	public void setWeightage(String id, int weight) throws Exception;
}
