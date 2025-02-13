package com.hrm.smartHR.base;

public interface BaseController<O, E, S> {
    O save(E obj, S request);
    O update(E obj, S request);
    O delete(E obj, S request);
    O getAll(S request);
    O getAllActive(S request);
    O getById(int id, S request);
    O getPageableList(int page, int size, String searchValue, S request);
}
