package com.jwd.inner;

public class AnOuter {
    private String string = "str";

    public static class AnInner {
        private String string;

        public AnInner(AnOuter anOuter) {
            this.string = anOuter.string;
        }
    }
}
