package org.app.woker.application;

import org.app.woker.entities.*;

import java.util.Scanner;

/**
 * JavaElementary Homework N4.
 *
 * @author alitvinov
 */
public class WorkerApplication {

    public static void main(String[] args) {
        Scanner consoleInputReader = new Scanner(System.in);
        String command = null;
        WorkerApplication application = new WorkerApplication();

        while (command == null || !command.equals("exit")) {
            command = application.readLineFromConsole(consoleInputReader, "Please enter command (add, view, exit)");
            application.executeCommand(command);
        }
    }

    /**
     * Execution of command.
     *
     * @param command command which should be executed.
     */
    public void executeCommand(String command) {
        switch (command) {
            case "add":
                Worker newWorker = getNewWorker();
                WorkerInfoStore.getWorkerInfoStoreSingleton().add(newWorker);
                return;
            case "view":
                System.out.println("This feature is not implemented");
                return;
            case "exit":
                return;
            default:
                System.out.println("Unknown command. Please try again.");
        }
    }

    /**
     * Get new object of class Worker.
     *
     * @return instance of Programmer or Manager or QAEngineer, or NULL if user will enter type != p,m,q
     */
    public Worker getNewWorker() {
        Scanner consoleInputReader = new Scanner(System.in);

        String id = readLineFromConsole(consoleInputReader, "Please enter worker id:");
        String name = readLineFromConsole(consoleInputReader, "Please enter worker name:");
        String type = readLineFromConsole(consoleInputReader, "Please enter worker type (p,m,q):");

        return getSpecificWorkerByType(type, new Worker(id, name), consoleInputReader);
    }

    /**
     * Get instance of Worker by type.
     *
     * @param type type, which was entered by user.
     * @param baseWorker Worker object, which stores id and name, which were entered by user.
     * @param consoleInputReader Scanner object for reading of user input
     *
     * @return if type = p will return object of Programmer class
     *  if type = m will return object of Manager class
     *  if type = q will return object of QAEngineer class
     *  else will return NULL
     */
    private Worker getSpecificWorkerByType(String type, Worker baseWorker, Scanner consoleInputReader) {
        switch (type) {
            case "p":
                String language = readLineFromConsole(consoleInputReader, "Please enter language");
                String rate = readLineFromConsole(consoleInputReader, "Please enter rate");
                return new Programmer(baseWorker.getWorkerId(), baseWorker.getWorkerName(), language, rate);
            case "m":
                String project = readLineFromConsole(consoleInputReader, "Please enter project");
                return new Manager(baseWorker.getWorkerId(), baseWorker.getWorkerName(), project);
            case "q":
                return new QAEngineer(baseWorker.getWorkerId(), baseWorker.getWorkerName(), true);
            default:
                System.out.println("Type " + type + " is unknown. Please try again.");
                return null;
        }
    }

    /**
     * Method for reading string from console.
     *
     * @param consoleInputReader Scanner object for reading user input from console
     * @param message message which will be printed on console,
     * @return String which was entered by user.
     */
    private String readLineFromConsole(Scanner consoleInputReader, String message) {
        System.out.println(message);
        return consoleInputReader.nextLine();
    }
}
