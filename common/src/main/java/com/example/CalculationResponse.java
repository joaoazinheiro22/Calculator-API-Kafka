import java.math.BigDecimal;

public class CalculationResponse {

    private BigDecimal result;

    private String requestId;

    public CalculationResponse() {
    }

    public CalculationResponse(BigDecimal result, String requestId) {
        this.result = result;
        this.requestId = requestId;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
