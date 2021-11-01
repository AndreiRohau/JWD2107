package com.jwd.collectionGeneric;

public class Admin extends User {

    private int adminId;

    public Admin(String name, int adminId) {
        super(name);
        this.adminId = adminId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Admin admin = (Admin) o;

        return adminId == admin.adminId;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + adminId;
        return result;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                '}';
    }
}
