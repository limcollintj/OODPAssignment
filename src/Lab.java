
public class Lab implements Lessons{
    String lessonID;
    Boolean vacancy;

    public void Lab(String ID, Boolean vacancy) {
        this.lessonID = ID;
        this.vacancy = vacancy;
    }

    @Override
    public void setProfName() {
        // TODO Auto-generated method stub

    }

    @Override
    public void lecturerID() {
        // TODO Auto-generated method stub

    }

    @Override
    public void setStudentIDs() {
        // TODO Auto-generated method stub

    }

    @Override
    public void setVacancy(Boolean vacancy) {
        this.vacancy = vacancy;
    }

}
