package com.epam;

public class JavaBean {
    private int i = 1;
    private boolean isMan = false;
    private Boolean isWoman = false;
    private final TmpClass tmpClass = new TmpClass();




    public int getI() {
        return i;
    }

    public synchronized void setI(int i) {
        this.i = i;
    }

    public boolean setMan() {
        return isMan;
    }

    public void setMan(boolean bool) {
        this.isMan = isMan;
    }

    public Boolean getWoman() {
        return isWoman;
    }

    public void setWoman(Boolean woman) {
        isWoman = woman;
    }

    public TmpClass getTmpClass() {
        return tmpClass;
    }
}
