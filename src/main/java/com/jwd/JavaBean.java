package com.jwd;

public class JavaBean {
    private int i = 1;
    private boolean isMan = false;
    private Boolean isWoman = false;
    private final TmpClass tmpClass = new TmpClass();

    public JavaBean() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JavaBean javaBean = (JavaBean) o;

        if (i != javaBean.i) return false;
        if (isMan != javaBean.isMan) return false;
        if (isWoman != null ? !isWoman.equals(javaBean.isWoman) : javaBean.isWoman != null) return false;
        return tmpClass != null ? tmpClass.equals(javaBean.tmpClass) : javaBean.tmpClass == null;
    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + (isMan ? 1 : 0);
        result = 31 * result + (isWoman != null ? isWoman.hashCode() : 0);
        result = 31 * result + (tmpClass != null ? tmpClass.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JavaBean{" +
                "i=" + i +
                ", isMan=" + isMan +
                ", isWoman=" + isWoman +
                ", tmpClass=" + tmpClass +
                '}';
    }
}
