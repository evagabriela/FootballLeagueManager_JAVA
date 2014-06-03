package com.company;

class QuitCommand implements Command {
    private DoneState done;

    public QuitCommand(DoneState done) {
        this.done = done;
    }

    @Override
    public void execute() {
        done.isDone();
    }

    @Override
    public String name() {
        return "Exit";
    }
}
