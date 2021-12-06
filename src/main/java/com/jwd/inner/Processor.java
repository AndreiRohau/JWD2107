package com.jwd.inner;

public class Processor {
    public void runProcess(Object o) {
        StateHandler stateHandler = new StateHandler(o);
        subProcessA(stateHandler); // validate object
        subProcessB(stateHandler); // prepare object to main process
        subProcessC(stateHandler); // run update object data before main process
        subProcessD(stateHandler); // run main process
    }

    private void subProcessA(StateHandler stateHandler) {
    }

    private void subProcessB(StateHandler stateHandler) {
    }

    private void subProcessC(StateHandler stateHandler) {
    }

    private void subProcessD(StateHandler stateHandler) {
    }

    private class StateHandler {
        Object o;
        boolean isValid;
        Object ourPreparedObject; // DTO for ex.
        String id;
        String name;

        public StateHandler(Object o) {
            this.o = o;
        }
    }
}
