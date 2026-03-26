package com.amyq.hartheyContent.loader.plugin.util.action.result;


import com.amyq.hartheyContent.loader.plugin.util.action.ActionResult;

import java.util.HashMap;
import java.util.Map;

public class Result {
    public static Map<ActionResult<?>, Result> RESULT_VALUE = new HashMap<>();

    public static final Result SUCCESS = new Result(true);
    public static final Result FAIL = new Result(false);

    private final boolean value;

    private Result(boolean value) {

        this.value = value;
    }

}
