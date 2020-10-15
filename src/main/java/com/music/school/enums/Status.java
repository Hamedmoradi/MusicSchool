package com.music.school.enums;

public enum Status {
        SUCCESS("success",0),
        FAIL("fail",1),
        WAITING("waiting",2);

        private String result;
        private Integer resultCode;

    Status(final String result,final Integer resultCode) {
        this.result = result;
        this.resultCode = resultCode;
    }

    public String getResult() {
        return result;
    }

    public Integer getResultCode() {
        return resultCode;
    }
}
