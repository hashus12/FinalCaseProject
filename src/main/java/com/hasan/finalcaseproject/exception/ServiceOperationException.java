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

    public static class NotCreatedException extends BaseException {
        public NotCreatedException(String message) {
            super(message);
        }
    }

    public static class AlreadyDeletedException extends BaseException {
        public AlreadyDeletedException(String message) {
            super(message);
        }
    }

    public static class CanNotDeletedException extends BaseException {
        public CanNotDeletedException(String message) {
            super(message);
        }
    }

    public static class NotValidException extends BaseException {
        public NotValidException(String message) {
            super(message);
        }
    }
}
