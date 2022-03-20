package Pojos;





public class Payment  implements java.io.Serializable {


     private Integer paymentId;
     private Integer studentId;
     private String paymentMethod;
     private Double amount;
     private Integer status;
     private String dateTime;
     private Integer userId;

    public Payment() {
    }

    public Payment(Integer studentId, String paymentMethod, Double amount, Integer status, String dateTime, Integer userId) {
       this.studentId = studentId;
       this.paymentMethod = paymentMethod;
       this.amount = amount;
       this.status = status;
       this.dateTime = dateTime;
       this.userId = userId;
    }

    public Payment(Integer paymentId) {
        this.paymentId = paymentId;
    }
    
   
    public Integer getPaymentId() {
        return this.paymentId;
    }
    
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }
    public Integer getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    public String getPaymentMethod() {
        return this.paymentMethod;
    }
    
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public Double getAmount() {
        return this.amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getDateTime() {
        return this.dateTime;
    }
    
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }




}


