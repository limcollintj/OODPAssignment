package DatabaseInstance;

public class DatabaseInstance {
	public InstanceCourses courses; 
	public InstanceResults results; 
	public InstanceStudents students; 
	private static final DatabaseInstance instance = new DatabaseInstance(); 
	
	
	private DatabaseInstance() {
		try {
			this.courses = new InstanceCourses(); 
			this.results = new InstanceResults(); 
			this.students = new InstanceStudents(); 
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public DatabaseInstance getDatabaseInstance() {
		return instance;
	}
	
}
