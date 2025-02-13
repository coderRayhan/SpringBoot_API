package com.hrm.smartHR.base;

public class BaseUtils {
    public BaseResponse generateSuccessResponse(Object obj, String... message){
        BaseResponse response = new BaseResponse();
        response.setStatus(true);
        response.setData(obj);
        if(message.length > 1 && message[0] != null && message[1] != null){
            response.setMessage(message[0]);
            response.setMessageBn(message[1]);
        }
        return response;
    }

    public BaseResponse generateSuccessResponse(byte[] byteArray, String... message){
        BaseResponse res = new BaseResponse();
        res.setStatus(true);
        res.setByteDate(byteArray);
        if(message.length > 1 && message[0] != null && message[1] != null){
            res.setMessage(message[0]);
            res.setMessageBn(message[1]);
        }
        return res;
    }

    public BaseResponse generatedErrorResponse(Exception e){
        BaseResponse response = new BaseResponse();
        response.setStatus(false);
        response.setMessage(e.getMessage());
        return  response;
    }
}
