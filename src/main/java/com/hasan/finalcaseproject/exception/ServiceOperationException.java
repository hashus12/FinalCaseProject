package com.hasan.finalcaseproject.exception;

public class ServiceOperationException {
    public static class NotFoundException extends BaseException {
        public NotFoundException(String message) {
            super(message);
        }
    }

    public static class AlreadyExistException extends BaseException {
        public AlreadyExistException(String message) {
            super(message);
        }
    }

    public static class CanNotDeletedException extends BaseException {
        public CanNotDeletedException(String message) {
            super(message);
        }
    }

}
