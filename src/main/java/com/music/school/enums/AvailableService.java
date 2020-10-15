package com.music.school.enums;


public enum AvailableService {
    
    CLASS_INFORMATION("classInformation", 50001, "هنرجوی گرامی ثبت نام شما با موفقیت ثبت شد."),
    ACCOUNT_STATEMENT("accountstatement", 50002, "گزارش صورت حساب دوره برای شما ارسال گردید"),
    ACCOUNT_HISTORY("accounthistory", 50003, "گزارش گردش حساب دوره برای شما ارسال گردید");
    private String bankService;
    private int bankServiceCode;
    private String context;

    AvailableService() {
    }

    AvailableService(String bankService, int bankServiceCode, String context) {
        this.bankService = bankService;
        this.bankServiceCode = bankServiceCode;
        this.context = context;
    }

    public String getBankService() {
        return bankService;
    }

    public int getBankServiceCode() {
        return bankServiceCode;
    }

    public String getContext() {
        return context;
    }

    public String contextValue(String title) {

        String include="";
        for (AvailableService availableService : AvailableService.values()) {

            if (title.equals(availableService.bankService)){
                include= availableService.context;
                return include;
            }
        }
        return include;
    }

}

