package com.c611.classProject.exception;

public class EmployeeInfoException extends Exception{

    public EmployeeInfoException(){
        super();
    }

    public EmployeeInfoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public EmployeeInfoException(String message, Throwable cause){ super(message, cause); }

    public EmployeeInfoException(String message){ super(message); }

    public EmployeeInfoException(Throwable cause){ super(cause); }
    /*public UserInfoException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserInfoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UserInfoException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserInfoException(String message) {
        super(message);
    }

    public UserInfoException(Throwable cause) {
        super(cause);
    }
    */

}
