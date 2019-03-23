package org.app.woker.entities;

/**
 * Class for representation info about programmer.
 *
 * @author alitvinov
 */
public class Programmer extends Worker {

    public static final String DEFAULT_PROGRAMMER_LANGUAGE = "Java";

    public static final String DEFAULT_PROGRAMMER_RATE = "Junior";

    public static final String POSITION = "Programmer";

    private String language;
    private String rate;

    public Programmer(String workerId, String workerName) {
        this(workerId, workerName, DEFAULT_PROGRAMMER_LANGUAGE, DEFAULT_PROGRAMMER_RATE);
    }

    public Programmer(String workerId, String workerName, String language, String rate) {
        super(workerId, workerName);
        this.language = language;
        this.rate = rate;
        this.workerPosition = POSITION;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String getWorkerPosition() {
        return super.getWorkerPosition() + ": Programmer";
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "language='" + language + '\'' +
                ", rate='" + rate + '\'' +
                ", workerId='" + workerId + '\'' +
                ", workerName='" + workerName + '\'' +
                ", workerPosition='" + workerPosition + '\'' +
                '}';
    }
}
