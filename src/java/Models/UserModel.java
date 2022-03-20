/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author user
 */
public class UserModel {

    private int sysUserID;
    private int studnetID;
    private String full_name;
    private String username;
    private String password;
    private String userType;
    private int status;
    private String dateTime;

    private static int student_id = 0;
    private static int loggedUserId = 0;
    private static int classLevel = 0;
    private static String loggedUserFullName = "";
    private static String loggedUserType = "";

    private static final UserModel insUserModel = new UserModel();

    private UserModel() {
    }

    public static UserModel getInstance() {
        return insUserModel;
    }

    public static int getLoggedUserId() {
        return loggedUserId;
    }

    public static void setLoggedUserId(int aLoggedUserId) {
        loggedUserId = aLoggedUserId;
    }

    public static String getLoggedUserFullName() {
        return loggedUserFullName;
    }

    public static void setLoggedUserFullName(String aLoggedUserFullName) {
        loggedUserFullName = aLoggedUserFullName;
    }

    public static int getClassLevel() {
        return classLevel;
    }

    public static void setClassLevel(int classLevel) {
        UserModel.classLevel = classLevel;
    }
    

    public static String getLoggedUserType() {
        return loggedUserType;
    }

    public static void setLoggedUserType(String aLoggedUserType) {
        loggedUserType = aLoggedUserType;
    }

    public int getSysUserID() {
        return sysUserID;
    }

    public void setSysUserID(int sysUserID) {
        this.sysUserID = sysUserID;
    }

    public int getStudnetID() {
        return studnetID;
    }

    public void setStudnetID(int studnetID) {
        this.studnetID = studnetID;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public static int getStudent_id() {
        return student_id;
    }

    public static void setStudent_id(int student_id) {
        UserModel.student_id = student_id;
    }

}
