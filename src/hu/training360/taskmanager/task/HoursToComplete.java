package hu.training360.taskmanager.task;

public enum HoursToComplete {

    ONE_HOUR(1), TWO_HOURS(2), THREE_HOURS(3), FIVE_HOURS(5), EIGHT_HOURS(8);

    private int hoursToComplete;

    HoursToComplete(int hoursToComplete) {
        this.hoursToComplete = hoursToComplete;
    }

    public int getHoursToComplete() {
        return this.hoursToComplete;
    }
}
