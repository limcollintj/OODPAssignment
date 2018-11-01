package functionalityClasses;

import courses.Course;
import courses.CourseInfo;

public class GetCourseByID implements GetByID{
	
	 /**
     * Returns a <code>Course</code> object corresponding to the course ID 
     * that can then be used to extract information of the specific 
     * course.
     * <p>
     * 
     * 
     * @param courseID - a unique ID corresponding to an existing Course
     * @return Course 
     * @throws Exception 
     * @see CourseInfo 
     */

	@Override
	public Object getByID(String id)  {
		
		   for (Course temp : retrieveCourses() ) {
	            if(temp.getCourseID().equals(id)) {
	                return temp;
	            }
	        }
		   
	        throw new Exception("This course cannot be found");
	        
	}
}
