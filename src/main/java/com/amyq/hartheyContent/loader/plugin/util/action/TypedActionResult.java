package com.amyq.hartheyContent.loader.plugin.util.action;


import com.amyq.hartheyContent.loader.plugin.util.action.result.Result;

public class TypedActionResult<T> extends ActionResult<T>{
    private final Result result = Result.RESULT_VALUE.get(this);


    public T success(T t) {
        Result.RESULT_VALUE.put(this, Result.SUCCESS);
        return t;
    }

    public T fail(T t) {
        Result.RESULT_VALUE.put(this, Result.FAIL);
        return t;
    }

    public T cancel(T t) {
        return t;
    }
}
