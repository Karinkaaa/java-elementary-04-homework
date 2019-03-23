package org.app.woker.application;

import org.app.woker.entities.Manager;
import org.app.woker.entities.Programmer;
import org.app.woker.entities.QAEngineer;
import org.app.woker.entities.Worker;


public final class WorkerInfoStore {

    private static final int INITIAL_ARRAY_SIZE = 1;

    /**
     * Factor for extending length of array:
     * old length  = 1
     * new length will be 1 * LENGTH_EXTEND_FACTOR
     */
    private static final int LENGTH_EXTEND_FACTOR = 2;

    private Manager[] managers = new Manager[INITIAL_ARRAY_SIZE];
    private Programmer[] programmers = new Programmer[INITIAL_ARRAY_SIZE];
    private QAEngineer[] qaEngineers = new QAEngineer[INITIAL_ARRAY_SIZE];

    private int managersCount;
    private int programmersCount;
    private int qaEngineersCount;

    private static final WorkerInfoStore workerInfoStoreSingleton = new WorkerInfoStore();

    private WorkerInfoStore() {
    }

    public static WorkerInfoStore getWorkerInfoStoreSingleton() {
        return workerInfoStoreSingleton;
    }

    public void add(Manager worker) {
        if (managers.length <= managersCount) {
            managers = (Manager[]) extendArrayLength(managers);
        }
        managers[managersCount] = worker;
        managersCount += 1;
    }

    public void add(Programmer worker) {
        if (programmers.length <= programmersCount) {
            programmers = (Programmer[]) extendArrayLength(programmers);
        }
        programmers[programmersCount] = worker;
        programmersCount += 1;
    }

    public void add(QAEngineer worker) {
        if (qaEngineers.length <= qaEngineersCount) {
            qaEngineers = (QAEngineer[]) extendArrayLength(qaEngineers);
        }
        qaEngineers[qaEngineersCount] = worker;
        qaEngineersCount += 1;
    }

    public void add(Worker worker) {
        if (worker == null) {
            return;
        }
        if (worker instanceof Programmer) {
            add((Programmer) worker);
        } else if (worker instanceof Manager) {
            add((Manager) worker);
        } else if (worker instanceof QAEngineer) {
            add((QAEngineer) worker);
        } else {
            System.out.println("Unknown worker class!");
        }
        System.out.println("Worker successfully added: " + worker);
    }

    public Worker[] getWorkersByClass(Class currentClass) {
        Worker[] source = null;
        if (currentClass == Programmer.class) {
            return programmers;
        } else if (currentClass == Manager.class) {
            return managers;
        } else if (currentClass == QAEngineer.class) {
            return qaEngineers;
        } else {
            return null;
        }
    }


    /**
     * Dynamically extend length of array.
     *
     * @param source array which should be extended.
     * @return array Worker[] with double length of source, and which stores all elements of source array.
     */
    private Worker[] extendArrayLength(Worker[] source) {
        //create new array with length = source.length * LENGTH_EXTEND_FACTOR
        Worker[] destination = new Worker[source.length * LENGTH_EXTEND_FACTOR];
        int firstElementPosition = 0;
        //This method does fast copy of one array to another.
        System.arraycopy(source, firstElementPosition, destination, firstElementPosition, source.length);
        System.out.println("Source array was extended from " + source.length + " to " + destination.length);
        return destination;
    }
}
