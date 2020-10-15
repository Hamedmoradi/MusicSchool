package com.music.school.providers;

import com.kavenegar.sdk.KavenegarApi;
import com.kavenegar.sdk.excepctions.ApiException;
import com.kavenegar.sdk.excepctions.HttpException;
import com.kavenegar.sdk.models.*;
import org.springframework.stereotype.Component;
import javax.mail.MessagingException;

@Component
public class SmsProvider extends AbstractProviderService {

    public SmsProvider() {
    }

    public SmsProvider(String to, String subject, String text, KavenegarApi api) {
        super(to, subject, text);
        this.api = api;
    }

    public SmsProvider(KavenegarApi api) {
        this.api = api;
    }

    KavenegarApi api = new KavenegarApi("375A5662725931504E3236524F485550426A6666546B6131552F59474D5335386E6F524F2B50513955704D3D");

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
//        String sender = "1000596446" ;
        String sender = "2000500666" ;
        String receptor = "09378288717" ;
        String message = "سلام حامد مرادی عزیر موفق باشی قهرمان ، وب سرویس پیام کوتاه کاوه نگار" ;
        api.send(sender, to, text );

    }

    @Override
    public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException {

    }
    public  void send() {
        try {
            String sender = "YourLine";
            String receptor = "MonilePhone";
            String message = "Message here";
            SendResult Result = api.send(sender, receptor, message);
            System.out.println("messageid : " + Result.getMessageId());
            System.out.println("message  : " + Result.getMessage());
            System.out.println("status  : " + Result.getStatus());
            System.out.println("statustext  : " + Result.getStatusText());
            System.out.println("sender  : " + Result.getSender());
            System.out.println("receptor  : " + Result.getReceptor());
            System.out.println("date  : " + Result.getDate());
            System.out.println("cost  : " + Result.getCost());
        } catch (HttpException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
            System.out.print("HttpException  : " + ex.getMessage());
        } catch (ApiException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
            System.out.print("ApiException : " + ex.getMessage());
        }
    }



//    public static void sendArray() {
//        try {
//            List<String> receptors = new ArrayList<>();
//            receptors.add("");
//            List<String> senders = new ArrayList<>();
//            senders.add("");
//            List<String> messages = new ArrayList<>();
//            messages.add("");
//            List < SendResult > Results = api.sendArray(senders, receptors, messages);
//            for (SendResult Result: Results) {
//                System.out.println("messageid : " + Result.getMessage());
//                System.out.println("message  : " + Result.getMessage());
//                System.out.println("status  : " + Result.getStatus());
//                System.out.println("statustext  : " + Result.getStatusText());
//                System.out.println("sender  : " + Result.getSender());
//                System.out.println("receptor  : " + Result.getReceptor());
//                System.out.println("date  : " + Result.getDate());
//                System.out.println("cost  : " + Result.getCost());
//            }
//        } catch (HttpException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("HttpException  : " + ex.getMessage());
//        } catch (ApiException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("ApiException : " + ex.getMessage());
//        }
//    }
//
//
//    public static void status() {
//        try {
//            long messageid = 56169156;
//            StatusResult Result = api.status(messageid);
//            System.out.println("messageid : " + Result.getMessageId());
//            System.out.println("status  : " + Result.getStatus());
//            System.out.println("statustext  : " + Result.getStatusText());
//        } catch (HttpException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("HttpException  : " + ex.getMessage());
//        } catch (ApiException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("ApiException : " + ex.getMessage());
//        }
//    }
//
//
//
//    public static void statusLocalMessageId() {
//        try {
//            long localid = 56169156;
//            StatusLocalMessageIdResult Result = api.statusLocalMessageId(localid);
//            System.out.println("messageid : " + Result.getMessageId());
//            System.out.println("localid  : " + Result.getLocalId());
//            System.out.println("status  : " + Result.getStatus());
//            System.out.println("statustext  : " + Result.getStatusText());
//
//        } catch (HttpException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("HttpException  : " + ex.getMessage());
//        } catch (ApiException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("ApiException : " + ex.getMessage());
//        }
//    }
//
//
//
//    public static void select() {
//        try {
//            long massageIds = 56169156;
//            SendResult Result = api.select(massageIds);
//            System.out.println("messageid : " + Result.getMessage());
//            System.out.println("message  : " + Result.getMessage());
//            System.out.println("status  : " + Result.getStatus());
//            System.out.println("statustext  : " + Result.getStatusText());
//            System.out.println("sender  : " + Result.getSender());
//            System.out.println("receptor  : " + Result.getReceptor());
//            System.out.println("date  : " + Result.getDate());
//            System.out.println("cost  : " + Result.getCost());
//        }catch (HttpException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("HttpException  : " + ex.getMessage());
//        } catch (ApiException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("ApiException : " + ex.getMessage());
//        }
//    }
//
//
//    public static void selectOutbox() {
//        try {
//            long startdate = 1432651200;
//            long enddate = 1443278400;
//            String sender = "";
//            List < SendResult > Results = api.selectOutbox(startdate, enddate, sender);
//            for (SendResult Result: Results) {
//                System.out.println("message : " + Result.getMessage());
//                System.out.println("messageid : " + Result.getMessageId());
//                System.out.println("status : " + Result.getStatus());
//                System.out.println("statustext : " + Result.getStatusText());
//                System.out.println("sender : " + Result.getSender());
//                System.out.println("receptor : " + Result.getReceptor());
//                System.out.println("date : " + Result.getDate());
//                System.out.println("cost : " + Result.getCost());
//                System.out.println("\r\n");
//            }
//        } catch (HttpException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("HttpException  : " + ex.getMessage());
//        } catch (ApiException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("ApiException : " + ex.getMessage());
//        }
//    }
//
//
//
//    public static void latestOutbox() {
//        try {
//            long pagesize = 100;
//            String sender = "";
//            List < SendResult > Results = api.latestOutbox(pagesize, sender);
//            for (SendResult Result: Results) {
//                System.out.println("message : " + Result.getMessage());
//                System.out.println("messageid : " + Result.getMessageId());
//                System.out.println("status : " + Result.getStatus());
//                System.out.println("statustext : " + Result.getStatusText());
//                System.out.println("sender : " + Result.getSender());
//                System.out.println("receptor : " + Result.getReceptor());
//                System.out.println("date : " + Result.getDate());
//                System.out.println("cost : " + Result.getCost());
//                System.out.println("\r\n");
//            }
//        } catch (HttpException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("HttpException  : " + ex.getMessage());
//        } catch (ApiException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("ApiException : " + ex.getMessage());
//        }
//    }
//
//
//    public static void countOutbox() {
//        try {
//            long startdate = 1432651200;
//            long enddate = 1443278400;
//            int status = 10;
//            CountOutboxResult Result = api.countOutbox(startdate, enddate, status);
//            System.out.println("startdate : " + Result.getStartDate());
//            System.out.println("enddate : " + Result.getEndDate());
//            System.out.println("sumcount : " + Result.getSumCount());
//            System.out.println("sumpart : " + Result.getSumPart());
//            System.out.println("sumcost : " + Result.getCost());
//        } catch (HttpException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("HttpException  : " + ex.getMessage());
//        } catch (ApiException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("ApiException : " + ex.getMessage());
//        }
//    }
//
//
//    public static void cancel() {
//        try {
//            long messageid = 56169156;
//            com.kavenegar.sdk.models.StatusResult Result;
//            Result = api.cancel(messageid);
//            System.out.println("messageid : " + Result.getMessageId());
//            System.out.println("status  : " + Result.getStatus());
//            System.out.println("statustext  : " + Result.getStatusText());
//
//        }catch (HttpException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("HttpException  : " + ex.getMessage());
//        } catch (ApiException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("ApiException : " + ex.getMessage());
//        }
//    }
//
//    public static void receive() {
//        try {
//            String linenumber = "";
//            int isread = 1;
//            List <ReceiveResult> Results = api.receive(linenumber, isread);
//            for (ReceiveResult Result: Results) {
//                System.out.println("messageid : " + Result.getMessage());
//                System.out.println("message  : " + Result.getMessage());
//                System.out.println("sender  : " + Result.getSender());
//                System.out.println("receptor  : " + Result.getReceptor());
//                System.out.println("date  : " + Result.getDate());
//            }
//        } catch (HttpException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("HttpException  : " + ex.getMessage());
//        } catch (ApiException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("ApiException : " + ex.getMessage());
//        }
//    }
//
//
//    public static void countInbox() {
//        try {
//            long startdate = 1432651200;
//            long enddate = 1443278400;
//            String linenumber = "";
//            int isread = 1;
//            CountInboxResult Result = api.countInbox(startdate, enddate, linenumber, isread);
//            System.out.println("startdate : " + Result.getStartDate());
//            System.out.println("enddate : " + Result.getEndDate());
//            System.out.println("sumcount : " + Result.getSumCount());
//
//        } catch (HttpException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("HttpException  : " + ex.getMessage());
//        } catch (ApiException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("ApiException : " + ex.getMessage());
//        }
//    }
//
//    public static void countPostalCode() {
//        try {
//            long postacode = 4415853;
//            List < CountPostalCodeResult > Results = api.countPostalCode(postacode);
//            for (CountPostalCodeResult Result: Results) {
//                System.out.println("section : " + Result.getSection());
//                System.out.println("value : " + Result.getValue());
//            }
//        } catch (HttpException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("HttpException  : " + ex.getMessage());
//        } catch (ApiException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("ApiException : " + ex.getMessage());
//        }
//
//    }
//
//    public static void accountInfo() {
//        try {
//            AccountInfoResult Result = api.accountInfo();
//            System.out.println("remaincredit : " + Result.getRemainCredit());
//            System.out.println("expiredate : " + Result.getExpireDate());
//            System.out.println("type : " + Result.getType());
//        } catch (HttpException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("HttpException  : " + ex.getMessage());
//        } catch (ApiException ex) { // در صورتی که خروجی وب سرویس 200 نباشد این خطارخ می دهد.
//            System.out.print("ApiException : " + ex.getMessage());
//        }
//
//    }

}
