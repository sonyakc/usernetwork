package users.dao;

public interface Validator<T> {
	boolean validate(T request);
}
