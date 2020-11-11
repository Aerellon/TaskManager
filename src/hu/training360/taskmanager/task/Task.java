package hu.training360.taskmanager.task;

import hu.training360.taskmanager.exception.ErrorCode;
import hu.training360.taskmanager.exception.TaskManagerException;

import java.util.Objects;

public class Task {

    private String user;
    private String description;
    private HoursToComplete hoursToComplete;
    private Status status;

    public Task(String user, String description, HoursToComplete hoursToComplete) {
        this.user = user;
        this.description = description;
        this.hoursToComplete = hoursToComplete;
        status = Status.NEW;
    }

    public String getUser() {
        return this.user;
    }

    public String getDescription() {
        return this.description;
    }

    public HoursToComplete getHoursToComplete() {
        return this.hoursToComplete;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatusToInProgress() throws TaskManagerException {
        // IN_PROGRESS státuszba, csak NEW és BLOCKED állapotból kerülhet
        if (this.status == Status.DONE) {
            throw new TaskManagerException(ErrorCode.INVALID_STATUS);
        }

        this.status = Status.IN_PROGRESS;
    }

    public void setStatusToDone() throws TaskManagerException {
        // DONE státuszba, csak IN_PROGRESS státuszból kerülhet a feladat
        if (this.status != Status.IN_PROGRESS) {
            throw new TaskManagerException(ErrorCode.INVALID_STATUS);
        }

        this.status = Status.DONE;
    }

    public void setStatusToBlocked() {
        this.status = Status.BLOCKED;
    }

    @Override
    public String toString() {
        return "Task{" +
                "user='" + user + '\'' +
                ", description='" + description + '\'' +
                ", hoursToComplete=" + hoursToComplete.getHoursToComplete() +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(user, task.user) &&
                Objects.equals(description, task.description) &&
                hoursToComplete == task.hoursToComplete &&
                status == task.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, description, hoursToComplete, status);
    }
}
