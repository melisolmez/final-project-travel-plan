package dev.melis.travelplanapp.support.result;

public class CrudResult {

    private OperationResult result;
    private OperationFailureReason reason;
    private String message;
    private CrudResult(){}

    public OperationResult getResult() {
        return result;
    }

    public CrudResult setResult(OperationResult result) {
        this.result = result;
        return this;
    }

    public OperationFailureReason getReason() {
        return reason;
    }

    public CrudResult setReason(OperationFailureReason reason) {
        this.reason = reason;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CrudResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public static CrudResult success()
    {
        return new CrudResult()
                .setResult(OperationResult.SUCCESS);

    }

    public static CrudResult success(String message){
        return new CrudResult()
                .setResult(OperationResult.SUCCESS)
                .setMessage(message);
    }

    public static CrudResult failure(OperationFailureReason reason){
        return new CrudResult()
                .setResult(OperationResult.FAILED)
                .setReason(reason);
    }
    public static CrudResult failure(OperationFailureReason reason, String message){
        return new CrudResult()
                .setResult(OperationResult.FAILED)
                .setReason(reason)
                .setMessage(message);
    }
    public boolean isSuccess(){
        return result.equals(OperationResult.SUCCESS);
    }


}
