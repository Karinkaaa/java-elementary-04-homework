package org.app.woker.entities;

/*
 * Class for representation info about manager.
 *
 * @author alitvinov
 */
public class Manager extends Worker {

    private String projectName;
    private String project;
    private int expirience;

    public Manager(String workerId, String workerName, String projectName) {
        super(workerId, workerName);
        this.projectName = projectName;
    }

    @Override
    public String getWorkerPosition() {
        return super.getWorkerPosition() + ": Manager";
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "projectName='" + projectName + '\'' +
                ", workerId='" + workerId + '\'' +
                ", workerName='" + workerName + '\'' +
                ", workerPosition='" + workerPosition + '\'' +
                '}';
    }
}
