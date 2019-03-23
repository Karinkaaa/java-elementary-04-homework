package org.app.woker.entities;

/*
 * Class for representation info about QA engineer.
 *
 * @author alitvinov
 */
public class QAEngineer extends Worker {

    private boolean automationQA;

    public QAEngineer(String workerId, String workerName, boolean automationQA) {
        super(workerId, workerName);
        this.automationQA = automationQA;
    }

    public boolean isAutomationQA() {
        return automationQA;
    }

    public void setAutomationQA(boolean automation) {
        this.automationQA = automation;
    }

    @Override
    public String getWorkerPosition() {
        return super.getWorkerPosition() + ": QAEngeneer";
    }

    @Override
    public String toString() {
        return "QAEngeneer{" +
                "automationQA=" + automationQA +
                ", workerId='" + workerId + '\'' +
                ", workerName='" + workerName + '\'' +
                ", workerPosition='" + workerPosition + '\'' +
                '}';
    }
}
