package com.jwd;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");

        /*
        case - when we update user-password:
        boolean updatePwdForUser() {
            int updatedRows = 0;
            connection = getConnection(TRUE|false); // hasAutoCommit

            ResultSet rs = connection.prepareStatement(findUserQuery).executeQuery();
            // sleep timeout 15 sec
            if (rs.next()) { // if true - go update password for this user
                updatedRows = connection.prepareStatement(updateUserPasswordQuery).executeUpdate();
            }
            return updatedRows > 0;
        }
         */
    }

        /*
        case - when we update user-password:
        boolean pay() {
            connection = getConnection(false); // hasAutoCommit

            connection.setIsolationLevel();

            connection.prepareStatement(decreaseClientDepositQuery).executeQuery();

            // database error occupied

            connection.prepareStatement(riseShopDepositQuery).executeQuery();

            connection.commit();

            return;
        }
         */
}
